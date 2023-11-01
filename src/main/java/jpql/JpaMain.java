package jpql;

import jakarta.persistence.*;

import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {

            Team team = new Team();
            team.setName("팀");
            em.persist(team);

            Member member = new Member();
            member.setName("소희");
            member.setAge(25);
            member.setTeam(team);
            em.persist(member);

            Team team2 = new Team();
            team2.setName("팀2");
            em.persist(team2);

            Member member2 = new Member();
            member2.setName("소희2");
            member2.setAge(29);
            member2.setTeam(team2);
            em.persist(member2);

            em.flush();
            em.clear();

            String query = "select m from Member m join fetch m.team";
            List<Member> resultList = em.createQuery(query, Member.class).getResultList();
            for (Member m : resultList) {
                System.out.println("member=" + m.getName() + m.getTeam().getName());
            }


            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }
}
