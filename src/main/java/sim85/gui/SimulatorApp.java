package sim85.gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * Entry point for the 8085 Simulator JavaFX application.
 * This class must be referenced in pom.xml's <mainClass> for `mvn javafx:run` to work.
 */
public class SimulatorApp extends Application {

    @Override
    public void start(Stage stage) {
        StackPane root = new StackPane(new Label("8085 Simulator - setup working"));
        Scene scene = new Scene(root, 640, 480);
        stage.setTitle("8085 Microprocessor Simulator");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        
        launch(args);
    }
}
