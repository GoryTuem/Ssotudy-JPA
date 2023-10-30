package jpabook.shop.domain;

import OrderStatus.orderStatus;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue()
    @Column(name = "ORDER_ID")
    private Long id;
    /* 객체를 테이블에 맞추어 모델링 => 잘못된 설계!!
    @Column(name = "MEMBER_ID")
    private Long memberId;*/
    @ManyToOne //다대일
    @JoinColumn(name="MEMBER_ID")
    private Member member;
    private LocalDateTime orderDate;
    @Enumerated(EnumType.STRING)
    private orderStatus status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

/*    public Long getMemberId() {
        return memberId;
    }*/

/*    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }*/

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public orderStatus getStatus() {
        return status;
    }

    public void setStatus(orderStatus status) {
        this.status = status;
    }
}
