package org.kpax.foom.domain;

import org.kpax.foom.domain.exception.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import javax.annotation.PostConstruct;

/**
 * @author Eugen Covaci {@literal eugen.covaci.q@gmail.com}
 * Created on 9/23/2019
 */
public abstract class AbstractStep implements Step {

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private StepContext context;

    private Step previousStep;

    public AbstractStep(StepContext context) throws ValidationException {
        validate(context);
        this.context = context;
    }

    @PostConstruct
    public void initialize () {

    }

    @Override
    public final StepContext context() {
        if (this.previousStep == null) {

        }
        return this.context;
    }

    @Override
    public final Step next() {
        execute();
        return applicationContext.getBean("", Step.class);
    }

    protected void validate(StepContext workflow) throws ValidationException {
        // Does nothing by default
    }

}
