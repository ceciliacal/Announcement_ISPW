package boundary;

import bean.UserBean;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuController {
    public Button createNewAnnounce;
    public Label title;

    private UserBean myBean = new UserBean();

    public void clickedNewAnnounceBtn(ActionEvent actionEvent) {
        Stage stage = (Stage)title.getScene().getWindow();
        stage.close();

        String tipo = myBean.getUserType();

        if (tipo.equals("1")) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/boundary/RenterAnnounceUI.fxml"));
                Parent root = loader.load();
                RenterAnnounceUIController controller = loader.getController();
                controller.createStage(myBean);
                Scene scene = new Scene(root);

                Stage primaryStage = new Stage();

                primaryStage.setTitle("TenantAnnounce");
                primaryStage.setScene(scene);

                primaryStage.show();


            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        else if (tipo.equals("2")) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/boundary/TenantAnnounce.fxml"));
                Parent root = loader.load();
                TenantAnnounceUIController controller = loader.getController();
                controller.createStage(myBean);
                Scene scene = new Scene(root);

                Stage primaryStage = new Stage();

                primaryStage.setTitle("TenantAnnounce");
                primaryStage.setScene(scene);

                primaryStage.show();


            } catch (IOException e) {
                e.printStackTrace();
            }


        }
    }


    public void createStage(UserBean bean) {
        String userType = bean.getUserType();

        if (userType.equals("1")) {
            title.setText("MENU LOCATORE");
        }
        else if (userType.equals("2")) {
            title.setText("MENU LOCATARIO");
        }
        myBean.setUserType(userType);
    }


}
