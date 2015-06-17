/**
* Created by IntelliJ IDEA.
* User: rio
* Date: 17.06.15
* Time: 15:18
* Не проблемы должны толкать вас в спину, а вперед вести мечты.
*/
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/**
 * Java Program to parse/read HTML documents from File using Jsoup library.
 * Jsoup is an open source library which allows Java developer to parse HTML
 * files and extract elements, manipulate data, change style using DOM, CSS and
 * JQuery like method.
 *
 * @author Javin Paul
 */
public class parse{

        static String patch ="";
    
    public static String parse(String singer, String song) {
        ArrayList<String> audios = new ArrayList<String>();
        Document doc;

        singer = singer.replace(" ", "+");
        song = song.replace(" ", "+");

        try {
            doc = Jsoup.connect("http://vpleer.ru/music/" + singer + "/").get();
            for (int i=0; i<20; i++)
            audios.add(doc.getElementById("icon" + i).toString());


        } catch (IOException e) {
            e.printStackTrace();
        }


        int i = 0;
        while(i < audios.size()){
            if (audios.get(i).toString().contains(singer + "-" + song)){
                int ind1 = audios.get(i).indexOf("=\"/");
                int ind2 = audios.get(i).indexOf("\" duration");
                patch = audios.get(i).substring(ind1+2, ind2);
                break;
            }
            i++;
        }

    return patch;
    }
}

