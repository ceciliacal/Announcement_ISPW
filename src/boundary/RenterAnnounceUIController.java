package boundary;

import bean.ApartmentBean;
import bean.RenterAnnounceBean;
import bean.UserBean;
import control.ControllerRenterAnnounce;
import entity.Apartment;
import entity.RenterAnnounce;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class RenterAnnounceUIController implements Initializable {

    public Label address;
    public Label description;
    public Label capacity;
    public Label area;
    //public Label ownerName;
    @FXML
    private TextField title, price;

    @FXML
    private Button publishButton;

    @FXML
    private ImageView image1, image2, image3, image4, image5;

    @FXML
    private Label servicesLabel, dateLabel, priceLabel, peopleLabel, areaLabel, fromLabel, toLabel;

    @FXML
    private CheckBox wifi, animalsAllowed, parking, airConditioning;

    @FXML
    private DatePicker fromDate, toDate;

    private RenterAnnounceBean bean=new RenterAnnounceBean();
    private Apartment myApt;

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

        ControllerRenterAnnounce cra= ControllerRenterAnnounce.getInstance();
        System.out.println("sto in Controller");
        cra.validateAnnounce(bean,myApt);
    }

    //stage su cui inserisco i dati e ci sono già i dati dell'appartamento presi dal DB
    //dati che già ho nel momento in cui vado a cliccare "pubblica"

    public void createStage(Apartment myApartment, UserBean myUserBean) {       //qua ci dovrebbe andare USER

        myApt = myApartment;
        address.setText(myApartment.getAddress());
        description.setText(myApartment.getDescription());
        capacity.setText(String.valueOf(myApartment.getCapacity()));
        area.setText(String.valueOf(myApartment.getArea()));
        //ownerName.setText(myUserBean.getNickname());

    }
}
