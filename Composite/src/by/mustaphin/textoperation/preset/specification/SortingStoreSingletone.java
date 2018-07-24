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
	//TODO !!!
    }

}
