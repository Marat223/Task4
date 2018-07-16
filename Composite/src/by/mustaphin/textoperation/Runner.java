/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.mustaphin.textoperation;

import by.mustaphin.textoperation.parse.LexemeDivedeHandler;
import by.mustaphin.textoperation.parse.ParagraphDivideHandler;
import by.mustaphin.textoperation.parse.SentenceDivideHandler;
import by.mustaphin.textoperation.utill.TextReader;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author me
 */
public class Runner {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
	TextReader textReader = new TextReader();
	LexemeDivedeHandler lexemeDivedeHandler = new LexemeDivedeHandler();
	SentenceDivideHandler sentenceDivideHandler = new SentenceDivideHandler(lexemeDivedeHandler);
	ParagraphDivideHandler paragraphDivideHandler = new ParagraphDivideHandler(sentenceDivideHandler);
	List<String> text = new ArrayList<>();
	text.add(textReader.read());
	paragraphDivideHandler.chain(text);
	List<String> resultText = lexemeDivedeHandler.getText();
	for (String string : resultText) {
	    System.out.println(string);
	}
    }
}
