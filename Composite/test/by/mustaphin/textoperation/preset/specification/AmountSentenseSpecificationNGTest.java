/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.mustaphin.textoperation.preset.specification;

import by.mustaphin.textoperation.composite.Component;
import by.mustaphin.textoperation.preset.Type;
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
public class AmountSentenseSpecificationNGTest {

    public AmountSentenseSpecificationNGTest() {
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
     * Тест метод specified, класса AmountSentenseSpecification.
     */
    @Test
    public void testSpecified() {
	System.out.println("specified");
	List<Component> component = null;
	Type type = null;
	AmountSentenseSpecification instance = new AmountSentenseSpecification();
	List expResult = null;
	List result = instance.specified(component, type);
	assertEquals(result, expResult);
    }

}
