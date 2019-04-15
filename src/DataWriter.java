import java.io.IOException;

public class DataWriter extends DataAccess {

    String path;

    public DataWriter(String path){
        this.path = path;
    }

    public void writeToFile (String newData){

        String oldData = "";

        try {
            oldData = read(path);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            write(newData, path);
        } catch (IOException e) {
            try {
                write(oldData, path);
            } catch (IOException e1) {
                System.out.println("Writer Failed");
            }
        }

    }
}
