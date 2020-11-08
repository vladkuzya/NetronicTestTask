package com.netronic.util;

import com.netronic.config.AppConfig;
import com.netronic.controller.Controller;
import java.io.IOException;
import java.io.InputStream;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.util.Callback;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringFxmlLoader {
    private static final ApplicationContext APPLICATION_CONTEXT =
            new AnnotationConfigApplicationContext(AppConfig.class);

    public static Controller load(String url) {
        InputStream fxmlStream = null;
        try {
            fxmlStream = SpringFxmlLoader.class.getResourceAsStream(url);
            FXMLLoader loader = new FXMLLoader();
            loader.setControllerFactory(new Callback<Class<?>, Object>() {
                @Override
                public Object call(Class<?> clazz) {
                    return APPLICATION_CONTEXT.getBean(clazz);
                }
            });

            Node view = (Node) loader.load(fxmlStream);
            Controller controller = loader.getController();
            controller.setView(view);

            return controller;
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (fxmlStream != null) {
                try {
                    fxmlStream.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
