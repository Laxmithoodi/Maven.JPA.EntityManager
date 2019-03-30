package services;

import entities.ArtistEntityEntity;

import javax.persistence.*;
import java.util.List;

public class ArtistService {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");
    private EntityManager em = emf.createEntityManager();
    private EntityTransaction tx = em.getTransaction();


    public ArtistEntityEntity createArtist(String firstName, String lastName, String instrument ){

        ArtistEntityEntity artist = new ArtistEntityEntity();
     //   artist.setId(id);
        artist.setFirstName(firstName);
        artist.setLastName(lastName);
        artist.setInstrument(instrument);
        tx.begin();
        em.persist(artist);
        tx.commit();

        System.out.println("Service" +artist);
        return artist;

    }


    public ArtistEntityEntity createArtist(ArtistEntityEntity artistEntity){
        tx.begin();
        em.persist(artistEntity);
        tx.commit();
        System.out.println("new artist added:"+ artistEntity);
        return artistEntity;

    }

    public ArtistEntityEntity findArtistById(Integer id){
        return em.find(ArtistEntityEntity.class, id);

    }

    public ArtistEntityEntity removeArtist(Integer id){
       // ArtistEntity_test artist = new ArtistEntity_test();
        ArtistEntityEntity artist =   em.find(ArtistEntityEntity.class, id);
        if(artist !=null){
            tx.begin();
            em.remove(artist);
            tx.commit();
        }
        return artist;

    }

    public List<ArtistEntityEntity> findAllArtists(){


       // TypedQuery<ArtistEntity_test> query=em.createQuery("select a from ArtistEntity_test a", ArtistEntity_test.class);
    //  List<ArtistEntity_test> listResults = query.getResultList();

       // return listResults;
        return null;
    }

    public void updateArtist(ArtistEntityEntity artistEntity , String firstName){
        ArtistEntityEntity artistEntity1 = em.merge(artistEntity);
        tx.begin();
        artistEntity1.setFirstName(firstName);
        tx.commit();
        System.out.println(artistEntity);

    }

}
