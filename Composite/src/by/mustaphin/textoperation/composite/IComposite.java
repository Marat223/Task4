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
public interface IComposite {

    public String operate();

    public boolean add(IComposite component);

    public boolean remove(IComposite component);

    public IComposite get(int index);

    public List<IComposite> getData();

}
