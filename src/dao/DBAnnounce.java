package dao;

import entity.TenantAnnounce;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static dao.DBQuery.insertAnnounce;

public class DBAnnounce {

    private DBconnection dBH = new DBconnection();

    public DBAnnounce(){};

    public boolean insertNewAnnounce(TenantAnnounce announce) {

        try {


            PreparedStatement ps = dBH.openConnection().prepareStatement(insertAnnounce);
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
            ps.setString(12,announce.getAirConditionig());
            ps.setString(13,announce.getParking());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("DB exception");
            e.printStackTrace();
            return false;
        } finally {
            dBH.closeConnection();
        }
        return true;
    }
}
