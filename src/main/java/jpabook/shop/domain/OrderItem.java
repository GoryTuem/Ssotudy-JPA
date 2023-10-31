package jpabook.shop.domain;

import jakarta.persistence.*;

@Entity
public class OrderItem extends BaseEntity{
    @Id @GeneratedValue()
    @Column(name = "ORDER_ITEM_ID")
    private Long id;
    @ManyToOne( fetch = FetchType.LAZY)
    @JoinColumn(name = "ORDER_ID")
    private Order order;
    @ManyToOne( fetch = FetchType.LAZY)
    @JoinColumn(name = "ITEM_ID")
    private Item item;
    private int orderPrice;
    private  int cnt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(int orderPrice) {
        this.orderPrice = orderPrice;
    }

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

}
