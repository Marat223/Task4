/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.mustaphin.textoperation.assembly;

import by.mustaphin.textoperation.composite.IComposite;
import by.mustaphin.textoperation.composite.Leaf;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author me
 */
public class AssemblyHandler {

    private AssemblyHandler successor;

    public AssemblyHandler() {
    }

    public AssemblyHandler(AssemblyHandler successor) {
	this.successor = successor;
    }

    public void handleRequest(List<IComposite> component) {
	
    }

    public void startHandling(List<String> data) {
	List<IComposite> leafList = new ArrayList<>();
	for (String string : data) {
	    Leaf leaf = new Leaf(string);
	    leafList.add(leaf);
	}
	chain(leafList);
    }

    public void chain(List<IComposite> component) {
	handleRequest(component);
	successor.chain(component);
    }

    public static class DefaultHandlerRequest extends AssemblyHandler {

	private static DefaultHandlerRequest handler = new DefaultHandlerRequest();

	public static DefaultHandlerRequest getHandler() {
	    return handler;
	}

	public DefaultHandlerRequest() {
	}

	@Override
	public void chain(List<IComposite> data) {
	    handleRequest(data);
	}

	@Override
	public void handleRequest(List<IComposite> data) {
	}

    }

}
