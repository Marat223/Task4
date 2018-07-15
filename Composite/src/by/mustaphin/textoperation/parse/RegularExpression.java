/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.mustaphin.textoperation.parse;

/**
 *
 * @author me
 */
public class RegularExpression {

    public static final String PARAGRAPH = "(\\s{4})(\\p{Upper}{1})(.+)";
    public static final String SENTENCE = "^(\\p{Upper})+[A-Za-z,;'\"\\s]+([.?!]$)|([\\.]{3}$)";
}
