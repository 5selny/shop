package shop.allegro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import shop.allegro.entity.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
