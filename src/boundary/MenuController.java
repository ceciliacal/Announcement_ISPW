package boundary;

import bean.RenterAnnounceBean;
import bean.TenantAnnounceBean;
import bean.UserBean;
import control.ControllerShowDashboard;
import entity.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class MenuController {
    public Button createNewAnnounce;
    public Label title;

    private UserBean myBean = new UserBean();

    public void clickedNewAnnounceBtn(ActionEvent actionEvent) {
        Stage stage = (Stage)title.getScene().getWindow();
        stage.close();

        String tipo = myBean.getUserType(); //invece di bean passo user entity
        String userId = myBean.getId();

        if (tipo.equals("1")) { // locatore
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/boundary/ListApartments.fxml"));
                Parent root = loader.load();
                ListApartmentsController controller = loader.getController();
                controller.createListView(myBean);
                Scene scene = new Scene(root);

                Stage primaryStage = new Stage();

                primaryStage.setTitle("List Apartments");
                primaryStage.setScene(scene);

                primaryStage.show();


            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        else if (tipo.equals("2")) {    //locatario
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/boundary/TenantAnnounce.fxml"));
                Parent root = loader.load();
                TenantAnnounceUIController controller = loader.getController();
                controller.createStage(myBean);
                Scene scene = new Scene(root);

                Stage primaryStage = new Stage();

                primaryStage.setTitle("Tenant Announce");
                primaryStage.setScene(scene);

                primaryStage.show();


            } catch (IOException e) {
                e.printStackTrace();
            }


        }
    }


    public void createStage(User bean) {        //QUA VA USATA ENTITY "USER" E NON BEAN!!
        String userType = bean.getUserType();

        if (userType.equals("1")) {
            title.setText("MENU LOCATORE");
        }
        else if (userType.equals("2")) {
            title.setText("MENU LOCATARIO");
        }
        myBean.setUserType(userType);
        myBean.setId(bean.getId());
    }


    public void clickedShowDashboard(ActionEvent actionEvent) {

        ArrayList<RenterAnnounceBean> renterList = new ArrayList<>();
        ArrayList<TenantAnnounceBean> tenantList = new ArrayList<>();


        ControllerShowDashboard csd= ControllerShowDashboard.getInstance();
        csd.createListAnnounce(renterList,tenantList);
        try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/boundary/ShowDashboardUI.fxml"));
                Parent root = loader.load();
                ShowDashboardUIController controller = loader.getController();
                controller.createListViewAnnounces(renterList,tenantList);
                Scene scene = new Scene(root);

                Stage primaryStage = new Stage();

                primaryStage.setTitle("Announces Dashboard");
                primaryStage.setScene(scene);

                primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }


        //dopo aver cliccato viasualizza bacheca dobbiamo chiamare una funzione del controller show bacheca (UC) invece di creare direttamente un nuovo stage (scena)


    }
}
