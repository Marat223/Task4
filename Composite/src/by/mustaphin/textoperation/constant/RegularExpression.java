/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.mustaphin.textoperation.constant;

/**
 *
 * @author me
 */
public class RegularExpression {

    public static final String PARAGRAPH = "(\\s{4})(\\p{Upper}{1})(.+)";
    public static final String SENTENCE = "\\s+[^.!?]*[.!?]|[...]";
    public static final String LEXEME = "\\w+[!?,.]*|[...]\\p{Blank}+";
}
