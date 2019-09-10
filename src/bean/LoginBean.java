package bean;

import control.ControllerLogin;
import entity.User;

public class LoginBean {

    private String username;
    private String password;
    private String nome;
    private String cognome;

    public LoginBean() {
        this.username = "";
        this.password = "";
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return this.username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return this.password;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getCognome() {
        return this.cognome;
    }


    public boolean check() {
        if (this.username.equals("") || this.password.equals("")) {
            return false;
        }
        ControllerLogin controller = ControllerLogin.getInstance();
        User found = controller.login(this.username, this.password);
        return(found != null);
    }

}
