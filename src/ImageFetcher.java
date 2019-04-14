import javafx.scene.image.Image;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.net.URL;

public class ImageFetcher {

    String word;

    public  ImageFetcher(String word){
        this.word = word;
    }

    public Image fetch(){

        Image image = null;

        image = new Image("http://loremflickr.com/320/240/" + word);

        return image;
    }

    public Image fetch(String specWord){

        Image image = null;

        image = new Image("http://loremflickr.com/320/240/" + specWord);

        return image;
    }
}
