import entities.ArtistEntityEntity;
import entities.CdEntityEntity;
import services.ArtistService;
import services.CdService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.HashSet;
import java.util.Set;

public class MainRunner {


    public static void main(String... args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        CdService service = new CdService(em);
        ArtistService service2 = new ArtistService();

        Set<ArtistEntityEntity> tcq = new HashSet<ArtistEntityEntity>();
        ArtistEntityEntity artist1 = new ArtistEntityEntity("Tip", "Top", "Flute");
        ArtistEntityEntity artist2 = new ArtistEntityEntity("Phife", "Dawg", "Chelo");
        ArtistEntityEntity artist3 = new ArtistEntityEntity("Shaheed", "Muhammad", "Guitar");
        ArtistEntityEntity artist4 = new ArtistEntityEntity("Jarobi", "White", "violin");

        tcq.add(artist1);
        tcq.add(artist2);


        Set<CdEntityEntity> mycds = new HashSet<CdEntityEntity>();

        CdEntityEntity cd1 = new CdEntityEntity("Scifi", "Scifi Music",
                "2012", "10", null);
        mycds.add(cd1);
        cd1.setArtist(tcq);


        System.out.println("Created CD" + service.createArtist(cd1));

    }
    }

//        CdEntityEntity cd1 = new CdEntityEntity("The Low End Theory", "Released: September 24, 1991","2001" ,"Hip Hop","200",null);
//        CdEntityEntity cd2 = new CdEntityEntity("The High End Theory", "Released: September 24, 1991","2003" ,"Hip Hop","200",null);
//        CdEntityEntity cd3 = new CdEntityEntity("The Urs End Theory", "Released: September 24, 1991","2004" ,"Hip Hop","200",null);


//        mycds.add(cd2);
//        mycds.add(cd3);



        //cd1.addartist(artist1);
        //cd1.addartist(artist2);
        //cd1.addartist(artist3);
        //cd1.addartist(artist4);





        //  em.persist(cd1);








