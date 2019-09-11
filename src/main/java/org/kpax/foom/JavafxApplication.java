package org.kpax.foom;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.beans.factory.config.SingletonBeanRegistry;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.io.Resource;

import java.net.URL;

public class JavafxApplication extends Application {

    private ConfigurableApplicationContext applicationContext;


    @Override
    public void init() throws Exception {
        this.applicationContext = SpringApplication.run(FoomApplication.class, getParameters().getRaw().toArray(new String[0]));
        SingletonBeanRegistry beanRegistry = applicationContext.getBeanFactory();
        beanRegistry.registerSingleton("fxApplication", this);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        SingletonBeanRegistry beanRegistry = applicationContext.getBeanFactory();
        beanRegistry.registerSingleton("fxPrimaryStage", primaryStage);

        Resource fxml = this.applicationContext.getResource("classpath:/view/main.fxml");
        URL url = fxml.getURL();
        FXMLLoader fxmlLoader = new FXMLLoader(url);
        fxmlLoader.setControllerFactory(this.applicationContext::getBean);
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Foom");
        primaryStage.show();
    }

    @Override
    public void stop() throws Exception {
        this.applicationContext.close();
        Platform.exit();
    }

}
