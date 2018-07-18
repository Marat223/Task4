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
import java.util.Iterator;
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

    public void handleRequest(ArrayList<String> data, IComposite component) {//TODO предполагаем, что на входе сложный текст
	parse(data, regularExpression);
	List<IComposite> components = findComponents(component);//TODO
	int index = 0;
	Iterator<String> dataIterator = data.iterator();
	while (dataIterator.hasNext()) {
	    Leaf leaf = findLeaf(dataIterator.next(), RegularExpression.LEXEME);
	    if (null != leaf) {
		components.get(index).add(leaf);
		dataIterator.remove();
	    } else {
		components.get(index).add(new Component());
		index++;
	    }
	}
    }

    private List<IComposite> findComponents(IComposite component) {//TODO сделать метод поиска сложных компонентов
	List<IComposite> innerComponent = new ArrayList<>();
	for (IComposite paragraphComponent : component.getData()) {
	    
	}
	return innerComponent;
    }

    private List<IComposite> findComponents(List<IComposite> component) {
	List<IComposite> innerComponent = new ArrayList<>();
	for (IComposite subComponent : component) {
	    if (null != subComponent.getData()) {
		innerComponent.add(subComponent);
	    }
	}
	for (IComposite subComponent : innerComponent) {
	    
	}
	return innerComponent;
    }

    private void parse(ArrayList<String> data, String regEx) {
	List<String> handled = new ArrayList<>();
	Pattern pattern = Pattern.compile(regEx);
	for (String string : data) {
	    Matcher matcher = pattern.matcher(string);
	    while (matcher.find()) {
		handled.add(matcher.group());
	    }
	}
	data.clear();
	data.addAll(handled);
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
