package shop.allegro.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import shop.allegro.audit.Auditable;

@Entity
@Table(name = "cart")
@Getter
@Setter
@ToString
public class Cart extends Auditable {

    @Id
    @Column(name = "card_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    @OneToOne(fetch = FetchType.LAZY)   // 회원 엔티티와 일대일 맵핑  // @OneToOne & @ManyToOne = 기본 FetchType.EAGER 즉시조회
    @JoinColumn(name = "member_id")     // member_id 를 외래키로 설정
    private Member member;
}
