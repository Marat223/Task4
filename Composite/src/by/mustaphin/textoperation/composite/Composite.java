/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.mustaphin.textoperation.composite;

import by.mustaphin.textoperation.preset.AbstractPreset;
import by.mustaphin.textoperation.preset.specification.Specification;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author me
 */
public class Composite implements Component {

    protected final List<Component> innerComponent = new ArrayList<>();
    private AbstractPreset preset;

    public Composite(AbstractPreset preset) {
	this.preset = preset;
    }

    @Override
    public String operate() {
	return preset.assembly(innerComponent);
    }

    @Override
    public String operate(Specification specification) {
	return preset.assembly(innerComponent, specification);
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
    public List<Component> getData() {
	return new ArrayList<>(innerComponent);
    }

}
