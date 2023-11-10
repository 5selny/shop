package shop.allegro.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import shop.allegro.audit.Auditable;

@Entity
@Table(name = "item_img")
@Getter
@Setter
public class ItemImg extends Auditable {

    @Id
    @Column(name = "item_img_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String imgName;

    private String oriImgName;

    private String imgUrl;

    private String repImgYn;

    // 상품 엔티티와 다대일 단방향 관계로 매핑.
    // 지연 로딩을 설정하여 매핑된 상품 엔티티 정보가 필요할 경우 데이터를 조회하도록함
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    public void updateItemImg(String oriImgName, String imgName, String imgUrl){
        this.oriImgName = oriImgName;
        this.imgName = imgName;
        this.imgUrl = imgUrl;
    }
}
