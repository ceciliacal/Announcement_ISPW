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

    private String username;
    private String password;
    private String nome;
    private String cognome;


    public User(String username, String password, String nome, String cognome) {

        this.nome = nome;
        this.cognome = cognome;
        this.username = username;
        this.password = password;

    }

    public String getNome() {
        return nome;
    }

    public String toString() {
        return nome + "" + cognome;
    }

}
