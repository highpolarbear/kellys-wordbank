import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;

public class DefinitionTableWindow extends Application {

    Stage stage;

    @Override
    public void start(Stage primaryStage) {

        this.stage = primaryStage;
        stage.setTitle("Exiting Definitions");

        Text titleText = new Text("Existing Definitions");

        titleText.setFont((new FontFetcher()).getFont(30));

        TableColumn definitionName = new TableColumn("Word");
        definitionName.setCellValueFactory(new PropertyValueFactory<Definition, String>("definitionName"));

        TableColumn definitionDscp = new TableColumn("Definition");
        definitionDscp.setCellValueFactory(new PropertyValueFactory<Definition, String>("definition"));

        ObservableList<Definition> data = (new DataLoader()).loadData();

        Button okbutton = new Button("OK");
        okbutton.setOnAction(e -> stage.close());

        Button save = new Button("Save");
        save.setOnAction(e -> saveData(data));

        TableView mainTable = new TableView();
        mainTable.setEditable(true);
        mainTable.getColumns().add(definitionName);
        mainTable.getColumns().add(definitionDscp);
        mainTable.setItems(data);

        HBox bottombutton = new HBox();
        bottombutton.getChildren().add(okbutton);
        bottombutton.getChildren().add(save);
        bottombutton.setSpacing(10);

        VBox mainBox = new VBox();
        mainBox.getChildren().add(titleText);
        mainBox.getChildren().add(mainTable);
        mainBox.getChildren().add(bottombutton);
        mainBox.setSpacing(10);
        mainBox.setPadding(new Insets(10,10,10,10));

        Scene mainScene = new Scene(mainBox);

        stage.setScene(mainScene);
        stage.show();

    }

    private void saveData(ObservableList<Definition> data){
        DataLoader dl = new DataLoader();
        dl.saveData(data);
    }
}
