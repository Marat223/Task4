/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.mustaphin.textoperation.exception;

/**
 *
 * @author me
 */
public class ComponentException extends Exception{
    
    public ComponentException() {
    }

    public ComponentException(String message) {
	super(message);
    }

    public ComponentException(String message, Throwable cause) {
	super(message, cause);
    }

    public ComponentException(Throwable cause) {
	super(cause);
    }
    
}
