/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.mustaphin.textoperation.preset.specification;

import by.mustaphin.textoperation.composite.Component;
import by.mustaphin.textoperation.preset.Type;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author me
 */
public class AmountSentenseSpecification implements Specification {

    @Override
    public List<Component> specified(List<Component> component, Type type) {
	if (Type.TEXT == type) {
	    Collections.sort(component, new Comparator<Component>() {
		@Override
		public int compare(Component firtsComponent, Component secondComponent) {
		    return firtsComponent.getData().size() - secondComponent.getData().size();
		}

	    });
	}
	return component;
    }

}
