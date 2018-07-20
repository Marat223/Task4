/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.mustaphin.textoperation.assembly;

import by.mustaphin.textoperation.composite.Component;
import by.mustaphin.textoperation.constant.RegularExpression;
import java.util.List;
import java.util.regex.Pattern;

/**
 *
 * @author me
 */
public class Assembly {

    public String construct(List<Component> component) {
	StringBuilder stringBuilder = new StringBuilder();
	Pattern patternLexeme = Pattern.compile(RegularExpression.LEXEME);
	Pattern patternSentense = Pattern.compile(RegularExpression.SENTENCE);
	Pattern patternParagraph = Pattern.compile(RegularExpression.PARAGRAPH);
	for (Component inner : component) {
	    stringBuilder.append(inner.operate());//TODO доделать!!!
	}
	return stringBuilder.toString();
    }

}
