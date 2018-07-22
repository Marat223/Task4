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
public class LeafPreset extends AbstractPreset {

    public LeafPreset(String regularExpression) {
	super(regularExpression);
    }

    @Override
    public String assembly(List<Component> component) {
	throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
