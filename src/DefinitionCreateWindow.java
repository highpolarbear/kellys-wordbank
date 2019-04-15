import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class DefinitionCreateWindow extends Application {

    Stage stage;

    @Override
    public void start(Stage primaryStage) {
        this.stage = primaryStage;

        Text titleText = new Text("Add a Definition");
        titleText.setFont((new FontFetcher()).getFont(30));

        VBox nameBox = new VBox();
        nameBox.setSpacing(5);
        Text definitionName = new Text("Definition Name");
        definitionName.setFont((new  FontFetcher()).getFont(20));
        TextField definitionNameInput = new TextField();
        nameBox.getChildren().addAll(definitionName,definitionNameInput);

        VBox definitionBox = new VBox();
        nameBox.setSpacing(5);
        Text definitionValue = new Text("Definition");
        definitionValue.setFont((new  FontFetcher()).getFont(20));
        TextField definitionValueInput = new TextField();
        nameBox.getChildren().addAll(definitionValue,definitionValueInput);

        Text infoText = new Text("");
        infoText.setFont((new FontFetcher()).getFont("h0.5"));
        Button okButton =  new Button("OK");
        okButton.setOnAction(e -> addDefinition(definitionNameInput,definitionValueInput, infoText));
        Button close = new Button("Close");
        close.setOnAction(e -> stage.close());

        HBox bottomButton = new HBox();
        bottomButton.setSpacing(5);
        bottomButton.getChildren().addAll(okButton,close,infoText);

        VBox textFieldBox = new VBox();
        textFieldBox.setSpacing(15);
        textFieldBox.getChildren().add(nameBox);
        textFieldBox.getChildren().add(definitionBox);
        textFieldBox.getChildren().add(bottomButton);


        VBox mainBox = new VBox();
        mainBox.getChildren().add(titleText);
        mainBox.getChildren().add(textFieldBox);
        mainBox.setSpacing(20);
        mainBox.setPadding(new Insets(20,20,20,20));

        Scene scene = new Scene(mainBox);
        stage.setScene(scene);
        stage.show();
    }

    private void addDefinition(TextField nameInput, TextField valueInput, Text infoText){
        String name = nameInput.getText();
        String value = valueInput.getText();

        System.out.println(name + value);

        if ((name.length() >= 1 ) && ( value.length() >= 1)) {
            Definition thisDefinition = new Definition(name, value);
            DataLoader dl = new DataLoader();
            dl.appendData(thisDefinition);
            infoText.setText("Defintion Successfully added !");
        }

        else {
            infoText.setText("Name/Definition can not be empty !");
        }

        nameInput.setText("");
        valueInput.setText("");
    }
}
