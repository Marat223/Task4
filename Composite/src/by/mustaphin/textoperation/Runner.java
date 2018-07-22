/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.mustaphin.textoperation;

import by.mustaphin.textoperation.composite.Composite;
import by.mustaphin.textoperation.constant.RegularExpression;
import by.mustaphin.textoperation.handle.Handler;
import by.mustaphin.textoperation.preset.ParagraphPreset;
import by.mustaphin.textoperation.preset.SentensePreset;
import by.mustaphin.textoperation.preset.TextPreset;
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
	Handler sentenceDivideHandler = new Handler(new SentensePreset(RegularExpression.SENTENCE));
	Handler paragraphDivideHandler = new Handler(sentenceDivideHandler, new ParagraphPreset(RegularExpression.PARAGRAPH));
	ArrayList<String> data = new ArrayList<>();
	data.add(new TextReader().read());
	Composite component = new Composite(new TextPreset());
	paragraphDivideHandler.chain(data, component);
	System.out.println(component.operate());
    }

}
