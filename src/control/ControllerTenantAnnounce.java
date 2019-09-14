package control;

import bean.TenantAnnounceBean;
import boundary.PostedTenantAnnounceController;
import dao.DBFunctions;
import entity.TenantAnnounce;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ControllerTenantAnnounce {

    private static ControllerTenantAnnounce instance;

    private ControllerTenantAnnounce(){}

    public  static ControllerTenantAnnounce getInstance(){
        if(instance==null){
            instance = new ControllerTenantAnnounce();
        }
        return instance;
    }



    public void createTenantAnnounce(TenantAnnounceBean bean) {
        String prova ;


        DBFunctions dbf = new DBFunctions();


        //TenantAnnounceBean tab = new TenantAnnounceBean();

        prova = bean.getTitle();
        System.out.println("prova è " + prova);


        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/boundary/PostedTenantAnnounce.fxml"));
            Parent root = loader.load();
            PostedTenantAnnounceController controller = loader.getController();
            controller.showTenantAnnounce(bean);
            Scene scene = new Scene(root);

            Stage primaryStage = new Stage();

            primaryStage.setTitle("TenantAnnounce");
            primaryStage.setScene(scene);

            primaryStage.show();





        } catch (IOException e) {
            e.printStackTrace();
        }


        TenantAnnounce myTenantAnnounce = new TenantAnnounce(bean.getTitle(), bean.getName(), bean.getCity(), bean.getRoom(), bean.getPeople(),bean.getBath(),
                bean.getDateArr(),bean.getDateDep(), bean.getWifi(),bean.getGarden(),bean.getAnimals(),bean.getAirConditionig(),bean.getParking());
        dbf.insertNewTenantAnnounce(myTenantAnnounce);
    }



}
