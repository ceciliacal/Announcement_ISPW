package dao;

import entity.User;

import java.sql.*;

public class DBUser {

    private DBconnection dbConn = new DBconnection();

    public DBUser() {
    }

    //controllare che utente che effettua il login esiste nel db

    public int checkLogin(String id, String password) {
        String idLoaded;
        String pwdLoaded;

        Statement statement = null;
        //System.out.println("userName=" + id + "   password=" + password);

        try {
            String query = "SELECT id, password FROM user where id='" + id + "' AND password='" + password + "';";
            //System.out.println("query=" + query);
            //statement = dbConn.openConnection().prepareStatement(query);
            statement = dbConn.openConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = statement.executeQuery(query);

           /*         CI DEVO METTERE BEAN (FACCIO SET NEL BEAN E POI CHIAMO CONTROLLO DA CLICKED BUTTON, CHE LI PRENDE CON GET)
            while (rs.next()) {
                idLoaded = rs.getString("id");
                pwdLoaded = rs.getString("password");
            }
            */

            if (rs.first() == false) {
                //ERRORE- da gestire
                return 0;
            }

            //in teoria funzione potrebbe finire qui perché se non trova id e pwd vuol dire che sono sbagliati

            idLoaded = rs.getString("id");
            pwdLoaded = rs.getString("password");


            if (idLoaded.equals(id) && pwdLoaded.equals(password)) {
                return 1;
            } else {
                return 0;
            }


        } catch (SQLException e) {
            System.out.println("Database exception");
            e.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }

        return -1;      //qui non deve arrivarci
    }

    public String searchUserType(String id, String password){
        Statement statement = null;
        String res;

        try {
            String query = "SELECT userType FROM user where id='" + id + "' AND password='" + password + "';";
            statement = dbConn.openConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = statement.executeQuery(query);


           /*         CI DEVO METTERE BEAN (FACCIO SET NEL BEAN E POI CHIAMO CONTROLLO DA CLICKED BUTTON, CHE LI PRENDE CON GET)
            while (rs.next()) {
                idLoaded = rs.getString("id");
                pwdLoaded = rs.getString("password");
            }
            */

            if (rs.first() == false) {
                //ERRORE- da gestire
                return null;
            }

            //in teoria funzione potrebbe finire qui perché se non trova id e pwd vuol dire che sono sbagliati

            res = rs.getString("userType");
            return res;


        } catch (SQLException e) {
            System.out.println("Database exception");
            e.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }

        return null;      //qui non deve arrivarci

    }
}
