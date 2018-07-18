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

    protected AssemblyHandler() {
    }

    public AssemblyHandler(AssemblyHandler successor) {
	this.successor = successor;
    }

    public void combine(List<String> data) {
	createLeafs(data);
    }

    private List<IComposite> createLeafs(List<String> data) {
	List<IComposite> leafList = new ArrayList<>();
	for (String string : data) {
	    Leaf leaf = new Leaf(string);
	    leafList.add(leaf);
	}
	return leafList;
    }

    private IComposite createComponent(List<Leaf> leaf) {
	for (Leaf componentPart : leaf) {

	}
	return null;
    }

    public void handleRequest(ArrayList<String> data) {
    }

    public void chain(ArrayList<String> data) {
	handleRequest(data);
	successor.chain(data);
    }

    public static class DefaultHandlerRequest extends AssemblyHandler {

	private static DefaultHandlerRequest handler = new DefaultHandlerRequest();

	public static DefaultHandlerRequest getHandler() {
	    return handler;
	}

	public DefaultHandlerRequest(AssemblyHandler successor) {
	    super(successor);
	}

	@Override
	public void chain(ArrayList<String> data) {
	    handleRequest(data);
	}

	@Override
	public void handleRequest(ArrayList<String> data) {
	}

    }

}
