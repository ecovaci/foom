package org.kpax.foom.domain;

import javafx.stage.Stage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Eugen Covaci {@literal eugen.covaci.q@gmail.com}
 * Created on 9/3/2019
 */
public class StepContext {
    private final Map<String,Object> parameters = new HashMap<>();

    public Map<String, Object> getParameters() {
        return parameters;
    }
}
