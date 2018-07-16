/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.mustaphin.textoperation.parse;

import java.util.List;

/**
 *
 * @author me
 */
public abstract class AbstractHandler {

    private AbstractHandler successor = DefaultHandlerRequest.getHandler();

    public AbstractHandler(AbstractHandler successor) {
	this.successor = successor;
    }

    public AbstractHandler() {
    }

    public void setSuccessor(AbstractHandler successor) {
	this.successor = successor;
    }

    public abstract void handleRequest(List<String> text);

    public void chain(List<String> text) {
	handleRequest(text);
	successor.chain(text);
    }

    private static class DefaultHandlerRequest extends AbstractHandler {

	private static DefaultHandlerRequest handler = new DefaultHandlerRequest();

	public static DefaultHandlerRequest getHandler() {
	    return handler;
	}

	private DefaultHandlerRequest() {
	}

	@Override
	public void handleRequest(List<String> text) {
	    for (String string : text) {
		System.out.println(string + "\n");
	    }
	}

	@Override
	public void chain(List<String> text) {
	}
    }
}
