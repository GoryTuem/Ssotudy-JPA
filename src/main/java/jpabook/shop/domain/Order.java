package jpabook.shop.domain;

import OrderStatus.orderStatus;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order extends BaseEntity{
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
    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems = new ArrayList<>();
    @OneToOne
    @JoinColumn(name = "DELIVERY_ID")
    private Delivery delivery;
    private LocalDateTime orderDate;
    @Enumerated(EnumType.STRING)
    private orderStatus status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


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

    public void addOrderItem(OrderItem orderItem) {
        orderItems.add(orderItem);
        orderItem.setOrder(this);
    }
}
