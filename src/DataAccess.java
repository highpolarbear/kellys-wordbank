import java.io.*;

public abstract class DataAccess {
    String filename = "userdata.txt";

    public String getFilename(){
        return filename;
    }

    public void write(String data, String filePath) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true));
        writer.append(data);
        writer.close();
    }

    public String read(String filePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line = null;
        String data = "";
        while ( (line =  reader.readLine()) != null) {
            data =  data  + reader.readLine() + "\n";
        }
        reader.close();

        return data;
    }
}
