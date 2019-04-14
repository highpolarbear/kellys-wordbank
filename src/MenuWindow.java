import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MenuWindow extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    Stage primaryStage;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;

        VBox mainBox = new VBox();
        mainBox.setPadding(new Insets(10,10,10,10));
        mainBox.setAlignment(Pos.CENTER);
        mainBox.setSpacing(10);

        Text mainName = new Text("Kelly's Word Bank !");

        Button create = new Button("Create a new Word for dictionnary");
        Button view = new Button("View existing words");

        mainBox.getChildren().addAll(mainName,create,view);

        Scene mainScene = new Scene(mainBox);
        primaryStage.setScene(mainScene);
        primaryStage.setTitle("Kelly's Word Bank");
        primaryStage.show();
    }
}
