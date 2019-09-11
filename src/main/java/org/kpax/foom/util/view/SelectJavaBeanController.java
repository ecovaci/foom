package org.kpax.foom.util.view;

import com.google.common.reflect.ClassPath;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import org.controlsfx.control.textfield.TextFields;
import org.springframework.stereotype.Component;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Arrays;

/**
 * @author Eugen Covaci {@literal eugen.covaci.q@gmail.com}
 * Created on 9/9/2019
 */
@Component
public class SelectJavaBeanController {
    @FXML
    private ComboBox<String> classesComboBox;

    @FXML
    public void initialize () throws Exception {
        classesComboBox.setEditable(true);

        URLClassLoader child = new URLClassLoader(
                new URL[]{
                        new File("C:\\Users\\Quasimodo\\Workspace\\IdeaProjects\\foomtest\\target\\classes\\").toURI().toURL(),
                        //new File("C:\\Users\\Quasimodo\\.m2\\repository\\org\\dummy\\foom-test\\1.0-SNAPSHOT\\foom-test-1.0-SNAPSHOT.jar").toURI().toURL()
                }, null
        );

        String[] classes = ClassPath.from(child).getTopLevelClasses().stream().map(c -> c.getName()).toArray(String[]::new);

        classesComboBox.getItems().addAll(classes);
        TextFields.bindAutoCompletion(classesComboBox.getEditor(), classesComboBox.getItems());
    }

    public void onSelect(ActionEvent actionEvent) {
        String value = ((ComboBox<String>) (actionEvent.getSource())).getValue();
        System.out.println(value);
    }
}
