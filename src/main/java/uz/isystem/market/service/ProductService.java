package uz.isystem.market.service;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import uz.isystem.market.dto.ProductDto;
import uz.isystem.market.exception.ServerBadRequestException;
import uz.isystem.market.model.Product;
import uz.isystem.market.repository.ProductRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ModelMapper mapper;

    public ProductService(ProductRepository productRepository, ModelMapper mapper) {
        this.productRepository = productRepository;
        this.mapper = mapper;
    }

    public ProductDto create(ProductDto productDto) {
        // |- TODO check product type is exist -|
        Product product = mapper.map(productDto, Product.class);
        product.setStatus("Active");
        product.setCreatedDate(LocalDateTime.now());
        productRepository.save(product);
        productDto = mapper.map(product, ProductDto.class);
        setProductType(productDto);
        return productDto;
    }


    public List<ProductDto> getAll() {

        List<ProductDto> productDtoList = productRepository
                .getAllByDeleted_dateIsNull()
                .stream()
                .map(product -> mapper.map(product, ProductDto.class))
                .collect(Collectors.toList());

        if (!productDtoList.isEmpty()){
            for (ProductDto productDto : productDtoList){
                setProductType(productDto);
            }
            return productDtoList;
        }
        throw new ServerBadRequestException("Products not found1");
    }

    public ProductDto getOne(Integer id) {
        return mapper.map(getEntity(id), ProductDto.class);
    }



    // |- Secondary functions -|



    private Product getEntity(Integer id) {
        Optional<Product> optionalProduct = productRepository.getByIdAndDeleted_dateIsNull(id);

        if (optionalProduct.isEmpty()){
            throw new ServerBadRequestException("Product not found!");
        }
        return optionalProduct.get();
    }

    private void setProductType(ProductDto productDto) {
        // TODO: set productType to productDto
    }
}
