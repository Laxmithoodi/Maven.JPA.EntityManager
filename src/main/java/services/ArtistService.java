package services;

import entities.ArtistEntity;

import javax.persistence.*;
import java.util.List;

public class ArtistService {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");
    private EntityManager em = emf.createEntityManager();
    private EntityTransaction tx = em.getTransaction();


    public ArtistEntity createArtist(String firstName, String lastName, String instrument ){

        ArtistEntity artist = new ArtistEntity();
      //  artist.setId(id);
        artist.setFirstName(firstName);
        artist.setLastName(lastName);
        artist.setInstrument(instrument);
        tx.begin();
        em.persist(artist);
        tx.commit();

        return artist;
    }


    public ArtistEntity createArtist(ArtistEntity artistEntity){
        tx.begin();
        em.persist(artistEntity);
        tx.commit();
        return artistEntity;
    }

    public ArtistEntity findArtistById(Integer id){
        return em.find(ArtistEntity.class, id);

    }

    public ArtistEntity removeArtist(Integer id){
       // ArtistEntity artist = new ArtistEntity();
        ArtistEntity artist =   em.find(ArtistEntity.class, id);
        if(artist !=null){
            tx.begin();
            em.remove(artist);
            tx.commit();
        }
        return artist;

    }

    public List<ArtistEntity> findAllArtists(){


        TypedQuery<ArtistEntity> query=em.createQuery("select a from ArtistEntity a", ArtistEntity.class);
      List<ArtistEntity> listResults = query.getResultList();

        return listResults;
    }

    public ArtistEntity updateArtist(ArtistEntity artistEntity , String firstName){
        ArtistEntity artistEntity1 = em.merge(artistEntity);
        tx.begin();
      artistEntity1.setFirstName(firstName);
        tx.commit();
        return artistEntity1;

    }

}
