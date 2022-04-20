package uz.isystem.market.service;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import uz.isystem.market.dto.ProductDto;
import uz.isystem.market.model.Product;
import uz.isystem.market.repository.ProductRepository;

import java.time.LocalDateTime;

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






    // |- Secondary functions -|


    private void setProductType(ProductDto productDto) {
        // TODO: set productType to productDto
    }
}
