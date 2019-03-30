package services;

import entities.ArtistEntityEntity;
import entities.CdEntityEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Set;

public class CdService {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");

    EntityManager em = null;
    EntityTransaction tx = null;
//    private EntityManager em = emf.createEntityManager();
//    private EntityTransaction tx = em.getTransaction();


    public CdService(EntityManager em) {
        this.em = em;
        this.tx = em.getTransaction();

    }

    public CdService() { }


    public CdEntityEntity createCdArtist(String title, String description, String year, String price, Set<ArtistEntityEntity> artist ){

        CdEntityEntity cd = new CdEntityEntity();
        //   artist.setId(id);
        cd.setArtist(artist);
        cd.setTitle(title);
        cd.setDescription(description);
        cd.setYear(year);
        cd.setPrice(price);
        tx.begin();
        em.persist(cd);
        tx.commit();

        System.out.println("Service" +cd);
        return cd;

    }


    public CdEntityEntity createArtist(CdEntityEntity cdEntity){
        tx.begin();
        em.persist(cdEntity);
        tx.commit();
        System.out.println("new artist added:"+ cdEntity);
        return cdEntity;

    }

}
