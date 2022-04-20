package uz.isystem.market.service;

import org.springframework.stereotype.Service;
import uz.isystem.market.dto.OrderItemDto;
import uz.isystem.market.exception.ServerBadRequestException;
import uz.isystem.market.model.OrderItem;
import uz.isystem.market.repository.OrderItemRepository;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderItemService {
    private final OrderItemRepository orderItemRepository;
    private final OrderService orderService;
    private final ProductService productService;

    public OrderItemService(OrderItemRepository orderItemRepository,
                            OrderService orderService,
                            ProductService productService) {
        this.orderItemRepository = orderItemRepository;
        this.orderService = orderService;
        this.productService = productService;
    }

    public OrderItemDto get(Integer id){
        OrderItem orderItem = getEntity(id);
        return convertEntityToDto(OrderItem , new OrderItemDto());
    }

    public void createdOrderItem(OrderItemDto orderItemDto){
        OrderItem orderItem = convertDtoToEntity(orderItemDto, new OrderItem());
        orderItem.setStatus("Faol");
        orderItem.setCreatedAt(LocalDateTime.now());
        orderItemRepository.save(orderItem);
    }

    public List<OrderItemDto> getAllOrderItems(){
        List<OrderItem> orderItemList = orderItemRepository.findAllByDeletedDateIsNull();
        if (orderItemList.isEmpty())
            throw new ServerBadRequestException("OrderItem not found!");

        return orderItemList.stream()
                .map(orderItem -> convertEntityToDto(orderItem, new OrderItemDto()))
                .collect(Collectors.toList());
    }
    public void deletedOrderItemById(Integer id){
        OrderItem orderItem = getEntity(id);
        orderItem.setDeletedAt(LocalDateTime.now());
        orderItemRepository.save(orderItem);
    }
    public void updatedOrderItem(Integer id, OrderItemDto orderItemDto){
        OrderItem orderItem = getEntity(id);
        convertDtoToEntity(orderItemDto, orderItem);
        orderItem.setUpdatedAt(LocalDateTime.now());
        orderItemRepository.save(orderItem);
    }
    public OrderItem getEntity(Integer id){
        return orderItemRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Order not found!"));
    }

    public OrderItemDto convertEntityToDto (OrderItem entity, OrderItemDto dto){
        dto.setId(entity.getId());
        dto.setProductId(entity.getProductId());
        dto.setStatus(entity.getStatus());
        dto.setCreatedDate(entity.getCreatedAt());
        dto.setUpdateDate(entity.getUpdatedAt());
        dto.setDeletedDate(entity.getDeletedAt());
        return dto;
    }


    public OrderItem convertDtoToEntity(OrderItemDto dto, OrderItem entity) {
        entity.setOrderId(dto.getOrderId());
        entity.setProductId(dto.getProductId());
        entity.setCreatedAt(dto.getCreatedDate());
        entity.setUpdatedAt(dto.getUpdateDate());
        entity.setDeletedAt(dto.getDeletedDate());
        return entity;

    }
}
