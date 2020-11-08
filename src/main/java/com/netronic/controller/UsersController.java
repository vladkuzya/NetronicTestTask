package com.netronic.controller;

import com.netronic.dto.UserApiDto;
import com.netronic.dto.UserResponseDto;
import com.netronic.model.User;
import com.netronic.service.DataService;
import com.netronic.service.UserService;
import com.netronic.service.mapper.UserMapper;
import java.io.IOException;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import org.springframework.stereotype.Controller;

@Controller
public class UsersController extends AbstractController {
    protected static User user;
    private final DataService dataService;
    private final UserService userService;
    private final UserMapper userMapper;

    @FXML
    private ListView<User> usersList;

    public UsersController(DataService dataService,
                           UserService userService,
                           UserMapper userMapper) {
        this.dataService = dataService;
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @FXML
    void initialize() {
        List<User> users = userService.getAll();
        if (users.isEmpty()) {
            UserApiDto apiDto = dataService.getData("https://randomuser.me/api/?results=20",
                    UserApiDto.class);
            for (UserResponseDto dto : apiDto.getResults()) {
                userService.add(userMapper.mapToEntity(dto));
            }
            users = userService.getAll();
        }
        ObservableList<User> observableList = FXCollections.observableArrayList(users);
        usersList.setItems(observableList);

        usersList.setCellFactory(param -> new ListCell<User>() {
            ImageView imageView = new ImageView();
            Image image;
            @Override
            public void updateItem(User user, boolean empty) {
                super.updateItem(user, empty);
                if (empty) {
                    setText(null);
                    setGraphic(null);
                } else {
                    image = new Image(user.getPicture().getThumbnail());
                    imageView.setImage(image);
                    imageView.setFitHeight(48);
                    imageView.setFitWidth(48);
                    setText(user.getName().getTitle() + " "
                            + user.getName().getFirst() + " "
                            + user.getName().getLast());
                    setGraphic(imageView);
                }
            }
        });

        usersList.getSelectionModel().selectedItemProperty().addListener(
                (user, oldVal, newVal) -> {
                    UsersController.user = user.getValue();
                    usersList.getScene().getWindow().hide();

                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("/userInfo.fxml"));

                    try {
                        loader.load();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    Parent root = loader.getRoot();
                    Stage stage = new Stage();
                    stage.setScene(new Scene(root));
                    stage.show();
                }
        );
    }
}

