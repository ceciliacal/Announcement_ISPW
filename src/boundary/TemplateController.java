package boundary;

import bean.TenantAnnounceBean;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class TemplateController {

    @FXML
    public Label titleField, nameField, cityField, room, parking, airConditioning, animalsAllowed, garden, wifi, idDateDep, idDateArr, people, bathrooms;


    public void createStage(TenantAnnounceBean bean) {

        titleField.setText(bean.getTitle());
        nameField.setText(bean.getName());
        cityField.setText(bean.getCity());
        room.setText(String.valueOf(bean.getRoom()));
        bathrooms.setText(String.valueOf(bean.getBath()));
        people.setText(String.valueOf(bean.getPeople()));


        System.out.println("createStage il bean del title è" + bean.getTitle());


    }



}
