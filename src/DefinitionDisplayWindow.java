import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class DefinitionDisplayWindow extends Application {

    String definitionName;
    String definition;

    public DefinitionDisplayWindow(String word){

        this.definitionName = word;

        DefinitionFetcher df = new DefinitionFetcher(word);
        try {
            this.definition = df.fetch();
            if (this.definition != null){
            Stage stage = new Stage();
            start(stage);
            }
            else{
                Stage stage = new Stage();
                DefinitionNotFoundWindow dfnf = new DefinitionNotFoundWindow();
                dfnf.start(stage);
            }

        } catch (IOException e) {
            //definition not found
            System.out.println("System Error ! ");
        }


    }

    @Override
    public void start(Stage primaryStage) {
        Stage stage = primaryStage;

        VBox definitionBox = new VBox();
        definitionBox.setSpacing(15);
        definitionBox.setPadding(new Insets(20,20,20,20));

        String imageURL = "https://loremflickr.com/320/240/" + definitionName  + "/";
        Image image = new Image(imageURL);
        ImageView imageView = new ImageView(image);

        Text definitionNameText = new Text(definitionName);
        definitionNameText.setFont((new FontFetcher()).getFont("h3"));

        Text definitionText = new Text(definition);
        definitionText.setFont((new FontFetcher()).getFont("h2"));

        Button okbutton = new Button("OK");
        okbutton.setFont((new FontFetcher()).getFont("h1"));
        okbutton.setOnAction(e -> stage.close());

        definitionBox.getChildren().addAll(imageView,definitionNameText,definitionText, okbutton);

        Scene scene = new Scene(definitionBox);

        stage.setScene(scene);
        stage.setTitle(definitionName);
        stage.show();

    }
}
