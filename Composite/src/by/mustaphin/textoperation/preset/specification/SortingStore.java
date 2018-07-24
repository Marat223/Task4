/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.mustaphin.textoperation.preset.specification;

import by.mustaphin.textoperation.composite.Component;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author me
 */
public class SortingStore {

    private List<Component> component = new ArrayList<>();

    private SortingStore() {
    }

    private static class SingletoneHolder {

	private static final SortingStore INSTANSE = new SortingStore();

    }

    public static SortingStore getInstanse() {
	return SingletoneHolder.INSTANSE;
    }

    public void addComponent(Component component) {
	this.component.add(component);
    }

    private void sort() {
	Component[] arrayComponent = new Component[component.size()];
	for (int i = 0; i < component.size(); i++) {
	    arrayComponent[i] = component.get(i);
	}
	Collections.sort(component, new Comparator<Component>() {
	    @Override
	    public int compare(Component firtsComponent, Component secondComponent) {
		
	    }

	});
    }

}
