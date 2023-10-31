package jpabook.shop.domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Team {
    @Id
    @GeneratedValue()
    @Column(name = "TEAM_ID")
    private Long id;
    private String name;

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }

    //양방향 맵핑 팀에서도 멤버 객체들을 담을 수 있음.
    @OneToMany(mappedBy = "team")
    private List<Member> members = new ArrayList<>();

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

}
