/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.mustaphin.textoperation.preset.specification;

import by.mustaphin.textoperation.composite.Component;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author me
 */
public class SortingStoreSingletone {

    private List<Component> component = new ArrayList<>();

    private SortingStoreSingletone() {
    }

    private static class SingletoneHolder {

	private static final SortingStoreSingletone INSTANSE = new SortingStoreSingletone();

    }

    public static SortingStoreSingletone getInstanse() {
	return SingletoneHolder.INSTANSE;
    }

    public void addComponent(Component component) {
	this.component.add(component);

    }

    private void sort() {
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
    }

}
