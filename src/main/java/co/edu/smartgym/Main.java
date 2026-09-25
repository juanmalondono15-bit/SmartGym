package co.edu.smartgym;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(
                Main.class.getResource("/co/edu/smartgym/view/principal.fxml")
        );

        Scene scene = new Scene(loader.load(), 1200, 780);
        scene.getStylesheets().add(
                Main.class.getResource("/co/edu/smartgym/css/styles.css").toExternalForm()
        );

        stage.setTitle("SmartGym - Gestión del gimnasio");
        stage.setMinWidth(1100);
        stage.setMinHeight(700);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
