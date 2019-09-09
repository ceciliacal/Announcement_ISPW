package bean;



import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class RenterAnnounceBean {

    private int idAnn;
    private int idApt;    //id appartamento a cui si riferisce
    private String address;
    private String idOwner;
    private List<String> pictures;
    private String description;
    private float evaluation;
    private int capacity;
    private float area;
    private float price;
    private LocalDate from;
    private LocalDate to;
    private String title;
    private HashMap<String, Boolean> services;

    public RenterAnnounceBean(){};

    public void setIdAnn(int myIdAnn){this.idAnn=myIdAnn;}

    public void setIdApt(int myIdApt){this.idApt=myIdApt;}

    public void setTitle(String myTitle){this.title=myTitle;}

    public String getTitle(){return title;}

    public void setPrice(float myPrice){this.price=myPrice;}

    public void setFromDate(LocalDate from){ this.from=from;}

    public void setToDate(LocalDate to){this.to=to;}

    public void setWifi(boolean value){ services.replace("wifi",value);}

    public void setAnimals(boolean value){ services.replace("animals",value);}

    public void setParking(boolean value){ services.replace("parking",value);}

    public void setAirConditioning(boolean value){ services.replace("airConditioning",value);}

}