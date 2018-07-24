/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.mustaphin.textoperation;

import by.mustaphin.textoperation.composite.Composite;
import by.mustaphin.textoperation.constant.RegularExpression;
import by.mustaphin.textoperation.handle.Handler;
import by.mustaphin.textoperation.preset.AbstractPreset;
import by.mustaphin.textoperation.preset.SentensePreset;
import by.mustaphin.textoperation.preset.TextPreset;
import by.mustaphin.textoperation.preset.Type;
import by.mustaphin.textoperation.preset.specification.AmountSentenseSpecification;
import by.mustaphin.textoperation.preset.specification.LengthLexemeSpecification;
import by.mustaphin.textoperation.preset.specification.Specification;
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
	AbstractPreset sentensePreset = new SentensePreset(RegularExpression.SENTENCE, Type.SENTENSE);
	AbstractPreset paragraphPreset = new SentensePreset(RegularExpression.PARAGRAPH, Type.PARAGRAPH);
	AbstractPreset textPreset = new TextPreset(Type.TEXT);

	Specification amountSentense = new AmountSentenseSpecification();
	Specification lengthLexeme = new LengthLexemeSpecification();

	Handler sentenceDivideHandler = new Handler(sentensePreset);
	Handler paragraphDivideHandler = new Handler(sentenceDivideHandler, paragraphPreset);

	ArrayList<String> data = new ArrayList<>();
	data.add(new TextReader().read());

	Composite component = new Composite(textPreset);
	paragraphDivideHandler.chain(data, component);

	System.out.println(component.operate());
//	System.out.println(component.operate(amountSentense));
//	System.out.println(component.operate(lengthLexeme));
    }

}
