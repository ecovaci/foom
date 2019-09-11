package org.kpax.foom.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import org.kpax.foom.util.FxUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.beans.beancontext.BeanContextSupport;
import java.io.IOException;
import java.net.URL;

/**
 * @author Eugen Covaci {@literal eugen.covaci.q@gmail.com}
 * Created on 9/10/2019
 */
@Component
public class WizardController {

    @FXML
    private BorderPane borderPane;

    @FXML
    private Button backButton;

    @FXML
    private Button nextButton;

    @Autowired
    private ApplicationContext applicationContext;

    @FXML
    public void initialize () throws Exception {

    }

    public void doBack(ActionEvent actionEvent)  throws Exception {
        Node node = FxUtils.loadNode(applicationContext, "classpath:/view/util.select.javabean.fxml");
        borderPane.setCenter(node);
    }

    public void doNext(ActionEvent actionEvent) throws Exception {
        Node node = FxUtils.loadNode(applicationContext, "classpath:/view/util.display.javabean.fxml");
        borderPane.setCenter(node);
    }

}
