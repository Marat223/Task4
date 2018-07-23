/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.mustaphin.textoperation.preset.specification;

import by.mustaphin.textoperation.composite.Component;
import by.mustaphin.textoperation.preset.Type;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author me
 */
public class AmountSentenseSpecification implements Specification {

    @Override
    public List<Component> specified(List<Component> component, final Type TYPE) {
	if (Type.TEXT == TYPE) {
	    Component[] componentArray = new Component[component.size()];
	    for (int i = 0; i < component.size(); i++) {
		componentArray[i] = component.get(i);
	    }
	    for (int i = 0; i < componentArray.length - 1; i++) {
		if (componentArray[i].getData().size() < componentArray[i + 1].getData().size()) {
		    Component temoraryComponent = componentArray[i];
		    componentArray[i] = componentArray[i + 1];
		    componentArray[i + 1] = temoraryComponent;
		}
	    }
	    return Arrays.asList(componentArray);
	}
	return component;
    }

}
