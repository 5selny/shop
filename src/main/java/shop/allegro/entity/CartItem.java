package shop.allegro.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import shop.allegro.audit.Auditable;

@Entity
@Getter
@Setter
@Table(name="cart_item")
public class CartItem extends Auditable {

    @Id
    @GeneratedValue
    @Column(name = "cart_item_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cart_id")
    private Cart cart;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    private int count;
}
