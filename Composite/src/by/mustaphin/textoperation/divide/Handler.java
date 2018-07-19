/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.mustaphin.textoperation.divide;

import by.mustaphin.textoperation.composite.Composite;
import by.mustaphin.textoperation.composite.Leaf;
import by.mustaphin.textoperation.constant.RegularExpression;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import by.mustaphin.textoperation.composite.Component;

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
	List<String> handled = new ArrayList<>();
	Pattern pattern = Pattern.compile(regularExpression);
	List<Component> components = findComponents(component);
	int index = 0;
	for (String string : data) {
	    Matcher matcher = pattern.matcher(string);
	    while (matcher.find()) {
		String text = matcher.group();
		Leaf leaf = findLeaf(text, RegularExpression.SINGLE_LEXEME);
		if (null != leaf) {
		    components.get(index).add(leaf);
		} else {
		    handled.add(text);
		    components.get(index).add(new Composite());
		}
	    }
	    index++;
	}
	data.clear();
	data.addAll(handled);
    }

    protected List<Component> findComponents(Component component) {
	List<Component> innerComponent = new ArrayList<>();
	if (component.getData().isEmpty()) {
	    innerComponent.add(component);
	} else {
	    for (Component paragraphComponent : component.getData()) {
		if (null != paragraphComponent.getData()) {
		    if (paragraphComponent.getData().isEmpty()) {
			innerComponent.add(paragraphComponent);
		    } else {
			for (Component sentenseComponent : paragraphComponent.getData()) {
			    if (null != sentenseComponent.getData()) {
				if (sentenseComponent.getData().isEmpty()) {
				    innerComponent.add(sentenseComponent);
				}
			    }
			}
		    }
		}
	    }
	}
	return innerComponent;
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

	private static DefaultHandlerRequest handler = new DefaultHandlerRequest(RegularExpression.EMPTY);

	public static DefaultHandlerRequest getHandler() {
	    return handler;
	}

	private DefaultHandlerRequest(String regExp) {
	    super(regExp);
	}

	@Override
	public void handleRequest(ArrayList<String> data, Component component) {
	    List<Component> components = findComponents(component);
	    int index = 0;
	    for (String string : data) {
		components.get(index).add(new Leaf(string));
		index++;
	    }
	}

	@Override
	protected List<Component> findComponents(Component component) {
	    return super.findComponents(component);
	}

    }

}