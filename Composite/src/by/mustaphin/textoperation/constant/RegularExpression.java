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

    private RegularExpression() {
    }

    public static final String PARAGRAPH = "\\p{Blank}{4}.+(\\s{1})";
    public static final String SENTENCE = "\\s+[^.!?]*[.!?]{1,3}";
    public static final String LEXEME = "\\w+[!?,.]*|[...]\\p{Blank}+";
    public static final String SINGLE_LEXEME = "\\w+[!?,.]*|[...]\\p{Blank}+?<!(\\s{1}\\w+)";
    public static final String EMPTY = "";

}
