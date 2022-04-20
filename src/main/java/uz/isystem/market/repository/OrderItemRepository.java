package uz.isystem.market.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import uz.isystem.market.model.OrderItem;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Integer>, JpaSpecificationExecutor<OrderItem> {
    Optional<OrderItem> findByIdAndDeletedDateIsNull(Integer id);

    List<OrderItem> findAllByDeletedDateIsNull();
}
