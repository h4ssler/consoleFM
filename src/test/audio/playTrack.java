package test.audio;

import javazoom.jl.player.Player;

import java.io.BufferedInputStream;
import java.net.URL;

public class playTrack {
    
    public static void main(String[] args) throws Exception{
        String patch=
                "http://vpleer.ru/download/vk/?cs=9-1v4&d=p17&audio=d64d563642ef9a&song=Linkin+Park-Burn+It+Down";
        Player play = new Player(new BufferedInputStream(new URL(patch).openStream()));
        System.out.println("Началось воспроизведение");
        play.play();
        if(play.isComplete())
            System.out.println("Композиция закончилась");
            play.close();
    }


}
