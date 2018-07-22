/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.mustaphin.textoperation.preset;

import by.mustaphin.textoperation.composite.Component;
import java.util.List;

/**
 *
 * @author me
 */
public class SentensePreset extends AbstractPreset {

    public SentensePreset(String regularExpression) {
	super(regularExpression);
    }

    @Override
    public String assembly(List<Component> component) {
	StringBuilder stringBuilder = new StringBuilder();
	for (Component inner : component) {
	    stringBuilder.append(inner.operate()).append(" ");
	}
	stringBuilder.append("$");
	return stringBuilder.toString();
    }

}
