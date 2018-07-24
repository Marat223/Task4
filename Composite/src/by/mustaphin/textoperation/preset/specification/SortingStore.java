/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.mustaphin.textoperation.preset.specification;

import by.mustaphin.textoperation.composite.Component;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author me
 */
public class SortingStore {

    private List<Component> component = new ArrayList<>();
    private int offset = 0;

    private SortingStore() {
    }

    private static class SingletoneHolder {

	private static final SortingStore INSTANSE = new SortingStore();

    }

    public static SortingStore getInstanse() {
	return SingletoneHolder.INSTANSE;
    }

    public void addComponent(Component component) {
	this.component.add(component);
    }

    public List<Component> get() {
	sort();
	return component;
    }

    private void sort() {
	Collections.sort(component, new Comparator<Component>() {
	    @Override
	    public int compare(Component firtsComponent, Component secondComponent) {
		return comparingInnerComponentsLength(firtsComponent, secondComponent);
	    }
	});
    }

    private int comparingInnerComponentsLength(Component firstSentense, Component secondSentense) {
	int result = 0;
	int firstSentenseLexemeLength = findMostLongLexeme(firstSentense, offset);
	int secondSentenseLexemeLength = findMostLongLexeme(secondSentense, offset);
	if (firstSentenseLexemeLength == -1 || secondSentenseLexemeLength == -1) {
	    result = -1;//TODO  убедиться, что -1 это корректно
	} else if (firstSentenseLexemeLength - secondSentenseLexemeLength == 0) {
	    offset++;
	    comparingInnerComponentsLength(firstSentense, secondSentense);
	} else {
	    offset = 0;
	    result = firstSentenseLexemeLength - secondSentenseLexemeLength;
	}
	return result;
    }

    private int findMostLongLexeme(Component sentense, int offset) {
	List<Component> lexeme = sentense.getData();
	if (lexeme.size() < offset) {
	    offset = 0;
	    return -1;
	}
	Collections.sort(lexeme, new Comparator<Component>() {
	    @Override
	    public int compare(Component o1, Component o2) {
		return o1.operate().length() - o1.operate().length();
	    }

	});
	return lexeme.get(offset).operate().length();
    }

}
