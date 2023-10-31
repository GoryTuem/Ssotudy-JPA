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
            Movie movie = new Movie();
            movie.setDirector("aa");
            movie.setActor("bb");
            movie.setName("바람과함께 사라지다");
            movie.setPrice(1000);
            em.persist(movie);

            em.flush();
            em.clear();


            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }
}
