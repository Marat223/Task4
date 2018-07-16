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
public class LexemeDivedeHandler extends AbstractHandler {

    @Override
    public void handleRequest(List<String> text) {
	List<String> lexeme = new ArrayList<>(text);
	text.clear();
	Pattern patternParagraph = Pattern.compile(RegularExpression.LEXEME);
	for (String single : lexeme) {
	    Matcher matcher = patternParagraph.matcher(single);
	    while (matcher.find()) {
		text.add(matcher.group());
	    }
	}
    }

}
