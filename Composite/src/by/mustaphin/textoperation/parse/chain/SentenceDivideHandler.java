/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.mustaphin.textoperation.parse.chain;

import by.mustaphin.textoperation.parse.RegularExpression;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author me
 */
public class SentenceDivideHandler extends AbstractHandler {

    @Override
    public void handleRequest(List<String> text) {
	List<String> sentences = new ArrayList<>(text);
	text = new ArrayList<>();
	Pattern patternParagraph = Pattern.compile(RegularExpression.SENTENCE);
	for (String sentence : sentences) {
	    Matcher matcher = patternParagraph.matcher(sentence);
	    while (matcher.find()) {
		text.add(matcher.group());
	    }
	}
	System.out.println("text.size() " + text.size());
	for (String sentence : text) {
	    System.out.println(sentence + "\n");
	}
    }

}
