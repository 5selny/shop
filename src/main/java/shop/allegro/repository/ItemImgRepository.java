package shop.allegro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import shop.allegro.entity.ItemImg;

public interface ItemImgRepository extends JpaRepository<ItemImg, Long> {
}
