package boundary;

import bean.RenterAnnounceBean;
import bean.UserBean;
import entity.RenterAnnounce;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;

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

    private RenterAnnounceBean bean=new RenterAnnounceBean();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }


    public void publishButtonClicked(ActionEvent actionEvent) {
        bean.setTitle(title.getText());
        bean.setPrice(Float.parseFloat(price.getText()));
        bean.setFromDate(fromDate.getValue());
        bean.setToDate(toDate.getValue());

        if (wifi.isSelected()){
            bean.setWifi("si");
        }
        else{
            bean.setWifi("no");
        }

        if (animalsAllowed.isSelected()){
            bean.setAnimals("si");
        }
        else{
            bean.setAnimals("no");
        }

        if (parking.isSelected()){
            bean.setParking("si");
        }
        else{
            bean.setParking("no");
        }

        if (airConditioning.isSelected()){
            bean.setAirConditioning("si");
        }
        else{
            bean.setAirConditioning("no");
        }

        System.out.println("bean.title="+bean.getTitle());
    }

    public void createStage(UserBean myBean) {
    }
}
