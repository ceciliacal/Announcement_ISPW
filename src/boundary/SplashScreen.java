package boundary;

import control.ControllerLogin;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class SplashScreen {

    public Label welcomeLabel;
    public Button accessButton;

    public Stage accessButtonHandler(ActionEvent actionEvent) {
        System.out.println("Qualcuno ha cliccato");

        Stage stage = (Stage)welcomeLabel.getScene().getWindow();   //prendo lo stage su cui si trova il widget
        return stage;
    }
}
