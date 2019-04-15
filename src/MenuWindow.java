import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class MenuWindow extends Application {

    public static void main(String[] args) {
        launch(args);
        Stage stage = new Stage();
        MenuWindow main = new MenuWindow();
        main.start(stage);
    }

    Stage primaryStage;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;

        VBox mainBox = new VBox();
        mainBox.setPadding(new Insets(10, 10, 10, 10));
        mainBox.setAlignment(Pos.CENTER);
        mainBox.setSpacing(20);

        Text mainName = new Text("Kelly's Urban Word Bank !");
        mainName.setFont(getFont(40));


        Button create = new Button("Create a new Word(s) for dictionnary");
        Button find = new Button("Find word online!");
        Button view = new Button("View existing words in dictionnary");
        Button quit = new Button("Quit Word bank");
        Button about = new Button("About");
        find.setFont(getFont(20));
        view.setFont(getFont(20));
        create.setFont(getFont(20));

        find.setOnAction(e ->  launchCreateWindow());
        create.setOnAction(e -> launchCreateDefinitionWindow());
        view.setOnAction(e -> launchDefinitionTableWindow());
        quit.setOnAction(e -> System.exit(0));
        about.setOnAction(e -> launchAboutWindow());

        VBox buttonBox = new VBox();
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.setSpacing(5);

        buttonBox.getChildren().addAll(find, create, view);

        HBox bottomBox = new HBox();

        bottomBox.getChildren().add(about);
        bottomBox.getChildren().add(quit);

        bottomBox.setAlignment(Pos.CENTER_RIGHT);
        bottomBox.setSpacing(5);

        mainBox.getChildren().addAll(mainName, buttonBox, bottomBox);

        Scene mainScene = new Scene(mainBox);
        primaryStage.setScene(mainScene);
        primaryStage.setTitle("Kelly's Word Bank");
        primaryStage.show();
    }

    private Font getFont(int size) {
        FontFetcher fontFetcher = new FontFetcher();
        return  fontFetcher.getFont(size);
    }

    private void launchCreateWindow(){
        Stage createStage = new Stage();
        CreateWordWindow createWordWindow = new CreateWordWindow();
        createWordWindow.start(createStage);
    }

    private void launchAboutWindow(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About");
        alert.setHeaderText("Kelly's Word Bank");
        alert.setContentText("Version 1.0.0 - Beta" +
                            "\n" +
                            "\n" +
                            "Authors :  Terry Phung,  Fengqi Xu");

        alert.showAndWait();
    }

    private void launchDefinitionTableWindow(){
        Stage tableStage = new Stage();
        DefinitionTableWindow dtw = new DefinitionTableWindow();
        dtw.start(tableStage);
    }

    private void launchCreateDefinitionWindow(){
        Stage createDefinitionStage = new Stage();
        DefinitionCreateWindow dcw = new DefinitionCreateWindow();
        dcw.start(createDefinitionStage);
    }
}
