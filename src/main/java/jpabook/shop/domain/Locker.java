package jpabook.shop.domain;

import jakarta.persistence.*;

public class Locker extends BaseEntity{
    @Id @GeneratedValue()
    @Column(name = "LOCKER_ID")
    private Long id;
    private String name;
    @OneToOne(mappedBy = "locker", fetch = FetchType.LAZY)
    private Member member;
}
