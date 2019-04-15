import java.io.BufferedReader;
import java.io.IOException;

public class DataReader extends DataAccess {

    BufferedReader reader;
    String filePath;

    public DataReader(String filePath){
        this.filePath = filePath;
    }

    public String loadData(){
        try {
            return read(filePath);
        } catch (IOException e) {
            return null;
        }
    }
}
