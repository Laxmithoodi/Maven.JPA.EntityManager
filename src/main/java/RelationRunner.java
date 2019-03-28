import entities.ArtistEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class RelationRunner {

    public static void main(String ...args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");
       // EntityManager em = emf.createEntityManager();
        EntityManager em = emf.createEntityManager();
        em.find(ArtistEntity.class, 101);



    }
}

