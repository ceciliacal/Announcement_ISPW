package control;

import bean.UserBean;
import com.sun.webkit.network.Util;
import dao.DBUser;
import entity.User;

public class ControllerLogin {

    private static ControllerLogin instance;

    private ControllerLogin() {}

    public static ControllerLogin getInstance() {
        if (instance == null) {
            instance = new ControllerLogin();
        }
        return instance;
        }


    public void validateLogin(UserBean bean) {
        int res;

        DBUser dbU= new DBUser();
        res=dbU.checkLogin(bean.getId(),bean.getPassword()); //controlla risultato e poi crea user usando get
        if (res==1){
            //login ok, ora devi controllare userType
            System.out.println("Login effettuato!");
        }
        else{
            //torna al login e reinserisci dati
            System.out.println("ERRORE: ID o password errati!");
        }
    }

    public void checkUserType(UserBean bean){}  //mesa che non serve






    }

