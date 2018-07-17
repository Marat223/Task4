/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.mustaphin.textoperation.divide;

import by.mustaphin.textoperation.composite.Component;
import by.mustaphin.textoperation.constant.RegularExpression;
import by.mustaphin.textoperation.parse.Handler;
import by.mustaphin.textoperation.utill.TextReader;

/**
 *
 * @author me
 */
public class Combiner {

    public void createPartsByComponent() {
	TextReader textReader = new TextReader();
	Component component = new Component(textReader.read());
	Handler lexemeDivedeHandler = new Handler(RegularExpression.LEXEME);
	Handler sentenceDivideHandler = new Handler(lexemeDivedeHandler, RegularExpression.SENTENCE);
	Handler paragraphDivideHandler = new Handler(sentenceDivideHandler, RegularExpression.PARAGRAPH);
	paragraphDivideHandler.chain(component);
    }

}
