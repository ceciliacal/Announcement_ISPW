package entity;

import java.util.Dictionary;
import java.util.List;

public class Apartment {

    private int idApt;
    private String name;
    private String address;
    private String idOwner;
    private List<String> pictures;
    private String description;
    private float evaluation;
    private float taxes;
    private int capacity;
    private float area;
    //private Dictionary<String,String> services;

    public Apartment(int myIdApt, String myName, String myAddress, String myIdOwner, List<String> myPictures, String myDescription, float myTaxes, int myCapacity, int myArea){

        this.idApt=myIdApt;
        this.name=myName;
        this.address=myAddress;
        this.idOwner=myIdOwner;
        this.pictures=myPictures;
        this.description=myDescription;
        //this.services=myServices;
        this.taxes=myTaxes;
        this.capacity=myCapacity;
        this.area=myArea;

        /*
        //mesa che non devo passare myServices come parametro ma impostarli direttamente da qui sotto

        services.put("people","null");
        services.put("area","null");
        services.put("wifi","null");
        services.put("animals","null");
        services.put("parking","null");
        services.put("airConditioning","null");
        */

    }
}
