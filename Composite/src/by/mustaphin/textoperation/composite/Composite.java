/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.mustaphin.textoperation.composite;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author me
 */
public class Composite implements Component {

    protected final List<Component> innerComponent = new ArrayList<>();

    @Override
    public String operate() {
	StringBuilder stringBuilder = new StringBuilder();
	for (Component component : innerComponent) {
	    stringBuilder.append(component.operate()).append(" ");
	}
	return stringBuilder.toString();
    }

    @Override
    public boolean add(Component component) {
	return innerComponent.add(component);
    }

    @Override
    public boolean remove(Component component) {
	return innerComponent.remove(component);
    }

    @Override
    public Component get(int index) {
	return innerComponent.get(index);
    }

    @Override
    public List<Component> getData() {//TODO
	return innerComponent;
    }

}
