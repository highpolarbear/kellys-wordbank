import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class DataLoader extends DataAccess{
    
    public DataLoader(){
        String fileName = getFilename();
    }
    
    public ObservableList<Definition> loadData(){
        
        DataReader dr = new DataReader(filename);
        String data = dr.read();

        ObservableList<Definition> definitionData = FXCollections.observableArrayList();

        if (data != null) {

            String[] dataList = data.split("\n");

            for (String currentData : dataList) {
                String[] thisData = currentData.split(">>>");
                definitionData.add(new Definition(thisData[0], thisData[1]));
            }

            return definitionData;
        }

        else{
            return null;
        }
    }

    public void saveData(ObservableList<Definition> data){

        if (data != null) {

            DataWriter dw = new DataWriter(filename);

            String definitionLine = "Dictionary File -- Kelly's Word Bank -- Created By Terry Phung & Fengqi Xu" + "\n";

            for (Definition thisDef : data) {
                definitionLine = definitionLine.concat(thisDef.getDefinitionName().concat(">>>").concat(thisDef.getDefinition()).concat("\n"));
            }

            dw.writeToFile(definitionLine);
        }
    }

    public void appendData(Definition def){

        String definitionLine = def.getDefinitionName().concat(">>>").concat(def.getDefinition()).concat("\n");
        DataWriter dw  = new DataWriter(filename);
        dw.appendToFile(definitionLine);

    }
}
