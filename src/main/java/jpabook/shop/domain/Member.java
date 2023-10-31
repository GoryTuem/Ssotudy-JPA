package jpabook.shop.domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Member extends BaseEntity{
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "MEMBER_ID")
    private Long id;
    @ManyToOne //관계가 무엇인지.
    @JoinColumn(name = "TEAM_ID") // 조인할 컬럼명
    private Team team;
    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();
    @OneToOne
    @JoinColumn(name = "LOCKER_ID")
    private Locker locker;
    private String name;
    private String city;
    private String street;
    private String zipcode;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
    public Team getTeam() {
        return team;
    }

    public void changeTeam(Team team) { // 연관 관계 객체일 경우 set 대신 다른 이름으로 저장하는거 추천!
        this.team = team;
        //연관 관계 편의 메소드 : 객체 지향 측면, 테스트시 양방향일 경우 양쪽에 다 값을 설정!
        team.getMembers().add(this);
    }

}
