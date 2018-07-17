/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.mustaphin.textoperation.parse;

import by.mustaphin.textoperation.composite.Component;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
	if (component.isLeaf()) {
	    Pattern pattern = Pattern.compile(regEx);
	    List<Component> leaf = component.giveLeafs(component);
	    for (Component leafComponent : leaf) {
		Matcher matcher = pattern.matcher(leafComponent.operate());
		while (matcher.find()) {
		    component.add(new Component(matcher.group()));
		}
	    }
	} else {
	    for (Component inner : component.getInnerComponent()) {
		handleRequest(inner, regEx);
	    }
	}
    }

    public void chain(Component component) {
	handleRequest(component, regularExpression);
	successor.chain(component);
    }

    public static class DefaultHandlerRequest extends Handler {

	private static DefaultHandlerRequest handler = new DefaultHandlerRequest(null);

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
	    //TODO DefaultHandlerRequest handleRequest()
	}

    }
}
