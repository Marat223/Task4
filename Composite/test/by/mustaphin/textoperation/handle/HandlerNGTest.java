/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.mustaphin.textoperation.handle;

import by.mustaphin.textoperation.composite.Component;
import by.mustaphin.textoperation.composite.Leaf;
import java.util.ArrayList;
import java.util.List;
import static org.testng.Assert.assertEquals;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author me
 */
public class HandlerNGTest {

    public HandlerNGTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }

    /**
     * Тест метод handleRequest, класса Handler.
     */
    @Test
    public void testHandleRequest() {
	System.out.println("handleRequest");
	ArrayList<String> DATA = null;
	Component component = null;
	Handler instance = new Handler();
	instance.handleRequest(DATA, component);
    }

    /**
     * Тест метод findComposite, класса Handler.
     */
    @Test
    public void testFindComposite() {
	System.out.println("findComposite");
	Component component = null;
	Handler instance = new Handler();
	List expResult = null;
	List result = instance.findComposite(component);
	assertEquals(result, expResult);
    }

    /**
     * Тест метод findLeaf, класса Handler.
     */
    @Test
    public void testFindLeaf() {
	System.out.println("findLeaf");
	String data = "";
	String leafRegExp = "";
	Handler instance = new Handler();
	Leaf expResult = null;
	Leaf result = instance.findLeaf(data, leafRegExp);
	assertEquals(result, expResult);
    }

    /**
     * Тест метод chain, класса Handler.
     */
    @Test
    public void testChain() {
	System.out.println("chain");
	ArrayList<String> data = null;
	Component component = null;
	Handler instance = new Handler();
	instance.chain(data, component);
    }

}
