package shop.allegro.audit;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class  Auditable {

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime regTime;  //등록시간

    @LastModifiedDate
    @Column(updatable = false)
    private LocalDateTime updateTime;   //수정시간

    @CreatedBy
    @Column(updatable = false)
    private String createdBy;

    @LastModifiedBy
    @Column(updatable = false)
    private String modifiedBy;
}