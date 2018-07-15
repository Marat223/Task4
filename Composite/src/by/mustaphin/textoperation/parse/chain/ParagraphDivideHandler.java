/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.mustaphin.textoperation.parse.chain;

import by.mustaphin.textoperation.parse.RegularExpression;
import java.util.List;

/**
 *
 * @author me
 */
public class ParagraphDivideHandler extends AbstractHandler {

    @Override
    public void handleRequest(List<String> text) {
	String[] part = text.get(0).split(RegularExpression.PARAGRAPH);
	for (String string : part) {
	    System.out.println(string);
	    System.out.println("_-=-_-=-_-=-_-=-_-=-_-=-_-=-_-=-_-=-_-=-_-=-_-=-_-=-_-=-_-=-_-=-_-=-_");
	}
//	List<List> divded = new ArrayList<>();
    }

}
