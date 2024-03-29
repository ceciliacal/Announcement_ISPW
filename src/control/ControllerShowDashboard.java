package control;

import bean.RenterAnnounceBean;
import bean.TenantAnnounceBean;
import dao.DBFunctions;

import java.util.ArrayList;

public class ControllerShowDashboard {

    private static ControllerShowDashboard instance;

    private ControllerShowDashboard() {
    }

    public static ControllerShowDashboard getInstance() {
        if (instance == null) {
            instance = new ControllerShowDashboard();
        }
        return instance;
    }


    //funzione che recupera dal DB due liste di bean, una contenente renterAnnounceBean e
    // una bean
    public void createListAnnounce(ArrayList<RenterAnnounceBean> renterList, ArrayList<TenantAnnounceBean> tenantList){

        //creiamo le due liste che poi andiamo a mettere nelle listView di showDashboard...
        DBFunctions dbf= new DBFunctions();
       // rList = dbf.searchRenterAnnounces();
       // tList = dbf.searchTenantAnnounces();
        dbf.searchAnnounces(renterList,tenantList);
        //renterList.add("---Nessuno---");

        for(int i=0;i<renterList.size();i++){
            System.out.println("C: "+renterList.get(i).getAddress());
        }
        for(int i=0;i<tenantList.size();i++){
            System.out.println("C: "+tenantList.get(i).getName());
        }

        //ShowDashboardUIController bho= new ShowDashboardUIController(this);

    }


}
