package boundary;

import bean.RenterAnnounceBean;
import entity.RenterAnnounce;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;

public class RenterAnnounceUIController implements Initializable {

    @FXML
    private TextField title, address, price;

    @FXML
    private Button deleteButton, publishButton;

    @FXML
    private ImageView image1, image2, image3, image4, image5;

    @FXML
    private TextArea description;

    @FXML
    private Label servicesLabel, dateLabel, priceLabel, peopleLabel, areaLabel, fromLabel, toLabel;

    @FXML
    private CheckBox wifi, animalsAllowed, parking, airConditioning;

    @FXML
    private DatePicker fromDate, toDate;

    private RenterAnnounceBean bean;

    //public void setBean(){this.bean=new RenterAnnounceBean();}


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }


    public void publishButtonClicked (ActionEvent actionEvent) throws Exception {

        bean.setTitle(title.getText());
        bean.setPrice(Float.parseFloat(price.getText()));
        bean.setFromDate(fromDate.getValue());
        bean.setToDate(toDate.getValue());
        bean.setWifi(wifi.isSelected());
        bean.setAnimals(animalsAllowed.isSelected());
        bean.setParking(parking.isSelected());
        bean.setAirConditioning(airConditioning.isSelected());

        System.out.println("bean.title="+bean.getTitle());
    }


    public void publishButtonClicked(javafx.event.ActionEvent event) {
        RenterAnnounceBean rab= new RenterAnnounceBean();

        bean.setTitle(title.getText());
        bean.setPrice(Float.parseFloat(price.getText()));
        bean.setFromDate(fromDate.getValue());
        bean.setToDate(toDate.getValue());
        bean.setWifi(wifi.isSelected());
        bean.setAnimals(animalsAllowed.isSelected());
        bean.setParking(parking.isSelected());
        bean.setAirConditioning(airConditioning.isSelected());

        System.out.println("bean.title="+bean.getTitle());
    }
}
