/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.mustaphin.textoperation.parse;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author me
 */
public class DefaultHandelr extends AbstractHandler {

    private List<String> text = new ArrayList<>();

    public List<String> getText() {
	return text;
    }

    @Override
    public void handleRequest(List<String> text) {
//	    for (String string : text) {
//		System.out.println(string + "\n");
//	    }
	text.addAll(text);
    }

    @Override
    public void chain(List<String> text) {
	handleRequest(text);
    }
}
