/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.mustaphin.textoperation.divide;

import by.mustaphin.textoperation.composite.Component;
import by.mustaphin.textoperation.parse.LexemeDivideHandler;
import by.mustaphin.textoperation.parse.ParagraphDivideHandler;
import by.mustaphin.textoperation.parse.SentenceDivideHandler;
import by.mustaphin.textoperation.utill.TextReader;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author me
 */
public class Combiner {

    public void createPartsByList() {
	TextReader textReader = new TextReader();
	LexemeDivideHandler lexemeDivedeHandler = new LexemeDivideHandler();
	SentenceDivideHandler sentenceDivideHandler = new SentenceDivideHandler(lexemeDivedeHandler);
	ParagraphDivideHandler paragraphDivideHandler = new ParagraphDivideHandler(sentenceDivideHandler);
	paragraphDivideHandler.chain(Arrays.asList(textReader.read()));

	List<String> lexeme = lexemeDivedeHandler.getText();
	Component lexemeLeaf = new Component(lexeme.get(0));
    }

    public void createPartsByComponent() {
	TextReader textReader = new TextReader();
	Component component = new Component(textReader.read());
	LexemeDivideHandler lexemeDivedeHandler = new LexemeDivideHandler();
	SentenceDivideHandler sentenceDivideHandler = new SentenceDivideHandler(lexemeDivedeHandler);
	ParagraphDivideHandler paragraphDivideHandler = new ParagraphDivideHandler(sentenceDivideHandler);
	paragraphDivideHandler.chain(component);
    }

}
