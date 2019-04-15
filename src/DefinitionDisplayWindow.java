import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class DefinitionDisplayWindow extends Application {

    String definitionName;
    String definition;
    Definition definitionFull;
    String  mode;

    public DefinitionDisplayWindow(String word){

        this.definitionName = word;
        this.mode = "net";
        UrbanDefinitionFetcher df = new UrbanDefinitionFetcher(word);
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
            Stage stage = new Stage();
            DefinitionNotFoundWindow dfnf = new DefinitionNotFoundWindow();
            dfnf.start(stage);
            //System.out.println("System Error ! ");
        }


    }

    public DefinitionDisplayWindow(Definition definition){

        this.mode = "local";

        this.definitionFull = definition;

        Stage stage = new Stage();
        start(stage);
    }

    @Override
    public void start(Stage primaryStage) {
        Stage stage = primaryStage;

        VBox definitionBox = new VBox();
        definitionBox.setSpacing(15);
        definitionBox.setPadding(new Insets(20,20,20,20));

        if(mode == "net") {

            String imageURL = "https://loremflickr.com/320/240/" + definitionName + "/";
            Image image = new Image(imageURL);
            ImageView imageView = new ImageView(image);

            Text definitionNameText = new Text(definitionName);
            definitionNameText.setFont((new FontFetcher()).getFont("h3"));

            Text definitionText = new Text(definition);
            definitionText.setFont((new FontFetcher()).getFont("h2"));

            Button okbutton = new Button("OK");
            okbutton.setFont((new FontFetcher()).getFont("h0.5"));
            okbutton.setOnAction(e -> stage.close());
            Button add = new Button("ADD");
            okbutton.setFont((new FontFetcher()).getFont("h0.7"));
            add.setOnAction(e ->  addDefinition(definitionName, definition));

            HBox bottomButton = new HBox();
            bottomButton.setSpacing(5);
            bottomButton.getChildren().addAll(okbutton, add);


            definitionBox.getChildren().addAll(imageView,definitionNameText,definitionText, bottomButton);

        }

        else if (mode =="local"){

            Text definitionNameText = new Text(definitionFull.getDefinitionName());
            definitionNameText.setFont((new FontFetcher()).getFont("h3"));

            Text definitionText = new Text(definitionFull.getFormattedDefinition());
            definitionText.setFont((new FontFetcher()).getFont("h2"));

            Button okbutton = new Button("OK");
            okbutton.setFont((new FontFetcher()).getFont("h0.5"));
            okbutton.setOnAction(e -> stage.close());

            HBox bottomButton = new HBox();
            bottomButton.setSpacing(5);
            bottomButton.getChildren().addAll(okbutton);


            definitionBox.getChildren().addAll(definitionNameText,definitionText, bottomButton);
        }


        Scene scene = new Scene(definitionBox);

        stage.setScene(scene);
        stage.setTitle(definitionName);
        stage.show();

    }

    private void addDefinition(String definitionName,String definition){

        definition = definition.replaceAll("\n", "/NL/");
        Definition thisDef = new Definition(definitionName, definition);
        DataLoader dl = new DataLoader();
        dl.appendData(thisDef);

    }

}
