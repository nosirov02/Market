package uz.isystem.market.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.isystem.market.dto.OrderItemDto;
import uz.isystem.market.service.OrderItemService;


@RestController
@RequiredArgsConstructor
@RequestMapping("api/orderItem")
public class OrderItemController {

    private final OrderItemService orderItemService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getOrderItemById(@PathVariable Integer id) {
        return ResponseEntity.ok(orderItemService.get(id));
    }

    @PostMapping
    public ResponseEntity<?> createdOderItem(@RequestBody OrderItemDto orderItemDto){
        orderItemService.createdOrderItem(orderItemDto);
        return ResponseEntity.ok("New OrderItem created");
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updatedOrderItem(@PathVariable Integer id,
                                              @RequestBody OrderItemDto orderItemDto){
        orderItemService.updatedOrderItem(id, orderItemDto);
        return ResponseEntity.ok("OrderItem successfully updated !");
    }
    @DeleteMapping("{id}")
    public ResponseEntity<?> deletedOrderItem(@PathVariable Integer id){
        orderItemService.deletedOrderItemById(id);
        return ResponseEntity.ok("OrderItem successfully deleted!");
    }
    @GetMapping
    public ResponseEntity<?> getAllOrderItems(){
        return ResponseEntity.ok(orderItemService.getAllOrderItems());
    }
}
