/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.mustaphin.textoperation.preset.specification;

import by.mustaphin.textoperation.composite.Component;
import by.mustaphin.textoperation.preset.Type;
import java.util.List;

/**
 *
 * @author me
 */
public interface Specification {

    public List<Component> specified(List<Component> component, Type type);

}
