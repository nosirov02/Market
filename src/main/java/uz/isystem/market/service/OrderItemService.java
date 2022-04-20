package uz.isystem.market.service;

import org.springframework.stereotype.Service;
import uz.isystem.market.model.OrderItem;
import uz.isystem.market.repository.OrderItemRepository;

@Service
public class OrderItemService {
    private final OrderItemRepository orderItemRepository;

    public OrderItemService(OrderItemRepository orderItemRepository) {
        this.orderItemRepository = orderItemRepository;
    }

    public OrderItem get(Integer id){

return null;
    }
}
