package uz.isystem.market.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.isystem.market.dto.OrderDto;
import uz.isystem.market.exception.ServerBadRequestException;
import uz.isystem.market.model.Order;
import uz.isystem.market.repository.OrderRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class OrderService {

    private final OrderRepository orderRepository;

//    Orderni ID bo'yicha olish

    public OrderDto getOrderById(Integer id){
        Order order = getEntity(id);
        return convertEntityToDto(order, new OrderDto());
    }

//    Yangi Order yaratish

    public void createOrder(OrderDto orderDto){
        Order order = convertDtoToEntity(orderDto, new Order());
        order.setStatus("Faol");
        order.setCreatedDate(LocalDateTime.now());
        orderRepository.save(order);
    }

//    Barcha Orderlarni olish

    public List<OrderDto> getAllOrders(){
        List<Order> orderList = orderRepository.findAllByDeletedDateIsNull();
        if(orderList.isEmpty())
            throw new ServerBadRequestException("Order not found !");

        return orderList.stream()
                .map(order -> convertEntityToDto(order, new OrderDto()))
                .collect(Collectors.toList());
    }

//    Order o'chirish

    public void deleteOrderById(Integer id){
        Order order = getEntity(id);
        order.setDeletedDate(LocalDateTime.now());
        orderRepository.save(order);
    }

//    Order yangilash

    public void updateOrder(Integer id, OrderDto orderDto){
        Order order = getEntity(id);
        convertDtoToEntity(orderDto, order);
        order.setUpdateDate(LocalDateTime.now());
        orderRepository.save(order);
    }

    // Secondary functions

    public Order getEntity(Integer id){
        return orderRepository.findById(id)
                .orElseThrow(() -> new ServerBadRequestException("Order not found !"));
    }

    public OrderDto convertEntityToDto(Order entity, OrderDto dto){
        dto.setId(entity.getId());
        dto.setContact(entity.getContact());
        dto.setAddress(entity.getAddress());
        dto.setRequirement(entity.getRequirement());
        dto.setDeliveryDate(entity.getDeliveryDate());
        dto.setDeliveredDate(entity.getDeliveredDate());
        dto.setStatus(entity.getStatus());
        dto.setUserId(entity.getUserId());
        dto.setCreatedDate(entity.getCreatedDate());
        dto.setUpdateDate(entity.getUpdateDate());
        dto.setDeletedDate(entity.getDeletedDate());
        // Todo set User entity (Doston aka)

        return dto;
    }

    public Order convertDtoToEntity(OrderDto dto, Order entity){
        entity.setAddress(dto.getAddress());
        entity.setContact(dto.getContact());
        entity.setDeliveryDate(dto.getDeliveryDate());
        entity.setUserId(dto.getUserId());
        entity.setRequirement(dto.getRequirement());

        return entity;
    }

}
