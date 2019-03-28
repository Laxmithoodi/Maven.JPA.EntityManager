import entities.ArtistEntity;
import services.ArtistService;

public class MainRunner {


    public static void main(String ...args) {

        ArtistService artistService = new ArtistService();

        //Create Artist
        ArtistEntity artistEntity = artistService.createArtist("Acura", "Coupe", "Horn");
       System.out.println(artistEntity);

        //Find Artist by Id
      //  System.out.println("Artist exists:" + artistService.findArtistById(101));

       // System.out.println("Artist removed: " + artistService.removeArtist(111));
      //  System.out.println("display All Artists list" + "\n" + artistService.findAllArtists());

      //  System.out.println("Updated Artist: " + artistService.updateArtist(artistEntity,"tester"));

    }

}
