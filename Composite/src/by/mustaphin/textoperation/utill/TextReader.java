/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.mustaphin.textoperation.utill;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 *
 * @author me
 */
public class TextReader {

    public String read() {
	String text = null;
	try {//TODO make relative path
	    text = new String(Files.readAllBytes(Paths.get("D:\\NetBeansProjects\\Task4\\Composite\\src\\by\\mustaphin\\textoperation\\utill\\text")));
	} catch (IOException ex) {
	    ex.printStackTrace();
	}
	return text;
    }
}
