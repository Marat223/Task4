/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.mustaphin.textoperation.composite;

import by.mustaphin.textoperation.assembly.AbstractPreset;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author me
 */
public class Composite implements Component {

    protected final List<Component> innerComponent = new ArrayList<>();
    private AbstractPreset assembly;

    public Composite(AbstractPreset assembly) {
	this.assembly = assembly;
    }

    @Override
    public String operate() {
	return assembly.assembly(innerComponent);
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
