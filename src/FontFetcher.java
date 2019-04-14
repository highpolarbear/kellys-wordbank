import javafx.scene.text.Font;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class FontFetcher {

    public Font getFont(int size){
        Font font;
        try {
            return font = Font.loadFont(new FileInputStream(new File("font/actionj.ttf")), size);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return font = Font.font("Verdana", size);
        }
    }

    public Font getFont(String name){

        Font font;
        int size = 5;

        if (name.equals("h1")){
            size= 20;
        }

        else if (name.equals("h2")){
            size= 25;
        }

        else if (name.equals("h3")){
            size= 30;
        }

        else if (name.equals("h4")){
            size= 35;
        }

        else if (name.equals("h5")){
            size= 40;
        }


        try {
            return font = Font.loadFont(new FileInputStream(new File("font/IBMPlexSerif-Light.ttf")), size);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return font = Font.font("Verdana", size);
        }
    }
}
