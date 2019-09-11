package entity;

public class User {
    /****
     private String ID="m";
     private String password="d";

     public User(){};


     public String getID(){
     return this.ID;
     }

     public String getPassword(){
     return this.password;
     }
     *****/

    private String id;
    private String password;
    private String userType;


    public User(String id, String password, String userType) {

        this.id = id;
        this.password = password;
        this.userType = userType;    //1: locatore, 2:locatario


    }

}
/*

    public String getNome() {
        return nome;
    }

    public String toString() {
        return nome + "" + cognome;
    }

*/
