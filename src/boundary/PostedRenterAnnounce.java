package boundary;

import bean.RenterAnnounceBean;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.IOException;

public class PostedRenterAnnounce {

    @FXML
    public Label address, description, ownerName, capacity, area, from, to, wifi, pets, parking, air, price;

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


    }
}