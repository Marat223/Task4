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

    public static final String PARAGRAPH_REGULAR_EXPRESSION = "\\p{Blank}{4}.+(\\s{1})";
    public static final String SENTENCE_REGULAR_EXPRESSION = "\\s+[^.!?]*[.!?]{1,3}";
    public static final String LEXEME_REGULAR_EXPRESSION = "\\w+[!?,.]*|[...]\\p{Blank}+";
    public static final String SINGLE_LEXEME_REGULAR_EXPRESSION = "\\w+[!?,.]*|[...]\\p{Blank}+?<!(\\s{1}\\w+)";
    public static final String EMPTY_REGULAR_EXPRESSION = "";

}
