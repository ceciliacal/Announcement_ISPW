package control;

import bean.ApartmentBean;
import bean.RenterAnnounceBean;
import bean.UserBean;
import entity.RenterAnnounce;
import dao.DBFunctions;

import java.util.*;

public class ControllerRenterAnnounce {

    ArrayList<String> idApartments = new ArrayList<String>();   //?????

    private static ControllerRenterAnnounce instance;

    private ControllerRenterAnnounce() {
    }

    public static ControllerRenterAnnounce getInstance() {
        if (instance == null) {
            instance = new ControllerRenterAnnounce();
        }
        return instance;
    }

    public void validateAnnounce(RenterAnnounceBean bean){
        //verifica che non esiste un altro annuncio per quell'appartamento

        RenterAnnounce announce;

        DBFunctions dbf= new DBFunctions();
        //announce=new RenterAnnounce(0,0,bean.getTitle(),bean.getPrice(),bean.getFromDate(),bean.getToDate(),bean.getWifi(),bean.getAnimals(),bean.getParking(),bean.getAirConditioning());

        //dbf.insertNewRenterAnnounce(announce);

    }

    public ArrayList<String> createApartmentsList(UserBean bean){
        //List <String> nameApartmentsList=null;
        ArrayList<String> nameApartmentsList = new ArrayList<>();

        System.out.println("sto nel Control");

        DBFunctions dbf= new DBFunctions();
        nameApartmentsList=dbf.searchUserApartments(idApartments,bean.getId());

        System.out.println("idApartments.size()="+idApartments.size());
        System.out.println("nameApartmentsList.size()="+nameApartmentsList.size());

        for(int i=0;i<idApartments.size();i++){
            System.out.println("C: "+idApartments.get(i));
            System.out.println("C: "+nameApartmentsList.get(i));
        }
        return nameApartmentsList;
    }


    //restituisce l'id i-esimo (da lista idApartments) dell'appartamento i-esimo (da lista nameApartments)
    public String aptIdByIndex(int i) {
        return idApartments.get(i);
    }

    public void cercoAppartamento(ApartmentBean aptBean) {
        DBFunctions dbf= new DBFunctions();
        dbf.searchApartmentById(aptBean.getIdApt());
    }
}