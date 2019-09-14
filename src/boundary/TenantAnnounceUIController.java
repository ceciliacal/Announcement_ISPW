package boundary;

import bean.TenantAnnounceBean;
import bean.UserBean;
import control.ControllerTenantAnnounce;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.time.LocalDate;

public class TenantAnnounceUIController {

    @FXML
    public TextField titleField, nameField, cityField, room, bathrooms, people;

    @FXML
    public CheckBox wifi, garden, animalsAllowed, airConditioning, parking;

    @FXML
    public DatePicker idDateArr, idDateDep;

    @FXML
    public Button okBtn, deleteBtn, publishBtn;

    //private renterAnnounceBean bean;

    ControllerTenantAnnounce cta;

    private TenantAnnounceBean bean = new TenantAnnounceBean();

    Main notify = new Main();

    public void clickedPublishBtn(ActionEvent actionEvent) {



        bean.setTitle(titleField.getText());
        bean.setName(nameField.getText());
        bean.setCity(cityField.getText());
        bean.setRoom(Integer.parseInt(room.getText()));
        bean.setPeople(Integer.parseInt(people.getText()));
        bean.setBath(Integer.parseInt(bathrooms.getText()));

        //data
        bean.setDateArr(idDateArr.getValue());
        bean.setDateDep(idDateDep.getValue());


        if (wifi.isSelected()) {
            bean.setWifi("si");
        } else {
            bean.setWifi("no");
        }

        if (garden.isSelected()) {
            bean.setGarden("si");
        } else {
            bean.setGarden("no");
        }

        if (animalsAllowed.isSelected()) {
            bean.setAnimals("si");
        } else {
            bean.setAnimals("no");
        }

        if (airConditioning.isSelected()) {
            bean.setAirConditionig("si");
        } else {
            bean.setAirConditionig("no");
        }

        if (parking.isSelected()) {
            bean.setParking("si");
        } else {
            bean.setParking("no");
        }


        //System.out.println("city e name sono " + bean.getCity() +   bean.getName());

        //una volta inseriti i dati e cliccato su pubblica si chiude la finestra
        Stage stage = (Stage)titleField.getScene().getWindow();
        stage.close();

        cta = ControllerTenantAnnounce.getInstance();
        cta.createTenantAnnounce(bean);
    }


    public int checkDate() {



        System.out.println("oggi è: " + LocalDate.now());

        if (idDateArr.getValue().isBefore(LocalDate.now())) {
            System.out.println("data arr no");
            return 0;
        }

        if (idDateDep.getValue().isBefore(idDateArr.getValue()) || idDateDep.getValue().isEqual(idDateArr.getValue())) {
            System.out.println("data dep no");
            return 0;
        } else {
            System.out.println("data ok");
            return 2;

        }
    }

        /*
        if (yearDep < yearArr) {
            System.out.println("anno no");
            return 0;
        }
        if (yearDep == yearArr) {
            if (monthDep < monthArr) {
                System.out.println("mese no");
                return 0;
            }
            else if (monthDep == monthArr) {
                if (dayDep < dayArr) {
                    System.out.println("giorno no");
                    return 0;
                }
            }
        }
        System.out.println("data ok");
        return 1;

    } */


    public void clickedOkButton(ActionEvent actionEvent) {
        if (checkDate() == 0) {
            notify.notification(0, "DATA ERRATA", "Inserisci una data successiva a quella attuale!");
        }
        if (checkDate() == 1) {
            notify.notification(0, "DATA ERRATA", "Inserisci una data successiva a quella di arrivo!");
        }
        else if (checkDate() == 2) {
            notify.notification(1, "DATA INSERITA OK", "La data è stata inserita correttamente ");
        }
    }



    public void createStage(UserBean myBean) {
    }


    /*****
    public void showTenantAnnounce(TenantAnnounceBean bean) {

        titleField.setText(bean.getTitle());
        nameField.setText(bean.getName());
        cityField.setText(bean.getCity());
        room.setText(String.valueOf(bean.getRoom()));
        bathrooms.setText(String.valueOf(bean.getBath()));
        people.setText(String.valueOf(bean.getPeople()));


        System.out.println("showTenantAnnounce il bean del title è" + bean.getTitle());


    }
     ******/
}