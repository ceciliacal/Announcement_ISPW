package entity;

import java.util.Date;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.List;

public class RenterAnnounce {

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
    private Date from;
    private Date to;
    private String title;
    private HashMap<String, Integer> services;

    public RenterAnnounce(int myIdAnn, int myIdApt, String myTitle, HashMap<String, Integer> myServices, float myPrice, Date from, Date to) {

        this.idAnn = myIdAnn;
        this.idApt = myIdApt;

        //title , price, date ecc BHOOO (direttamente dal form?) poi faccio get Text

        services.put("wifi", 0);
        services.put("animals", 0);
        services.put("parking", 0);
        services.put("airConditioning", 0);


    }
}