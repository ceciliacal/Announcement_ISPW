package entity;

public class User {
    private String ID;
    private String password;

    public User(String ID, String pwd){
        this.ID=ID;
        this.password=pwd;
    }

    public String getID(){
        return this.ID;
    }

    public String getPassword(){
        return this.password;
    }


}
