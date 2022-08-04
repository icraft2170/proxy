package hello.proxy.app.v3;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class OrderServiceV3 {
    private final OrderRepositoryV3 orderRepository;

    public OrderServiceV3(OrderRepositoryV3 orderRepositoryV2) {
        this.orderRepository = orderRepositoryV2;
    }

    public void orderItem(String itemId) {
        orderRepository.save(itemId);
    }
}
