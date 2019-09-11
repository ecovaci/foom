package org.kpax.foom.domain;

import java.util.List;

/**
 * @author Eugen Covaci {@literal eugen.covaci.q@gmail.com}
 * Created on 9/3/2019
 */
public interface Stage {
    List<Step> steps();
    void execute();
}
