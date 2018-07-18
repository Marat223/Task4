/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.mustaphin.textoperation.composite;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author marat
 */
public class Leaf implements IComposite {

    private String data;

    public Leaf(String data) {
	this.data = data;
    }

    @Override
    public String operate() {
	return data;
    }

    @Override
    public boolean add(IComposite component) {
	return false;
    }

    @Override
    public boolean remove(IComposite component) {
	return false;
    }

    @Override
    public IComposite get(int index) {
	return this;
    }

    @Override
    public List<IComposite> getComponent() {
	return Arrays.asList(this);
    }

}
