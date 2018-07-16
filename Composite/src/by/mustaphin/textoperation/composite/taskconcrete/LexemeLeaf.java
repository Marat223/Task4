/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.mustaphin.textoperation.composite.taskconcrete;

import by.mustaphin.textoperation.composite.IComponent;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author me
 */
public class LexemeLeaf implements IComponent {

    private List<String> text = new ArrayList<>();

    public LexemeLeaf(String lexeme) {
	text.add(lexeme);
    }

    @Override
    public boolean add(IComponent component) {
	return false;
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
    public String toString() {
	return text.get(0);
    }

}
