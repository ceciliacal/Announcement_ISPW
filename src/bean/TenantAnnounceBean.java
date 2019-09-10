package bean;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;

public class TenantAnnounceBean {

     private int idAnn;
     private String city;
     private String idTenant;
     private float price;
     private LocalDate from;
     private LocalDate to;
     private String title;
     private HashMap<String,Boolean> services;
     /*
     private Boolean wifi;
     private Boolean garden;
     private Boolean animalsAllowed;
     private Boolean airConditioning;
     private Boolean parking;
     */

     public TenantAnnounceBean() {}

     public void setCity(String city) { this.city = city; }

     public String getCity() {return city;}

     public void setTitle(String myTitle){this.title=title;}

     public String getTitle(){return title;}

     public void setFromDate(LocalDate from){ this.from=from;}

     public void setToDate(LocalDate to){this.to=to;}

     public void setWifi(boolean value) {services.replace("wifi", value);}

     public void setGarden(boolean value) {services.replace("garden", value);}

     public void setAnimals(boolean value) {services.replace("animals", value);}

     public void setAirConditioning(boolean value) {services.replace("airConditioning", value);}

     public void setParking(boolean value) {services.replace("parking", value);}




}
