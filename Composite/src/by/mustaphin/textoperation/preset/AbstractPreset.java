/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.mustaphin.textoperation.preset;

import by.mustaphin.textoperation.composite.Component;
import java.util.List;

/**
 *
 * @author me
 */
public abstract class AbstractPreset {

    private String regularExpression;

    public AbstractPreset() {
    }

    public AbstractPreset(String regularExpression) {
	this.regularExpression = regularExpression;
    }

    public abstract String assembly(List<Component> component);

    public String getRegularExpression() {
	return regularExpression;
    }

}
