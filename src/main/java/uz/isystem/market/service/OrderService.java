package uz.isystem.market.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.isystem.market.repository.OrderRepository;

@RequiredArgsConstructor
@Service
public class OrderService {

    private final OrderRepository orderRepository;

}
