import de.umass.lastfm.*;
import java.util.*;
import java.text.DateFormat;
import java.util.Collection;


/**
 * Created by IntelliJ IDEA.
 * User: rio
 * Date: 23.04.15
 * Time: 17:35
 * Не проблемы должны толкать вас в спину, а вперед вести мечты.
 */
public class Start {
    public static void main(String[] args){
        Caller.getInstance().setUserAgent("tst");
        Caller.getInstance().setDebugMode(false);

        String key = "9d1fa626c7434de90d21b8588395d568"; //this is the key used in the Last.fm API examples
        String user = "h4ssler";
        String secret = "2524b49ea82a87d52cea3ff2aea699fa";   // api secret
        String password = "107355"; // user's password
        Session session = Authenticator.getMobileSession(user, password, key, secret);
        String apiKey = getApiKey(session);

        
        //PaginatedResult<Artist> recomendations = getRecArtists(session);
        Collection<User> neighbours = getNeighbours(user, key);

        ArrayList<User> users = new ArrayList<User>(neighbours);

        /*Блок для тестирования*/
        int rand = new Random().nextInt(10);
        System.out.println(rand);
        //System.out.println(copy.get(rand).getName());
        /*Блок для тестирования*/

        System.out.println("Рекомендованные вам композиции:");

        PaginatedResult<Track> yourRecomendations = getLoved(users.get(rand).getName(), key);
        
        for(Track t:yourRecomendations)
            System.out.println(t.getName() + " - " + t.getArtist());



        
    }


    public static String getApiKey(Session session){

        String apiKey = session.getApiKey();
        return apiKey;
    }
    
    public static PaginatedResult<Artist> getRecArtists(Session session){
        
        PaginatedResult<Artist> recommendedArtists = User.getRecommendedArtists(session);
        return recommendedArtists;
    }
    
    public static Collection<User> getNeighbours(String user, String key){
        Collection<User> neighbours = User.getNeighbours(user, key);
        return neighbours;
    }

    public static PaginatedResult<Track> getLoved(String user, String key){
        PaginatedResult<Track> lovedTracks = User.getLovedTracks(user, key);
        return lovedTracks;
    }
}
