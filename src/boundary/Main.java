package boundary;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("LoginUI.fxml"));
        //Parent root = FXMLLoader.load(getClass().getResource("RenterAnnounceUI.fxml"));
        //Parent root = FXMLLoader.load(getClass().getResource("TenantAnnounce.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 800, 800));
        primaryStage.show();
    }


    public void notification (int type, String title, String msg) {

        TrayNotification tray = new TrayNotification();
        AnimationType t = AnimationType.POPUP;
        tray.setAnimationType(t);
        tray.setTitle(title);
        tray.setMessage(msg);
        tray.showAndDismiss(Duration.seconds(3));
        if (type == 1) {
            tray.setNotificationType(NotificationType.SUCCESS);
        }
        else if (type == 0) {
            tray.setNotificationType(NotificationType.ERROR);

        }
    }



    public static void main(String[] args) {

        launch(args);
    }
}
