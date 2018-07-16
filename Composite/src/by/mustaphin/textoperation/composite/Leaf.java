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
public class Leaf implements IComponent {

    private List<String> text = new ArrayList<>();

    public Leaf(String lexeme) {
	text.add(lexeme);
    }

    @Override
    public void add(IComponent component) {
    }

    @Override
    public boolean remove(IComponent component) {
	return false;
    }

    @Override
    public IComponent get(int index) {
	return this;
    }

    @Override
    public String operate() {
	return text.get(0);
    }

}
