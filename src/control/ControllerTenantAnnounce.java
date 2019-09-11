package control;

import bean.TenantAnnounceBean;
import boundary.TenantAnnounceUIController;
import dao.DBAnnounce;
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



    public void createRenterAnnounce(TenantAnnounceBean bean) {
        String prova ;


        DBAnnounce rAD = new DBAnnounce();


        TenantAnnounceBean rAB = new TenantAnnounceBean();

        prova = bean.getTitle();
        System.out.println("prova è " + prova);


        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/boundary/sample.fxml"));
            Parent root = loader.load();
            TenantAnnounceUIController controller = loader.getController();
            controller.createStage(bean);
            Scene scene = new Scene(root);

            Stage primaryStage = new Stage();

            primaryStage.setTitle("TenantAnnounce");
            primaryStage.setScene(scene);

            primaryStage.show();


        } catch (IOException e) {
            e.printStackTrace();
        }


        TenantAnnounce rA = new TenantAnnounce(bean.getTitle(), bean.getName(), bean.getCity(), bean.getRoom(), bean.getPeople(),bean.getBath(),
                bean.getDateArr(),bean.getDateDep(), bean.getWifi(),bean.getGarden(),bean.getAnimals(),bean.getAirConditionig(),bean.getParking());
        rAD.insertNewAnnounce(rA);
    }



}
