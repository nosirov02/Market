package uz.isystem.market.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import uz.isystem.market.model.ProductType;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductTypeRepository  extends JpaRepository<ProductType, Integer>, JpaSpecificationExecutor<ProductType> {


    Optional<ProductType> findByIdAndDeletedDateIsNull(String name );

    List<ProductType> findAllByDeletedDateIsNull();
}
