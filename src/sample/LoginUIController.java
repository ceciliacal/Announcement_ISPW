package sample;

import entity.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginUIController implements Initializable {
    @FXML
    private Button myButton;
    @FXML
    private TextField myTxt;
    @FXML
    private Label lblName;
    @FXML
    private PasswordField myPwd;

    String ID;
    String password;


    String idUser;
    String passwordUser;

    User myUser;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    public void clickedButton(ActionEvent actionEvent) throws Exception {
        ID = myTxt.textProperty().get();
        password = myPwd.textProperty().get();

        if (check(ID,password) == 1) {
            System.out.println("Login effettuato!");

            //compare nuova finestra

            Parent root= FXMLLoader.load(getClass().getResource("LoginResponse.fxml"));
            Stage primaryStage = new Stage();
            primaryStage.setTitle("LoginResponse");
            primaryStage.setScene(new Scene(root,600,600));
            primaryStage.show();

        }
        else {
            System.out.println("ERRORE: ID o password errati!");

        }
    }



    public int check(String myID, String myPWD) {
        myUser = new User();
        idUser = myUser.getID();
        passwordUser = myUser.getPassword();


        if (idUser.equals(myID) && passwordUser.equals(myPWD)) {
            return 1;
        }
        else {
            return 0;
        }
    }
}
