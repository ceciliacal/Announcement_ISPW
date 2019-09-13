package boundary;

import bean.TenantAnnounceBean;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;


public class TemplateController {
Image img;

    @FXML
    public Label titleField, nameField, cityField, room, parking, airConditioning, animalsAllowed, garden, wifi, idDateDep, idDateArr, people, bathrooms;


    public void createStage(TenantAnnounceBean bean) throws IOException {

        titleField.setText(bean.getTitle());
        nameField.setText(bean.getName());
        cityField.setText(bean.getCity());
        room.setText(String.valueOf(bean.getRoom()));
        bathrooms.setText(String.valueOf(bean.getBath()));
        people.setText(String.valueOf(bean.getPeople()));

        
        System.out.println("createStage il bean del title è" + bean.getTitle());


    }



}
