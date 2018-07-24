/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.mustaphin.textoperation.preset.specification;

import by.mustaphin.textoperation.composite.Component;
import by.mustaphin.textoperation.preset.Type;
import java.util.List;

/**
 *
 * @author me
 */
public class LengthLexemeSpecification implements Specification {

    /**
     *
     * @param specefied the value of specefied
     */
    @Override
    public List<Component> specified(final List<Component> component, Type type) {
	if (Type.PARAGRAPH == type) {
	    for (Component sentense : component) {
		SortingStore.getInstanse().addComponent(sentense);
	    }
	} else if (Type.TEXT == type) {
	    component.clear();
	    component.addAll(SortingStore.getInstanse().get());
	}
	return component;
    }

}
