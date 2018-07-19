/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.mustaphin.textoperation;

import by.mustaphin.textoperation.composite.Component;
import by.mustaphin.textoperation.constant.RegularExpression;
import by.mustaphin.textoperation.divide.DivideHandler;
import by.mustaphin.textoperation.utill.TextReader;
import java.util.ArrayList;

/**
 *
 * @author me
 */
public class Runner {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//	DivideHandler lexemeDivedeHandler = new DivideHandler(RegularExpression.LEXEME);
	DivideHandler sentenceDivideHandler = new DivideHandler(RegularExpression.SENTENCE);
	DivideHandler paragraphDivideHandler = new DivideHandler(sentenceDivideHandler, RegularExpression.PARAGRAPH);
	ArrayList<String> data = new ArrayList<>();
	data.add(new TextReader().read());
	Component component = new Component();
	paragraphDivideHandler.chain(data, component);
    }

}
