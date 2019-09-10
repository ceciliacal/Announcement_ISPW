package entity;

import java.util.Date;
import java.util.List;

public class TenantAnnounce {

    private int idAnn;
    private String idTenant;
    private String city;
    private Date from;
    private Date to;
    private String title;
    private Boolean wifi;
    private Boolean garden;
    private Boolean animalsAllowed;
    private Boolean airConditioning;
    private Boolean parking;

    //private List<String> services;

    public TenantAnnounce(int myIDAnn, String myTitle, float myPrice, Date from, Date to) {

        this.idAnn = myIDAnn;
        this.title = myTitle;
    }

    public String getTitle() {return title;}
    public void setTitle(String title) {this.title = title; }
}
