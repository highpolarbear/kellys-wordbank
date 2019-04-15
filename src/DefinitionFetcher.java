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

        String urlWord = "https://www.urbandictionary.com/define.php?term=".concat(word);

        URL url = new URL(urlWord);
        URLConnection con = url.openConnection();
        InputStream is =con.getInputStream();

        BufferedReader br = new BufferedReader(new InputStreamReader(is));

        String line = null;
        String siteData = "";

        //DataWriter dw = new DataWriter("Site_Output_text.html");

        // read each line and write to System.out
        while ((line = br.readLine()) != null) {
            if (line != null && line.contains("<meta content=")) {


                //System.out.println(line);
                siteData += line;

            }
        }

        siteData = siteData.substring(siteData.indexOf("property=\"og:description\" /><meta content=") + ("property=\"og:description\" /><meta content=").length(), siteData.indexOf("name=\"twitter:description\" />"));

        siteData = siteData.replaceAll("&apos;","");
        //dw.writeToFile(siteData);

//        if (siteData.length() > 60){
//            String[] def = siteData.split(" ");
//            String siteDataNew = "";
//
//            System.out.println(def);

//            int i = 0;
//            while(i <  def.length - 1){
//                siteDataNew.concat(def[i]);
//                if (i >= 8){
//                    siteDataNew.concat("\n");
//                }
//                i++;
//            }
//
//            siteData = siteDataNew;
//        }

        definition = siteData;
        return definition;
    }

    public static void main(String[] args) {
        DefinitionFetcher df = new DefinitionFetcher("banana");
        try {
            df.fetch();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
