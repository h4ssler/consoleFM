import javazoom.jl.player.Player;

import java.io.BufferedInputStream;
import java.net.URL;

public class playTrack {
    
    public static void play(String patch) throws Exception{
        patch="http://vpleer.ru" + patch.replace("&amp;", "&");
        Player play = new Player(new BufferedInputStream(new URL(patch).openStream()));
        System.out.println("Началось воспроизведение");
        play.play();
        if(play.isComplete())
            System.out.println("Композиция закончилась");
            play.close();
    }


}
