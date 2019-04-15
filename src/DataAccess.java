import java.io.*;

public abstract class DataAccess {
    String filename = "userdata.txt";

    public String getFilename(){
        return filename;
    }

    public void write(String data, String filePath) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, false));
        writer.write(data);
        writer.close();
    }

    public void appendWrite(String data, String filePath) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true));
        writer.write(data);
        writer.close();
    }


    public String read(String filePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line = null;
        String data = "";
        reader.readLine();

        while ( (line =  reader.readLine()) != null) {
            if (line != ">>>") {
                data = data + line + "\n";
            }
        }
        reader.close();

        if (data != "") {
            return data;
        }
        else{
            return null;
        }
    }
}
