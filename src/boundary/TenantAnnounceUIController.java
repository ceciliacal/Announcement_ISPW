package boundary;

import bean.TenantAnnounceBean;
import entity.TenantAnnounce;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.*;

import javax.management.Notification;
import java.net.URL;
import java.util.Calendar;
import java.util.ResourceBundle;

import javafx.util.Duration;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;


public class TenantAnnounceUIController implements Initializable {


    private static int yearArr;
    private static int dayArr;
    private static int monthArr;

    @FXML
    private Label lblDateArr, lblDateDep;

    @FXML
    private DatePicker idDateArr, idDateDep;

    @FXML
    private Button okBtn;

    @FXML
    private CheckBox wifi, garden, animalsAllowed, airConditioning, parking;

    @FXML
    private TextField tenantName, city, title;

    private TenantAnnounceBean bean;

    public void setBean(TenantAnnounceBean bean) {
        this.bean = bean;
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }




    public void publishBtnClicked(ActionEvent actionEvent) {

   bean.setTitle(title.getText());
   System.out.println("title is" + title);


    }



    public void deleteBtnClicked(ActionEvent actionEvent) {
    }

    public void selectDateArr(ActionEvent actionEvent) {
        //lblDateArr.setText(idDateArr.getValue().toString());
        //Calendar now = Calendar.getInstance();
        yearArr = (idDateArr.getValue().getYear());
        dayArr = (idDateArr.getValue().getDayOfMonth());
        monthArr = (idDateArr.getValue().getMonthValue());
        //  lblDateArr.setText(String.valueOf(idDateArr.getValue().getYear()));
        lblDateArr.setText(Integer.toString(yearArr));
        //System.out.println("l'anno è:" + Integer.toString(year));
    }


    public void selectDateDep(ActionEvent actionEvent) {
        //lblDateDep.setText(idDateDep.getValue().toString());
        int yearDep = (idDateDep.getValue().getYear());
        int dayDep = (idDateDep.getValue().getDayOfMonth());
        int monthDep = (idDateDep.getValue().getMonthValue());
        lblDateDep.setText(Integer.toString(yearArr));
        if (checkDate(yearDep, monthDep, dayDep) == 0) {
            System.out.println("ERRORE: scegli una data successiva a quella di partenza!");

        } else {
            System.out.println("La data scelta è corretta!");
        }
    }

    public int checkDate(int year, int month, int day) {

        if (year < yearArr) {
            return 0;
        } else {
            if (month < monthArr) {
                return 0;
            } else {
                if (day < dayArr) {
                    return 0;
                }
            }
        }
        return 1;
    }


    public void notification(ActionEvent actionEvent) {
       /* System.out.println("Bottone cliccato");
        Notifications.create()
                .title("ciao")
                .text("notifica")
                .showWarning(); */

        TrayNotification tray = new TrayNotification();
        AnimationType type = AnimationType.POPUP;
        tray.setAnimationType(type);
        tray.setTitle("ciao");
        tray.setMessage("come va");
        tray.setNotificationType(NotificationType.SUCCESS);
        tray.showAndDismiss(Duration.seconds(50));
    }



}
/*
    public void notifica() {
       // Notifications.create().title("Title Text").text("Ciao!").showWarning();
        Notifications notifica = Notifications.create()
                .title("Ciao")
                .text("errore")
                .graphic(null)
                .hideAfter(Duration.seconds(5))
                .position(Pos.TOP_RIGHT)
                .onAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        System.out.println("Ntifica");
                    }
                });
        notifica.showConfirm();
    } */
/*
    private void notification() {
         notifica = Notifications.create()
                .title("ciao")
                .text("hola")
                .graphic(null)
                .hideAfter(Duration.seconds(30))
                .position(Pos.TOP_RIGHT)
                .onAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        System.out.println("notifica");

                    }
                });

    }*/


