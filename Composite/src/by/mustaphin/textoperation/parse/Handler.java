/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.mustaphin.textoperation.parse;

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

    public void handleRequest(ArrayList<String> data, String regEx) {
	List<String> handled = new ArrayList<>(data);
	Pattern pattern = Pattern.compile(regEx);
	data = new ArrayList<>();
	for (String string : handled) {
	    Matcher matcher = pattern.matcher(string);
	    while (matcher.matches()) {
		data.add(matcher.group());
	    }
	}

    }

    public void chain(ArrayList<String> data) {
	handleRequest(data, regularExpression);
	successor.chain(data);
    }

    public static class DefaultHandlerRequest extends Handler {

	private static DefaultHandlerRequest handler = new DefaultHandlerRequest(RegularExpression.EMPTY);//TODO

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
		System.out.println(string + " ");
	    }
	}

    }
}
