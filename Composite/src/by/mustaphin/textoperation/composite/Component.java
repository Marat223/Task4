/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.mustaphin.textoperation.composite;

import java.util.List;

/**
 *
 * @author marat
 */
public interface Component {

    public String operate();

    public boolean add(Component component);

    public boolean remove(Component component);

    public Component get(int index);

    public List<Component> getData();

}
