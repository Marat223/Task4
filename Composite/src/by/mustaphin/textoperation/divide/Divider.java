/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.mustaphin.textoperation.divide;

import by.mustaphin.textoperation.composite.taskconcrete.LexemeLeaf;
import by.mustaphin.textoperation.parse.LexemeDivedeHandler;
import by.mustaphin.textoperation.parse.ParagraphDivideHandler;
import by.mustaphin.textoperation.parse.SentenceDivideHandler;
import by.mustaphin.textoperation.utill.TextReader;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author me
 */
public class Divider {

    public void createParts() {
	TextReader textReader = new TextReader();
	LexemeDivedeHandler lexemeDivedeHandler = new LexemeDivedeHandler();
	SentenceDivideHandler sentenceDivideHandler = new SentenceDivideHandler(lexemeDivedeHandler);
	ParagraphDivideHandler paragraphDivideHandler = new ParagraphDivideHandler(sentenceDivideHandler);
	paragraphDivideHandler.chain(Arrays.asList(textReader.read()));
	List<String> lexeme = lexemeDivedeHandler.getText();
	LexemeLeaf lexemeLeaf = new LexemeLeaf(lexeme.get(0));
    }
}
