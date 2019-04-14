import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class DefinitionFetcher {

    String word;

    public DefinitionFetcher(String word){
        this.word = word;
        word = word.replaceAll("", "%20");
    }

    public String fetch() throws IOException {

        String definition= null;

        String urlWord = "https://dictionary.cambridge.org/dictionary/english/".concat(word);

        URL url = new URL(urlWord);
        URLConnection con = url.openConnection();
        InputStream is =con.getInputStream();

        BufferedReader br = new BufferedReader(new InputStreamReader(is));

        String line = null;

        // read each line and write to System.out
        while ((line = br.readLine()) != null) {
            //System.out.println(line);
            if (line != null  && line.contains("<meta itemprop=\"headline\"")){

                //System.out.println(line);

                line = line.replaceAll("<(.*)content=", " ");

                //System.out.println(line);
                line = line.substring(line.indexOf("definition:"),line.indexOf("Learn more.\" />"));
                line = line.replaceAll(":", "");
                line = line.replaceAll("&quot;", "");
                line = line.replaceAll("  ", "\n");
                line = line.substring(("definition").length() + 1);

                definition = line;
            }
        }
        //System.out.println(definition);

        return definition;
    }

    public static void main(String[] args) {
        DefinitionFetcher df = new DefinitionFetcher("write your word here");
        try {
            df.fetch();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
