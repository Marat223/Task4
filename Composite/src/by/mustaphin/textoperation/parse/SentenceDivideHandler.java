/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.mustaphin.textoperation.parse;

import by.mustaphin.textoperation.composite.Component;
import by.mustaphin.textoperation.composite.IComponent;
import by.mustaphin.textoperation.constant.RegularExpression;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author me
 */
public class SentenceDivideHandler extends AbstractHandler {

    public SentenceDivideHandler(AbstractHandler successor) {
	super(successor);
    }

    @Override
    public void handleRequest(List<String> text) {
	List<String> sentence = new ArrayList<>(text);
	text.clear();
	Pattern patternParagraph = Pattern.compile(RegularExpression.SENTENCE);
	for (String single : sentence) {
	    Matcher matcher = patternParagraph.matcher(single);
	    while (matcher.find()) {
		text.add(matcher.group());
	    }
	}
    }

    @Override
    public void handleRequest(IComponent component) {
	Pattern patternParagraph = Pattern.compile(RegularExpression.SENTENCE);
	//TODO добраться до leaf
	for (String single : sentence) {
	    Matcher matcher = patternParagraph.matcher(component.operate());
	    while (matcher.find()) {
		component.add(new Component(matcher.group()));
	    }
	}
    }

}
