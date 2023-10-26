package hellojpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        //필수(커넥션이라고 생각하면 됨.)
        EntityManager em = emf.createEntityManager();

        //트랜잭션 실행
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            // insert하기
            Member member = new Member();
            member.setId(1L);
            member.setName("소희");
            em.persist(member);

            /* 조회하고 업데이트하기
            Member findMember =em.find(Member.class, 1L);
            findMember.setName("최강호");
             */

            //트랜잭션 commit
            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }
}