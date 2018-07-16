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
public class Component implements IComponent {

    protected List<IComponent> innerComponent = new ArrayList<>();
    private String leafData;

    public boolean isLeaf() {
	boolean leaf = false;
	if (innerComponent.isEmpty() || null == innerComponent) {
	    leaf = true;
	}
	return leaf;
    }

    public Component(String leafData) {
	this.leafData = leafData;
    }

    public void setComponents(List<IComponent> component) {
	innerComponent = component;
    }

    @Override
    public String operate() {
	String data = "";
	if (innerComponent.isEmpty()) {
	    data = leafData;
	} else if (!innerComponent.isEmpty()) {
	    StringBuilder stringBuilder = new StringBuilder();
	    for (IComponent component : innerComponent) {
		stringBuilder.append(component.operate()).append(" ");
	    }
	    data = stringBuilder.toString();
	}
	return data;
    }

    public void setLeafData(String leafData) {
	this.leafData = leafData;
    }

    @Override
    public void add(IComponent component) {
	innerComponent.add(component);
    }

    @Override
    public boolean remove(IComponent component) {
	boolean success = false;
	int size = innerComponent.size();
	innerComponent.remove(component);
	if (innerComponent.size() != size) {
	    success = true;
	}
	return success;
    }

    @Override
    public IComponent get(int index) {
	return innerComponent.get(index);
    }

}
