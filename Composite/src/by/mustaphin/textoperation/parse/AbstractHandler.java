/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.mustaphin.textoperation.parse;

import by.mustaphin.textoperation.composite.IComponent;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author me
 */
public abstract class AbstractHandler {

    protected List<String> handlerText = new ArrayList<>();

    private AbstractHandler successor = DefaultHandlerRequest.getHandler();

    public AbstractHandler(AbstractHandler successor) {
	this.successor = successor;
    }

    public AbstractHandler() {
    }

    public List<String> getText() {
	return handlerText;
    }

    public abstract void handleRequest(List<String> text);

    public abstract void handleRequest(IComponent component);

    public void chain(List<String> text) {
	handleRequest(text);
	handlerText.addAll(text);
	successor.chain(text);
    }

    public void chain(IComponent component) {
	handleRequest(component);
	successor.chain(component);
    }

    public static class DefaultHandlerRequest extends AbstractHandler {

	private static DefaultHandlerRequest handler = new DefaultHandlerRequest();

	public static DefaultHandlerRequest getHandler() {
	    return handler;
	}

	private DefaultHandlerRequest() {
	}

	@Override
	public void handleRequest(List<String> text) {
	}

	@Override
	public void chain(List<String> text) {
	    handleRequest(text);
	}

	@Override
	public void handleRequest(IComponent component) {
	    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

    }
}
