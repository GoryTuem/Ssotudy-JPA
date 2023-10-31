package jpabook.shop;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jpabook.shop.domain.Member;
import jpabook.shop.domain.Movie;
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
           Member member = new Member();
           member.setName("소희");
           em.persist(member);

           em.flush();
           em.clear();

            //Member findMsember = em.find(Member.class, member.getId());

            Member findMsember = em.getReference(Member.class, member.getId());
            //getReference 는 실제 사용되는 시점에 조회를 함.
            System.out.println("findMember" + findMsember.getName());



            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }
}
