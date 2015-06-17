package test.audio;

import javazoom.jl.player.Player;

import java.io.BufferedInputStream;
import java.net.URL;

public class playTrack {
    
    public static void main(String[] args) throws Exception{
        Player play = new Player(new BufferedInputStream(new URL("http://zv.fm/download/1359997").openStream()));
        System.out.println("Началось воспроизведение");
        play.play();
        if(play.isComplete())
            System.out.println("Композиция закончилась");
            play.close();
    }


}
