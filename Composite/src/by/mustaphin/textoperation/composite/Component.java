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
public class Component {

    protected final List<Component> innerComponent = new ArrayList<>();
    private String leafData;

    public Component(String leafData) {
	this.leafData = leafData;
    }

    public boolean isLeaf() {
	boolean leaf = false;
	if (innerComponent.isEmpty() || null == innerComponent) {
	    leaf = true;
	}
	return leaf;
    }

    public String operate() {
	String data = "";
	if (innerComponent.isEmpty()) {
	    data = leafData;
	} else {
	    StringBuilder stringBuilder = new StringBuilder();
	    for (Component component : innerComponent) {
		stringBuilder.append(component.operate()).append(" ");
	    }
	    data = stringBuilder.toString();
	}
	return data;
    }

    public void setLeafData(String leafData) {
	this.leafData = leafData;
    }

    public void add(Component component) {
	innerComponent.add(component);
    }

    public boolean remove(Component component) {
	return innerComponent.remove(component);
    }

    public Component get(int index) {
	return innerComponent.get(index);
    }

    public List<Component> giveLeafs(Component component) {
	List<Component> leaf = new ArrayList<>();
	if (isLeaf()) {
	    leaf.add(this);
	} else {
	    for (Component inner : innerComponent) {
		leaf.addAll(inner.giveLeafs(inner));
	    }
	}
	return leaf;
    }

    public List<Component> getInnerComponent() {//TODO
	return innerComponent;
    }

}
