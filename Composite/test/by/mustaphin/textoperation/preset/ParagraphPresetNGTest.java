/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.mustaphin.textoperation.preset;

import by.mustaphin.textoperation.composite.Component;
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
public class ParagraphPresetNGTest {

    public ParagraphPresetNGTest() {
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
     * Тест метод getRegularExpression, класса ParagraphPreset.
     */
    @Test
    public void testGetRegularExpression() {
	System.out.println("getRegularExpression");
	ParagraphPreset instance = null;
	String expResult = "";
	String result = instance.getRegularExpression();
	assertEquals(result, expResult);
    }

    /**
     * Тест метод assembly, класса ParagraphPreset.
     */
    @Test
    public void testAssembly() {
	System.out.println("assembly");
	List<Component> component = null;
	ParagraphPreset instance = null;
	String expResult = "";
	String result = instance.assembly(component);
	assertEquals(result, expResult);
    }

}
