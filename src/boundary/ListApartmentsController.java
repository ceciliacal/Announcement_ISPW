package boundary;

import bean.ApartmentBean;
import bean.UserBean;
import control.ControllerRenterAnnounce;
import dao.DBFunctions;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

import java.util.ArrayList;

public class ListApartmentsController {

    @FXML
    public ListView listView;

    @FXML
    public Button okBtn;

    private ApartmentBean aptBean= new ApartmentBean();

    public void clickedOkBtn(ActionEvent actionEvent) {         //prepara dati dell'annuncio selezionato nella listView

        String aptID;

        int aptIndex= listView.getSelectionModel().getSelectedIndex();  //prendo indice dell'apt selezionato su listView
        //String aptIndex= (String) listView.getSelectionModel().getSelectedItem();

        System.out.println("element="+aptIndex);
        ControllerRenterAnnounce cra= ControllerRenterAnnounce.getInstance();
        aptID=cra.aptIdByIndex(aptIndex);
        System.out.println("aptID is: " + aptID);

        aptBean.setIdApt(Integer.parseInt(aptID));

        //funzione per settare i dati di aptBean
        cra.cercoAppartamento(aptBean);



/*
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/boundary/RenterAnnounceUI.fxml"));
            Parent root = loader.load();
            RenterAnnounceUIController controller = loader.getController();
            controller.createStage(myBean);
            Scene scene = new Scene(root);

            Stage primaryStage = new Stage();

            primaryStage.setTitle("Select Apartment");
            primaryStage.setScene(scene);

            primaryStage.show();


        } catch (IOException e) {
            e.printStackTrace();
        }
*/
    }

    public void createListView(UserBean myBean) {      //creazione lista
        //funzione che crea query in controller, quindi chiamo controller e gli passo myBean.getId
        //funzione deve restituire la lista
        //costruisco lista

        ArrayList<String> nameApartmentsList;

        ControllerRenterAnnounce cra= ControllerRenterAnnounce.getInstance();
        nameApartmentsList=cra.createApartmentsList(myBean);

        for(int i=0;i<nameApartmentsList.size();i++){
            System.out.println("B: "+nameApartmentsList.get(i));

        }

        //converto nameApartmentsList in ObservableList per popolare la ListView

        ObservableList<String> listViewElements = FXCollections.observableList(nameApartmentsList);

        listView.setItems(listViewElements);

    }
}
