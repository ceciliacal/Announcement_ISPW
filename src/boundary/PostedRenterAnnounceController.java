package boundary;

import bean.RenterAnnounceBean;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class PostedRenterAnnounceController {

    @FXML
    public Label address, description, ownerName, capacity, area, from, to, wifi, pets, parking, air, title, price;
    public Button backBtn;

    public void showRenterAnnounce(RenterAnnounceBean bean) throws IOException  {

        System.out.println("id è " + bean.getIdApt());
        System.out.println("addresso "+ bean.getAddress());
        System.out.println("descr" + bean.getDescription());
        System.out.println("capacity" + bean.getCapacity());
        System.out.println("area" + bean.getArea());
        System.out.println("price "+ bean.getPrice());
        System.out.println("from" + bean.getFromDate());
        System.out.println("to "+ bean.getToDate());
        System.out.println("title" + bean.getTitle());
        System.out.println("wifi" + bean.getWifi());
        System.out.println("animals" + bean.getAnimals());
        System.out.println("parking" + bean.getParking());
        System.out.println("air" + bean.getAirConditioning());


        address.setText(bean.getAddress());
        description.setText(bean.getDescription());

        capacity.setText(String.valueOf(bean.getCapacity()));
        area.setText(String.valueOf(bean.getArea()));
        from.setText(String.valueOf(bean.getFromDate()));
        to.setText(String.valueOf(bean.getToDate()));
        wifi.setText(bean.getWifi());
        pets.setText(bean.getAnimals());
        air.setText(bean.getAirConditioning());
        price.setText(String.valueOf(bean.getPrice()));
        title.setText(bean.getTitle());
        parking.setText(bean.getParking());


    }

    public void clickedBackButton(ActionEvent actionEvent) {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/boundary/Menu.fxml"));
            Stage stage = (Stage)area.getScene().getWindow();
            stage.setScene(new Scene(loader.load()));

            stage.show();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}