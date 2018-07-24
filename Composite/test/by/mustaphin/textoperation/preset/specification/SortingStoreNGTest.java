/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.mustaphin.textoperation.preset.specification;

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
public class SortingStoreNGTest {
    
    public SortingStoreNGTest() {
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
     * Тест метод getInstanse, класса SortingStore.
     */
    @Test
    public void testGetInstanse() {
	System.out.println("getInstanse");
	SortingStore expResult = null;
	SortingStore result = SortingStore.getInstanse();
	assertEquals(result, expResult);
    }

    /**
     * Тест метод addComponent, класса SortingStore.
     */
    @Test
    public void testAddComponent() {
	System.out.println("addComponent");
	Component component = null;
	SortingStore instance = null;
	instance.addComponent(component);
    }

    /**
     * Тест метод get, класса SortingStore.
     */
    @Test
    public void testGet() {
	System.out.println("get");
	SortingStore instance = null;
	List expResult = null;
	List result = instance.get();
	assertEquals(result, expResult);
    }
    
}
