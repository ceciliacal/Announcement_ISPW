package boundary;

import bean.RenterAnnounceBean;
import bean.TenantAnnounceBean;
import control.ControllerShowDashboard;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

import java.util.ArrayList;

public class ShowDashboardUIController {

    public ListView listViewTenant;
    public ListView listViewRenter;
    public Button okBtn;

    public ArrayList<RenterAnnounceBean> rList;

    public ArrayList<TenantAnnounceBean> tList;


    //ControllerShowDashboard myController;


/*
    public void ShowDashboardUIController(ControllerShowDashboard controller) {

        this.myController = controller;
    } */

    public void clickedOkBtn(ActionEvent actionEvent) {

        //quando premo ok chiamo funzione del control createListApartments ch emi restituisce le due iste di bean
        //quando premo ok a seconda se ho scelto un ann di renter o tenant vado nel template e non devo fare più niente perchè gia passo un bran!
        //PROBLEMA : come faccio a sapere da quale lista lo prendo??????
        //se non selezioni niente da una lista allora avrai selezionato dall'altra (controllo gli indici oppure i nomi selezionati, se uno è null allora l'avrò preso dall'altra lista






    }

    public void createListViewAnnounces(ArrayList<RenterAnnounceBean> renterList, ArrayList<TenantAnnounceBean> tenantList) {

        ArrayList<String> announcesRenterList = new ArrayList<>();

        for (int i=0; i < renterList.size(); i++) {
            announcesRenterList.add(renterList.get(i).getTitle());
        }


        ObservableList<String> listViewRenterElements = FXCollections.observableList(announcesRenterList);
        listViewRenter.setItems(listViewRenterElements);


        ArrayList<String> announcesTenantList = new ArrayList<>();

        for (int i=0; i < tenantList.size(); i++) {
            announcesTenantList.add(tenantList.get(i).getName());
        }


        ObservableList<String> listViewTenantElements = FXCollections.observableList(announcesTenantList);

        listViewTenant.setItems(listViewTenantElements);

        rList = renterList;
        tList = tenantList;
    }
}
