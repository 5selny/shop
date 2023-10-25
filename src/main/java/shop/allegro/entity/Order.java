package shop.allegro.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import shop.allegro.constant.OrderStatus;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name="orders")
public class Order {

    @Id
    @GeneratedValue
    @Column(name = "order_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL,
               orphanRemoval = true)                          // 영속성 전이 옵션
    private List<OrderItem> orderItems = new ArrayList<>();

}
