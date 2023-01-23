package com.linkedin.events.order;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import static com.linkedin.events.order.Order.OrderStatus.COMPLETED;

@Slf4j
@RequiredArgsConstructor
@Component
public class OrderService
{
    private final OrderRepository orderRepository;

    private final ApplicationEventPublisher publisher;

    @Transactional
    public void placeOrder(Order order)
    {
        log.info("Placing and order {}", order);
        order.setStatus(COMPLETED);
        orderRepository.save(order);

        log.info("Publishing order completed event");
    }
}
