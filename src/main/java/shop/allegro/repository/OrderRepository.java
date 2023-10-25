package shop.allegro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import shop.allegro.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
