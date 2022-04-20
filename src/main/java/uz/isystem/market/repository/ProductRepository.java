package uz.isystem.market.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.isystem.market.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
}
