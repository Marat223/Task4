/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.mustaphin.textoperation.preset;

import by.mustaphin.textoperation.composite.Component;
import by.mustaphin.textoperation.preset.specification.Specification;
import java.util.List;

/**
 *
 * @author me
 */
public abstract class AbstractPreset {

    protected Type type;

    protected String regularExpression;

    public AbstractPreset(Type type) {
	this.type = type;
    }

    public AbstractPreset(String regularExpression, Type type) {
	this.type = type;
	this.regularExpression = regularExpression;
    }

    public abstract String assembly(List<Component> component);

    public String assembly(List<Component> component, Specification specification) {
	return assembly(specification.specified(component, type));
    }

    public String getRegularExpression() {
	return regularExpression;
    }

}
