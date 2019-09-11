package org.kpax.foom.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.net.URL;

/**
 * @author Eugen Covaci {@literal eugen.covaci.q@gmail.com}
 * Created on 9/10/2019
 */
public class FxUtils {

    public static Node loadNode (ApplicationContext applicationContext, String fxmlFilePath) throws IOException {
        Resource fxml = applicationContext.getResource(fxmlFilePath);
        URL url = fxml.getURL();
        FXMLLoader fxmlLoader = new FXMLLoader(url);
        fxmlLoader.setControllerFactory(applicationContext::getBean);
        return fxmlLoader.load();
    }

}
