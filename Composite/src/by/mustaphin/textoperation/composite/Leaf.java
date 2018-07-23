/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.mustaphin.textoperation.composite;

import by.mustaphin.textoperation.preset.specification.Specification;
import java.util.List;

/**
 *
 * @author marat
 */
public class Leaf implements Component {

    private String content;

    public Leaf(String content) {
	this.content = content;
    }

    @Override
    public String operate() {
	return content;
    }

    @Override
    public boolean add(Component component) {
	return false;
    }

    @Override
    public boolean remove(Component component) {
	return false;
    }

    @Override
    public Component get(int index) {
	return this;
    }

    @Override
    public List<Component> getData() {
	return null;
    }

    @Override
    public String operate(Specification specification) {
	return operate();
    }

}
