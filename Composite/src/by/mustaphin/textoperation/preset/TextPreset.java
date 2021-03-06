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
public class TextPreset extends AbstractPreset {

    public TextPreset(Type type) {
	super(type);
    }

    @Override
    public String getRegularExpression() {
	return regularExpression;
    }

    @Override
    public String assembly(List<Component> component) {
	StringBuilder stringBuilder = new StringBuilder();
	for (Component inner : component) {
	    stringBuilder.append("    ").append(inner.operate()).append("\n");
	}
	return stringBuilder.toString();
    }

}
