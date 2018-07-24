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
	
    }

}
