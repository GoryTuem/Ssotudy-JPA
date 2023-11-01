package jpabook.shop;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jpabook.shop.domain.*;

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
           //값 타입 컬렉션 사용하기 => 라이프 사이클이 member를 따라감.
           member.setHomeAddress(new Address("city1","street","zipcode"));
           member.getFavoriteFoods().add("치킨");
           member.getFavoriteFoods().add("피자");
           member.getFavoriteFoods().add("곱창");

           member.getAddressHistory().add(new Address("city2","street2","zipcode2"));
           member.getAddressHistory().add(new Address("city3","street3","zipcode3"));
           em.persist(member);

           em.flush();
           em.clear();

            Member fmember = em.find(Member.class,member.getId());

            fmember.getFavoriteFoods().remove("치킨");
            fmember.getFavoriteFoods().add("한식");

            fmember.getAddressHistory().remove(new Address("city2","street2","zipcode2"));
            fmember.getAddressHistory().add(new Address("citycity","streettreet","zipcodecode"));


            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }
}
