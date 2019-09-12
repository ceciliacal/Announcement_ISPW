package control;

import bean.ApartmentBean;
import bean.RenterAnnounceBean;
import bean.UserBean;
import entity.Apartment;
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

    public ArrayList<ApartmentBean> createApartmentsList(UserBean bean){
        //List <String> apartmentsList=null;
        ArrayList<ApartmentBean> apartmentsList;

        System.out.println("sto nel Control");

        DBFunctions dbf= new DBFunctions();
        apartmentsList=dbf.searchUserApartments(bean.getId());

        //System.out.println("idApartments.size()="+idApartments.size());
        System.out.println("apartmentsList.size()="+apartmentsList.size());

        for(int i=0;i<apartmentsList.size();i++){
            System.out.println("C: "+apartmentsList.get(i).getIdApt());
            System.out.println("C: "+apartmentsList.get(i).getName());
        }
        return apartmentsList;
    }


    //restituisce l'id i-esimo (da lista idApartments) dell'appartamento i-esimo (da lista nameApartments)
    public String aptIdByIndex(int i) {
        return idApartments.get(i);
    }

    public void cercoAppartamento(ApartmentBean aptBean) {
        DBFunctions dbf= new DBFunctions();
        dbf.searchApartmentById(aptBean.getIdApt());
    }

    public Apartment createApartment(ApartmentBean aptBean) {
        Apartment myApartment= new Apartment(aptBean.getIdApt(),aptBean.getName(),aptBean.getAddress(),aptBean.getIdOwner(),aptBean.getPictures(),aptBean.getDescription(),aptBean.getEvaluation(),aptBean.getTaxes(),aptBean.getCapacity(),aptBean.getArea());
        return myApartment;
    }
}