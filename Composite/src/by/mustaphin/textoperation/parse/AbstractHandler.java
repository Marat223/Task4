/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.mustaphin.textoperation.parse;

import by.mustaphin.textoperation.composite.Component;
import by.mustaphin.textoperation.composite.IComponent;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author me
 */
public abstract class AbstractHandler {

    protected List<String> handlerText = new ArrayList<>();

    private AbstractHandler successor = DefaultHandlerRequest.getHandler();
    protected String regularExpression;

    public AbstractHandler(AbstractHandler successor) {
	this.successor = successor;
    }

    public AbstractHandler() {
    }

    public List<String> getText() {
	return handlerText;
    }

    public abstract void handleRequest(List<String> text);

    public void handleRequest(IComponent component, String regEx) {
	Pattern pattern = Pattern.compile(regEx);
	List<IComponent> leaf = component.giveLeafs(component);
	for (IComponent leafComponent : leaf) {
	    Matcher matcher = pattern.matcher(leafComponent.operate());
	    while (matcher.find()) {
		component.add(new Component(matcher.group()));
	    }
	}
    }

    public void chain(List<String> text) {
	handleRequest(text);
	handlerText.addAll(text);
	successor.chain(text);
    }

    public void chain(IComponent component) {
	handleRequest(component, regularExpression);
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
	public void handleRequest(IComponent component, String regEx) {
	    //TODO DefaultHandlerRequest handleRequest()
	}

    }
}
