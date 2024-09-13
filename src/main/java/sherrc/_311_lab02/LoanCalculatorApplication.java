package sherrc._311_lab02;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class LoanCalculatorApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException { //Start the JavaFX application
        FXMLLoader fxmlLoader = new FXMLLoader(LoanCalculatorApplication.class.getResource("LoanCalculatorView.fxml")); //Locate and load FXML file
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Loan Calculator"); //Sets window title
        stage.setScene(scene); //Attach the scene to the window
        stage.setResizable(false); //Prevent window resizing
        stage.show(); //Display window
    }

    public static void main(String[] args) {
        launch(); //Main method to start application
    }
}
