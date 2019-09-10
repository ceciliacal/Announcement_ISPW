package boundary;

import entity.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import javax.swing.*;
import javax.swing.text.View;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }



    public void Message(ActionEvent actionEvent) {
        ID = myTxt.textProperty().get();
        // System.out.println("ID = " + ID);
        password = myPwd.textProperty().get();
        // System.out.println("PWD = " + password);

        if (check(ID,password) == 1) {
            System.out.println("Login effettuato!");
        }
        else {
            System.out.println("ERRORE: ID o password errati!");

        }
    }



    public int check(String myID, String myPWD) {
        utente= new User();
        ID2 = utente.getID();
        password2 = utente.getPassword();
        //System.out.println("myID =" + myID + " myPWD =" + myPWD);
        //System.out.println("ID2 =" + ID2 + " password2 =" + password2);

        //ID2.equals(myID)

        if (ID2.equals(myID) && password2.equals(myPWD)) {
            return 1;
        } else {
            return 0;
        }
    }

/*
        private class KeyHandler implements KeyListener {


            @Override
            public void keyTyped(KeyEvent e) {

            }

            public void keyPressed(KeyEvent ke) {
                if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
                    myButton.requestFocus();
                    = (myButton)ke.getSource();
                    System.out.println("invio");
                }

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        } */
    }