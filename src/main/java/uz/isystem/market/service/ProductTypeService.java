package uz.isystem.market.service;

import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.isystem.market.dto.ProductTypeDto;
import uz.isystem.market.exception.ServerBadRequestException;
import uz.isystem.market.model.ProductType;
import uz.isystem.market.repository.ProductTypeRepository;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductTypeService {
    @Autowired private ProductTypeRepository productTypeRepository;

    public ProductTypeDto get(Integer id){
        ProductType entity = getEntity(id);
        ProductTypeDto dto = new ProductTypeDto();
        convertEntityToDto(entity, dto);
        return dto;
    }

    public ProductType getEntityByName(String name){
        Optional<ProductType> optional = productTypeRepository.findByIdAndDeletedDateIsNull(name);
        if (optional.isEmpty()){
            throw new ServerBadRequestException("ProductType not found");
        }
        return optional.get();
    }

    public ProductTypeDto create(ProductTypeDto dto){
        ProductType entity = new ProductType();
        convertDtoToEntity(dto, entity);
        entity.setStatus("Faol");
        entity.setCreatedAt(LocalDateTime.now());
        productTypeRepository.save(entity);
        convertEntityToDto(entity, dto);
        return dto;
    }

    public ProductTypeDto update(Integer id, ProductTypeDto dto){
        ProductType entity = getEntity(id);
        entity.setUpdatedAt(LocalDateTime.now());
        convertDtoToEntity(dto, entity);
        productTypeRepository.save(entity);
        convertEntityToDto(entity, dto);
        return dto;
    }

    public Boolean delete(Integer id){
        ProductType productType = getEntity(id);
        productType.setDeletedAt(LocalDateTime.now());
        productType.setStatus("faol");
        productTypeRepository.save(productType);
        return true;
    }

    public List<ProductTypeDto> findAll(){
        List<ProductType> productTypeList = productTypeRepository.findAll();
        List<ProductTypeDto> dtoList = new LinkedList<>();
        for (ProductType productType : productTypeList){
            ProductTypeDto productTypeDto = new ProductTypeDto();
            convertEntityToDto(productType, productTypeDto);
            dtoList.add(productTypeDto);
        }
        return dtoList;
    }

    public void convertEntityToDto(ProductType productType, ProductTypeDto productTypeDto){
        productTypeDto.setId(productType.getId());
        productTypeDto.setName(productType.getName());
        productTypeDto.setStatus(productType.getStatus());
    }


    public void convertDtoToEntity(ProductTypeDto productTypeDto, ProductType productType){
        productType.setName(productTypeDto.getName());
        productType.setId(productTypeDto.getId());
        productType.setStatus(productTypeDto.getStatus());
    }


    public ProductType getEntity(Integer id){
        Optional<ProductType> optional = productTypeRepository.findById(id);

        if (optional.isEmpty() || optional.get().getDeletedAt() != null){
            throw new ServerBadRequestException("Product Type Not found");
        }
        return optional.get();
    }
}
