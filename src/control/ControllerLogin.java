package control;

import com.sun.webkit.network.Util;
import entity.User;

public class ControllerLogin {

    private static ControllerLogin instance;

    private ControllerLogin() {};

    public static ControllerLogin getInstance() {
        if (instance == null) {
            instance = new ControllerLogin();
        }
        return instance;
        }

    public User login(String username, String password) {
        User u = UserDao.findByNameAndPasswordMockup(username, password);
        return u;
    }



    }

