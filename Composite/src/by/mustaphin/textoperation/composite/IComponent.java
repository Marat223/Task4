/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.mustaphin.textoperation.composite;

import java.util.List;

/**
 *
 * @author me
 */
public interface IComponent {

    boolean isLeaf();

    String operate();

    void add(IComponent component);

    boolean remove(IComponent component);

    IComponent get(int index);

    public List<IComponent> giveLeafs(IComponent component);
}
