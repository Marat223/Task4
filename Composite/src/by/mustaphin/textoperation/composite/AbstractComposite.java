/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.mustaphin.textoperation.composite;

import java.util.List;

/**
 *
 * @author me
 */
public class AbstractComposite implements IComponent {

    protected List<IComponent> components;

    public AbstractComposite(List<IComponent> components) {
	this.components = components;
    }

    @Override
    public void operate() {
	
    }

    @Override
    public boolean add(IComponent component) {
	boolean addSuccessfuly = false;
	int size = components.size();
	component.add(component);
	if (components.size() != size) {
	    addSuccessfuly = true;
	}
	return addSuccessfuly;
    }

    @Override
    public boolean remove(IComponent component) {
	boolean removeSuccessfuly = false;
	int size = components.size();
	component.remove(component);
	if (components.size() != size) {
	    removeSuccessfuly = true;
	}
	return removeSuccessfuly;
    }

    @Override
    public IComponent get(int index) {
	return components.get(index);

    }

}
