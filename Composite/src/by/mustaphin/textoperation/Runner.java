/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.mustaphin.textoperation;

import by.mustaphin.textoperation.parse.TextReader;
import by.mustaphin.textoperation.parse.chain.ParagraphDivideHandler;
import java.util.Arrays;

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
	ParagraphDivideHandler paragraphDivideHandler = new ParagraphDivideHandler();
	paragraphDivideHandler.handleRequest(Arrays.asList("    Hello, World!\n    I'm here!\n    zzzzz\n"));
//	System.out.println(textReader.read());
    }

}
