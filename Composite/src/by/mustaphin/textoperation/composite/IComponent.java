/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.mustaphin.textoperation.composite;

/**
 *
 * @author me
 */
public interface IComponent {

    String toString();

    boolean add(IComponent component);

    boolean remove(IComponent component);

    IComponent get(int index);
}
