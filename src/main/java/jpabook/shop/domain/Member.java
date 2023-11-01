package jpabook.shop.domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Member{
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "MEMBER_ID")
    private Long id;
    @ManyToOne( fetch = FetchType.LAZY) //team을 프록시로 조회, 실제사용하는 시점에 초기화
    @JoinColumn(name = "TEAM_ID") // 조인할 컬럼명
    private Team team;
    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();
    @OneToOne( fetch = FetchType.LAZY)
    @JoinColumn(name = "LOCKER_ID")
    private Locker locker;
    private String name;

    //임베디드타입
    @Embedded
    private Period workPeriod;
    @Embedded
    private Address homeAddress;

    //Adress가 2개라면?  => AttributeOverrides, AttributeOverride 사용해서 컬럼명 재 정의
    @Embedded
    @AttributeOverrides({@AttributeOverride(name = "city",column = @Column(name = "EMP_CITY")),
            @AttributeOverride(name = "street",column = @Column(name = "EMP_STREET")),
            @AttributeOverride(name = "zipcode",column = @Column(name = "EMP_ZIPCODE"))})
    private Address workAddress;

/*
   **** 값 타입을 하나 이상 저장할 때 사용
*/
    @ElementCollection
    @CollectionTable(name = "FAVORITE_FOOD"
            , joinColumns = @JoinColumn(name = "MEMBER_ID"))
    @Column(name = "FOOD_NAME")
    private Set<String> favoriteFoods = new HashSet<>();
    @ElementCollection // => 수정시 테이블 전체 delete하고 다시 insert
    @CollectionTable(name = "ADDRESS"
            , joinColumns = @JoinColumn(name = "MEMBER_ID"))
    private List<Address> addressHistory = new ArrayList<>();


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

    public Team getTeam() {
        return team;
    }

    public void changeTeam(Team team) { // 연관 관계 객체일 경우 set 대신 다른 이름으로 저장하는거 추천!
        this.team = team;
        //연관 관계 편의 메소드 : 객체 지향 측면, 테스트시 양방향일 경우 양쪽에 다 값을 설정!
        team.getMembers().add(this);
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public Locker getLocker() {
        return locker;
    }

    public void setLocker(Locker locker) {
        this.locker = locker;
    }

    public Period getWorkPeriod() {
        return workPeriod;
    }

    public void setWorkPeriod(Period workPeriod) {
        this.workPeriod = workPeriod;
    }

    public Address getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(Address homeAddress) {
        this.homeAddress = homeAddress;
    }

    public Address getWorkAddress() {
        return workAddress;
    }

    public void setWorkAddress(Address workAddress) {
        this.workAddress = workAddress;
    }

    public Set<String> getFavoriteFoods() {
        return favoriteFoods;
    }

    public void setFavoriteFoods(Set<String> favoriteFoods) {
        this.favoriteFoods = favoriteFoods;
    }

    public List<Address> getAddressHistory() {
        return addressHistory;
    }

    public void setAddressHistory(List<Address> addressHistory) {
        this.addressHistory = addressHistory;
    }
}
