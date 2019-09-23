package org.kpax.foom.user.domain.internal;

import org.apache.commons.lang3.Validate;
import org.kpax.foom.domain.AbstractStep;
import org.kpax.foom.domain.StepContext;
import org.kpax.foom.domain.exception.ValidationException;

/**
 * @author Eugen Covaci {@literal eugen.covaci.q@gmail.com}
 * Created on 9/23/2019
 */
public class SelectJavaBeanFieldsStep extends AbstractStep {


    public SelectJavaBeanFieldsStep(StepContext workflow) throws ValidationException {
        super(workflow);
    }

    @Override
    public void execute() {

    }

    @Override
    protected void validate(StepContext context) throws ValidationException {
        Validate.isTrue(context.getParameters().containsKey(""));
    }
}
