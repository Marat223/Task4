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
public class Component implements IComposite {

    protected final List<IComposite> innerComponent = new ArrayList<>();

    public Component(String data) {
    }

    @Override
    public String operate() {
	StringBuilder stringBuilder = new StringBuilder();
	for (IComposite component : innerComponent) {
	    stringBuilder.append(component.operate()).append(" ");
	}
	return stringBuilder.toString();
    }

    @Override
    public void add(IComposite component) {
	innerComponent.add(component);
    }

    @Override
    public boolean remove(IComposite component) {
	return innerComponent.remove(component);
    }

    @Override
    public IComposite get(int index) {
	return innerComponent.get(index);
    }

    public List<IComposite> getInnerComponent() {//TODO
	return innerComponent;
    }

}
