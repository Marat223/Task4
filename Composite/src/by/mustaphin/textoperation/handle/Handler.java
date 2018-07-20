/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.mustaphin.textoperation.handle;

import by.mustaphin.textoperation.composite.Component;
import by.mustaphin.textoperation.composite.Composite;
import by.mustaphin.textoperation.composite.Leaf;
import by.mustaphin.textoperation.constant.RegularExpression;
import java.util.ArrayList;
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

    public void handleRequest(ArrayList<String> data, Component component) {
	textAppearsLeaf(data, component);//TODO седелать что бы остальные звенья проверки не вызывались
	List<String> handled = new ArrayList<>();
	Pattern pattern = Pattern.compile(regularExpression);
	List<Component> components = findComposite(component);
	int index = 0;
	for (String string : data) {
	    Matcher matcher = pattern.matcher(string);
	    while (matcher.find()) {
		String text = matcher.group();
//		Leaf leaf = findLeaf(text, RegularExpression.SINGLE_LEXEME);//TODO create correct regular expression for finding single lexeme
		Leaf leaf = null;
		if (null != leaf) {
		    components.get(index).add(leaf);
		} else {
		    handled.add(text);
		    components.get(index).add(new Composite());
		}
	    }
	    index++;
	}
	data = new ArrayList<>();
	data.addAll(handled);
    }

    protected List<Component> findComposite(Component component) {
	List<Component> innerComponent = new ArrayList<>();
	if (component.getData().isEmpty()) {
	    innerComponent.add(component);
	} else {
	    findBottom(component, innerComponent);
	}
	return innerComponent;
    }

    private void findBottom(Component component, List<Component> innerComponent) {
	for (Component part : component.getData()) {
	    if (null != part.getData()) {
		if (part.getData().isEmpty()) {
		    innerComponent.add(part);
		} else {
		    findBottom(part, innerComponent);
		}
	    }
	}
    }

    private void textAppearsLeaf(ArrayList<String> data, Component component) {
	if (component.getData().isEmpty() && data.size() == 1) {
	    Leaf leaf = findLeaf(data.get(0), RegularExpression.SINGLE_LEXEME);
	    if (null != leaf) {
		component = leaf;
		data = new ArrayList<>();
	    }
	}
    }

    protected Leaf findLeaf(String data, String leafRegExp) {
	Leaf leaf = null;
	Pattern pattern = Pattern.compile(leafRegExp);
	Matcher matcher = pattern.matcher(data);
	if (matcher.find()) {
	    leaf = new Leaf(data);
	}
	return leaf;
    }

    public void chain(ArrayList<String> data, Component component) {
	handleRequest(data, component);
	successor.chain(data, component);
    }

    public static class DefaultHandlerRequest extends Handler {

	private static DefaultHandlerRequest handler = new DefaultHandlerRequest(RegularExpression.LEXEME);//TODO replace definition of regular expression to another location

	public static DefaultHandlerRequest getHandler() {
	    return handler;
	}

	private DefaultHandlerRequest(String regExp) {
	    super(regExp);
	}

	@Override
	public void handleRequest(ArrayList<String> data, Component component) {
	    Pattern pattern = Pattern.compile(regularExpression);
	    List<Component> components = findComposite(component);
	    int index = 0;
	    for (String string : data) {
		Matcher matcher = pattern.matcher(string);
		while (matcher.find()) {
		    components.get(index).add(new Leaf(matcher.group()));
		}
		index++;
	    }
	}

	@Override
	public void chain(ArrayList<String> data, Component component) {
	    handleRequest(data, component);
	    System.out.println(component.operate());
	}

    }

}
