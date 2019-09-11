package org.kpax.foom;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyController {

    @Autowired
    private MyBean myBean;

    @FXML
    public void initialize () {
        System.out.println("MyController created! " + myBean);
    }
}
