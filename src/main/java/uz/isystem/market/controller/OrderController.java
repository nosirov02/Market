package uz.isystem.market.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.isystem.market.dto.OrderDto;
import uz.isystem.market.service.OrderService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/order")
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getOrderById(@PathVariable Integer id){
        return ResponseEntity.ok(orderService.getOrderById(id));
    }

    @PostMapping
    public ResponseEntity<?> createOrder(@RequestBody OrderDto orderDto){
        orderService.createOrder(orderDto);
        return ResponseEntity.ok("New Order created !");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateOrder(@PathVariable Integer id,
                                         @RequestBody OrderDto orderDto){
        orderService.updateOrder(id, orderDto);
        return ResponseEntity.ok("Order successfully updated !");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOrder(@PathVariable Integer id){
        orderService.deleteOrderById(id);
        return ResponseEntity.ok("Order successfully deleted !");
    }

    @GetMapping
    public ResponseEntity<?> getAllOrders(){
        return ResponseEntity.ok(orderService.getAllOrders());
    }

}
