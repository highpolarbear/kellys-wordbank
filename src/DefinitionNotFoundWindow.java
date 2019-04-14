import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class DefinitionNotFoundWindow extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Stage stage = primaryStage;

        VBox definitionBox = new VBox();
        definitionBox.setPadding(new Insets(20,20,20,20));
        definitionBox.setSpacing(20);

        Text definitionText = new Text("Definition Not found");
        definitionText.setFont((new FontFetcher()).getFont("h3"));

        Text notFoundText = new Text("You dum dum");
        notFoundText.setFont((new FontFetcher()).getFont(25));

        definitionBox.getChildren().addAll(definitionText,notFoundText);

        Scene scene = new Scene(definitionBox);

        stage.setScene(scene);
        stage.setTitle("Definition Not Found");
        stage.show();
    }
}
