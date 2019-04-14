import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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

        Text mainName = new Text("Kelly's Word Bank !");
        mainName.setFont(getFont(40));

        Button create = new Button("Find word online!");//"Create new Word(s) for dictionnary");
        Button view = new Button("View existing words in dictionnary");
        Button quit = new Button("Quit Word bank");
        create.setFont(getFont(20));
        view.setFont(getFont(20));

        create.setOnAction(e ->  launchCreateWindow());
        quit.setOnAction(e -> System.exit(0));

        VBox buttonBox = new VBox();
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.setSpacing(5);

        buttonBox.getChildren().addAll(create, view);

        mainBox.getChildren().addAll(mainName, buttonBox, quit);

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
}
