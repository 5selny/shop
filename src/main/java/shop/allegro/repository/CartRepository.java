package shop.allegro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import shop.allegro.entity.Cart;

public interface CartRepository extends JpaRepository <Cart, Long> {

}
