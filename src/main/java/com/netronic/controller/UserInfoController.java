package com.netronic.controller;

import com.netronic.model.User;
import com.netronic.util.SpringFxmlLoader;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class UserInfoController extends AbstractController {
    @FXML
    private ImageView userIcon;

    @FXML
    private Button btnBack;

    @FXML
    private Text name;

    @FXML
    private Text email;

    @FXML
    private Text locations;

    @FXML
    private Text phone;

    @FXML
    private Text registered;

    @FXML
    void initialize() {
        User user = UsersController.user;
        userIcon.setImage(new Image(user.getPicture().getLarge()));
        name.setText(user.getName().getFirst() + " " + user.getName().getLast());
        email.setText(user.getEmail());
        locations.setText(user.getLocation().getCountry() + ", " + user.getLocation().getCity());
        phone.setText(user.getPhone());
        registered.setText(user.getRegistered().getDate());

        btnBack.setOnAction(event -> {
            btnBack.getScene().getWindow().hide();
            Stage stage = new Stage();
            AbstractController controller =
                    (AbstractController) SpringFxmlLoader.load("/listAllUsers.fxml");
            Scene scene = new Scene((Parent) controller.getView(), 600, 400);
            stage.setTitle("Netronic");
            stage.setScene(scene);
            stage.show();
        });
    }
}
