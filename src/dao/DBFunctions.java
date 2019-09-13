package dao;

import bean.ApartmentBean;
import entity.RenterAnnounce;
import entity.TenantAnnounce;

import java.sql.*;
import java.util.ArrayList;

import static dao.DBQuery.*;

public class DBFunctions {

    private DBconnection dbConn = new DBconnection();

    public DBFunctions() {}

    //controllare che utente che effettua il login esiste nel db

    public int checkLogin(String id, String password) {
        String idLoaded;
        String pwdLoaded;

        try {

            PreparedStatement statement = dbConn.openConnection().prepareStatement(searchUser);
            statement.setString(1,id);
            statement.setString(2,password);
            ResultSet rs = statement.executeQuery();


            if (rs.first() == false) {
                //risultato vuoto
                return 0;
            }


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

    public String getUserType(String id, String password){
        String res;

        try {
            PreparedStatement statement = dbConn.openConnection().prepareStatement(searchUserType);
            statement.setString(1,id);
            statement.setString(2,password);
            ResultSet rs = statement.executeQuery();

            if (rs.first() == false) {
                //ERRORE- da gestire
                return null;
            }

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

    public boolean insertNewTenantAnnounce(TenantAnnounce announce) {

        try {


            PreparedStatement ps = dbConn.openConnection().prepareStatement(insertTenantAnnounce);
            ps.setString(1,announce.getTitle());
            ps.setString(2, announce.getName());
            ps.setString(3, announce.getCity());
            ps.setInt(4,announce.getRoom());
            ps.setInt(5,announce.getPeople());
            ps.setInt(6,announce.getBath());
            ps.setDate(7, Date.valueOf(announce.getDateArr()));
            ps.setDate(8,Date.valueOf(announce.getDateDep()));
            ps.setString(9, announce.getWifi());
            ps.setString(10,announce.getGarden());
            ps.setString(11,announce.getAnimals());
            ps.setString(12,announce.getAirConditioning());
            ps.setString(13,announce.getParking());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("DB exception");
            e.printStackTrace();
            return false;
        } finally {
            dbConn.closeConnection();
        }
        return true;
    }

    public boolean insertNewRenterAnnounce(RenterAnnounce announce){
        try {


            PreparedStatement ps = dbConn.openConnection().prepareStatement(insertRenterAnnounce);
            ps.setString(1, null);
            ps.setInt(2, announce.getIdApt());
            ps.setString(3, announce.getAddress());
            ps.setString(4, null);
            ps.setString(5,announce.getDescription());
            ps.setInt(6,announce.getCapacity());
            ps.setFloat(7,announce.getArea());
            ps.setFloat(8, announce.getPrice());
            ps.setDate(9 ,Date.valueOf(announce.getFrom()));
            ps.setDate(10, Date.valueOf(announce.getTo()));
            ps.setString(11,announce.getTitle());
            ps.setString(12,announce.getWifi());
            ps.setString(13,announce.getAnimals());
            ps.setString(14,announce.getParking());
            ps.setString(15,announce.getAirConditioning());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("DB exception");
            e.printStackTrace();
            return false;
        } finally {
            dbConn.closeConnection();
        }
        return true;



    }

    public ArrayList<ApartmentBean> searchUserApartments(String idOwner){

        try {
            ArrayList<ApartmentBean> nameApartments = new ArrayList<>();

            PreparedStatement statement = dbConn.openConnection().prepareStatement(searchApartments);
            statement.setString(1,idOwner);
            ResultSet rs = statement.executeQuery();   //restituisce tabella con tutti gli appartameni relativi a userID

            System.out.println("DB- subito dopo query");



            while (rs.next()) { //n righe
                ApartmentBean myApartmentBean = new ApartmentBean();
                myApartmentBean.setIdApt(Integer.parseInt(rs.getString("idApt")));

                myApartmentBean.setName(rs.getString("name"));
                myApartmentBean.setAddress(rs.getString("address"));
                myApartmentBean.setIdOwner(rs.getString("idOwner"));
                //myApartmentBean.setPictures(rs.getString("pictures"));
                myApartmentBean.setDescription(rs.getString("description"));
                myApartmentBean.setEvaluation(Float.parseFloat(rs.getString("evaluation")));
                myApartmentBean.setTaxes(Float.parseFloat(rs.getString("taxes")));
                myApartmentBean.setCapacity(Integer.parseInt(rs.getString("capacity")));
                myApartmentBean.setArea(Float.parseFloat(rs.getString("area")));

                nameApartments.add(myApartmentBean);
                System.out.println("sto nel while del db - idApt= "+myApartmentBean.getIdApt());

            }

            System.out.println("DB- subito dopo rs.next");

            System.out.println("Gli id ed i nomi degli appartamenti sono stati caricati ");

            return nameApartments;


        } catch (SQLException e) {
            System.out.println("Database exception");
            e.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }

        return null;      //qui non deve arrivarci


    }

/*
    public String searchNickname(String id) {

        try {
            System.out.println("DBFunction: id=" + id);

            PreparedStatement statement = dbConn.openConnection().prepareStatement(searchNicknameByUser);
            statement.setString(1,id);
            ResultSet rs = statement.executeQuery();


            if (rs.first() == false) {
                //ERRORE- da gestire
                return null;
            }

            String res = rs.getString("nickname");
            System.out.println("DBFunction: res=" + res);
            return res;


        } catch (SQLException e) {
            System.out.println("Database exception");
            e.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }

        return null;      //qui non deve arrivarci
    }
    */
}
