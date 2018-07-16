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
public class ParagraphDivideHandler extends AbstractHandler {

    public ParagraphDivideHandler(AbstractHandler successor) {
	super(successor);
    }
    
    @Override
    public void handleRequest(List<String> text) {
	Pattern patternParagraph = Pattern.compile(RegularExpression.PARAGRAPH);
	Matcher matcher = patternParagraph.matcher(text.get(0));
	text = new ArrayList<>();
	while (matcher.find()) {
	    text.add(matcher.group());
	}
    }

}
