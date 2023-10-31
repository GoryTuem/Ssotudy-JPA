package jpabook.shop;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jpabook.shop.domain.Member;
import jpabook.shop.domain.Order;
import jpabook.shop.domain.Team;

import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {
            Team team = new Team();
            team.setName("TeamC");
            em.persist(team);

            Member member = new Member();
            member.setName("Member3");
            /* 중요@ 연관 관계 주인에 속한 객체에 set 해줘야함.
               저장시 틀린 예시 team.getMembers().add(member) => 디비에 저장 안됨.
             */
            member.changeTeam(team);
            em.persist(member);


            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }
}
