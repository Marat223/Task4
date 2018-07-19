/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.mustaphin.textoperation.divide;

import by.mustaphin.textoperation.composite.Component;
import by.mustaphin.textoperation.composite.IComposite;
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
public class DivideHandler {

    private DivideHandler successor;
    protected String regularExpression;

    public DivideHandler(DivideHandler successor, String regExp) {
	this.successor = successor;
	regularExpression = regExp;
    }

    public DivideHandler(String regExp) {
//	this.successor = DefaultHandlerRequest.getHandler();
	regularExpression = regExp;
    }

    public void handleRequest(ArrayList<String> data, IComposite component) {
	List<String> handled = new ArrayList<>();
	Pattern pattern = Pattern.compile(regularExpression);
	List<IComposite> components = findComponents(component);
	int index = 0;
	for (String string : data) {
	    Matcher matcher = pattern.matcher(string);
	    while (matcher.find()) {
		String text = matcher.group();
		Leaf leaf = findLeaf(text, RegularExpression.LEXEME);
		if (null != leaf) {
		    components.get(index).add(leaf);
		} else {
		    handled.add(text);
		    components.get(index).add(new Component());
		}
	    }
	    index++;
	}
	data.clear();
	data.addAll(handled);
    }

    private List<IComposite> findComponents(IComposite component) {
	List<IComposite> innerComponent = new ArrayList<>();
	if (component.getData().isEmpty()) {
	    innerComponent.add(component);
	} else {
	    for (IComposite paragraphComponent : component.getData()) {
		if (null != paragraphComponent.getData()) {
		    if (paragraphComponent.getData().isEmpty()) {
			innerComponent.add(paragraphComponent);
		    } else {
			for (IComposite sentenseComponent : paragraphComponent.getData()) {
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

    private Leaf findLeaf(String data, String leafRegExp) {
	Leaf leaf = null;
	Pattern pattern = Pattern.compile(leafRegExp);
	Matcher matcher = pattern.matcher(data);
	if (matcher.find()) {
	    leaf = new Leaf(data);
	}
	return leaf;
    }

    public void chain(ArrayList<String> data, IComposite component) {
	handleRequest(data, component);
	successor.chain(data, component);
    }

    public static class DefaultHandlerRequest extends DivideHandler {

	private static DefaultHandlerRequest handler = new DefaultHandlerRequest(RegularExpression.EMPTY);

	public static DefaultHandlerRequest getHandler() {
	    return handler;
	}

	public DefaultHandlerRequest(String regExp) {
	    super(regExp);
	}

	@Override
	public void chain(ArrayList<String> data, IComposite component) {
	    handleRequest(data, null);
	}

	@Override
	public void handleRequest(ArrayList<String> data, IComposite component) {
	    for (String string : data) {
		System.out.println(string);
	    }
	}

    }

}
