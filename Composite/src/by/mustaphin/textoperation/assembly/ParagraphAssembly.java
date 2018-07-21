/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.mustaphin.textoperation.assembly;

import by.mustaphin.textoperation.composite.Component;
import java.util.List;

/**
 *
 * @author me
 */
public class ParagraphAssembly extends AbstractAssembly {

    @Override
    public String construct(List<Component> component) {
	StringBuilder stringBuilder = new StringBuilder();
	for (Component inner : component) {
	    stringBuilder.append(inner.operate()).append(" ");
	}
	stringBuilder.append("$");
	return stringBuilder.toString();
    }

    @Override
    public String construct(String data) {
	throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}