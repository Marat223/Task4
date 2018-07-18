/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.mustaphin.textoperation.divide;

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
	this.successor = DefaultHandlerRequest.getHandler();
	regularExpression = regExp;
    }

    public void handleRequest(ArrayList<String> data, String regEx) {
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

    public void chain(ArrayList<String> data) {
	handleRequest(data, regularExpression);
	successor.chain(data);
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
	public void chain(ArrayList<String> data) {
	    handleRequest(data, regularExpression);
	}

	@Override
	public void handleRequest(ArrayList<String> data, String regEx) {
	    for (String string : data) {
		System.out.println(string);
	    }
	}

    }

}
