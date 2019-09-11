package boundary;

import bean.UserBean;
import control.ControllerLogin;
import entity.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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


    String ID2;
    String password2;

    User utente;

    private UserBean bean= new UserBean();



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }


    public void clickedButton(ActionEvent actionEvent){

        bean.setId(myTxt.textProperty().get());
        bean.setPassword(myPwd.textProperty().get());

        Stage stage = (Stage)myTxt.getScene().getWindow();


        ControllerLogin cl= ControllerLogin.getInstance();
        cl.validateLogin(bean,stage);



    }
}




