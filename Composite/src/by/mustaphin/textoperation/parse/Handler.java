/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.mustaphin.textoperation.parse;

import by.mustaphin.textoperation.composite.Component;
import by.mustaphin.textoperation.constant.RegularExpression;

/**
 *
 * @author me
 */
public class Handler {

    private Handler successor;
    protected String regularExpression;

    public Handler(Handler successor, String regExp) {
	this.successor = successor;
	regularExpression = regExp;
    }

    public Handler(String regExp) {
	this.successor = DefaultHandlerRequest.getHandler();
	regularExpression = regExp;
    }

    public void handleRequest(Component component, String regEx) {
	
    }

    public void chain(Component component) {
	handleRequest(component, regularExpression);
	successor.chain(component);
    }

    public static class DefaultHandlerRequest extends Handler {

	private static DefaultHandlerRequest handler = new DefaultHandlerRequest(RegularExpression.EMPTY);

	public static DefaultHandlerRequest getHandler() {
	    return handler;
	}

	public DefaultHandlerRequest(String regExp) {
	    super(regExp);
	}

	@Override
	public void chain(Component component) {
	    handleRequest(component, regularExpression);
	}

	@Override
	public void handleRequest(Component component, String regEx) {
	    System.out.println(component.operate());
	}

    }
}
