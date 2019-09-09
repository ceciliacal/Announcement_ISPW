package bean;

import java.util.Dictionary;
import java.util.List;

public class ApartmentBean {

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

    public ApartmentBean(){}

    //set
    public void setIdApt(int myIdApt){this.idApt=myIdApt;}

    public void setName(String myName){this.name=myName;}

    public void setAddress(String myAddress){this.address=myAddress;}

    public void setIdOwner(String myIdOwner){ this.idOwner=myIdOwner;}

    public void setPictures(List<String> myPictures){this.pictures=myPictures;}

    public void setDescription(String myDescription){this.description=myDescription;}

    public void setTaxes(float myTaxes){this.taxes=myTaxes;}

    public void setCapacity(int myCapacity){this.capacity=myCapacity;}

    public void setArea(float myArea){this.area=myArea;}

    //public void setServices(Dictionary<String,String> myServices){this.services=myServices;}

    //get
    public int getIdApt(){return idApt;}

}
