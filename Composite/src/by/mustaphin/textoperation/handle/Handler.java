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
import by.mustaphin.textoperation.preset.AbstractPreset;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 *
 * @author me
 */
public class Handler {

    private final Logger LOGGER = Logger.getLogger(Handler.class);

    private Handler successor;
    protected AbstractPreset preset;

    public Handler(Handler successor, AbstractPreset preset) {
	this.successor = successor;
	this.preset = preset;
    }

    public Handler() {
    }

    public Handler(AbstractPreset preset) {
	successor = DefaultHandlerRequest.getHandler();
	this.preset = preset;
    }

    public void handleRequest(final ArrayList<String> DATA, Component component) {
	if (!textAppearsLeaf(DATA, component)) {
	    List<String> handled = new ArrayList<>();
	    Pattern pattern = Pattern.compile(preset.getRegularExpression());
	    List<Component> components = findComposite(component);
	    int index = 0;
	    for (String string : DATA) {
		Matcher matcher = pattern.matcher(string);
		while (matcher.find()) {
		    String text = matcher.group();
//		Leaf leaf = findLeaf(text, RegularExpression.SINGLE_LEXEME_REGULAR_EXPRESSION);//TODO create correct regular expression for finding single lexeme
		    Leaf leaf = null;
		    if (null != leaf) {
			components.get(index).add(leaf);
			LOGGER.log(Level.INFO, "create leaf");
		    } else {
			handled.add(text);
			components.get(index).add(new Composite(preset));
			LOGGER.log(Level.INFO, "create branch " + preset.getType());
		    }
		}
		index++;
	    }
	    DATA.clear();
	    DATA.addAll(handled);
	}
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

    private boolean textAppearsLeaf(final ArrayList<String> data, Component component) {
	boolean textIsLeaf = false;
	if (data.size() == 1 && component.getData().isEmpty()) {
//	    Leaf leaf = findLeaf(data.get(0), RegularExpression.SINGLE_LEXEME_REGULAR_EXPRESSION);//TODO create correct regular expression for finding single lexeme
	    Leaf leaf = null;
	    if (null != leaf) {
		component = leaf;
		data.clear();
		textIsLeaf = true;
		LOGGER.log(Level.INFO, "top level component is leaf");
	    }
	}
	return textIsLeaf;
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

	private final Logger LOGGER = Logger.getLogger(Handler.class);

	private static DefaultHandlerRequest handler = new DefaultHandlerRequest();

	public static DefaultHandlerRequest getHandler() {
	    return handler;
	}

	@Override
	public void handleRequest(ArrayList<String> data, Component component) {
	    Pattern pattern = Pattern.compile(RegularExpression.LEXEME_REGULAR_EXPRESSION);
	    List<Component> components = findComposite(component);
	    int index = 0;
	    for (String string : data) {
		Matcher matcher = pattern.matcher(string);
		while (matcher.find()) {
		    components.get(index).add(new Leaf(matcher.group()));
		    LOGGER.log(Level.INFO, "create bottom leaf");
		}
		index++;
	    }
	}

	@Override
	public void chain(ArrayList<String> data, Component component) {
	    handleRequest(data, component);
	}

    }

}
