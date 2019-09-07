package entity;

public class User {
    private String ID="m";
    private String password="d";

    /*
    public User(String ID, String pwd){
        this.ID=ID;
        this.password=pwd;
    }
    */

    public User(){};

    public String getID(){
        return this.ID;
    }

    public String getPassword(){
        return this.password;
    }


}
