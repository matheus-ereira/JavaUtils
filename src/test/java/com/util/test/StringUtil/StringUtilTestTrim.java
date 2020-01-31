/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.util.test.StringUtil;

import static com.util.StringUtil.trim;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Matheus
 */
public class StringUtilTestTrim {

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    //Test for trim method
    @Test
    public void StringUtilTest_trim_Object_Null_Return_Empty_OK() {
        //Arrange
        Object object = null;
        String string = null;
        Integer integer = null;
        Double doublee = null;

        //Act
        String result1 = trim(object);
        String result2 = trim(string);
        String result3 = trim(integer);
        String result4 = trim(doublee);

        //Assert
        assertNotNull(result1);
        assertNotNull(result2);
        assertNotNull(result3);
        assertNotNull(result4);

        assertEquals("", result1);
        assertEquals("", result2);
        assertEquals("", result3);
        assertEquals("", result4);
    }

    @Test
    public void StringUtilTest_trim_String_of_White_Spaces_Return_Empty_OK() {
        //Arrange
        String text1 = "  ";
        String text2 = "    ";
        String text3 = "        ";

        //Act
        String result1 = trim(text1);
        String result2 = trim(text2);
        String result3 = trim(text3);

        //Assert
        assertNotNull(result1);
        assertNotNull(result2);
        assertNotNull(result3);

        assertEquals("", result1);
        assertEquals("", result2);
        assertEquals("", result3);
    }

    @Test
    public void StringUtilTest_trim_String_With_White_Spaces_Return_Clean_OK() {
        //Arrange
        String text1 = "test";
        String text2 = "    test";
        String text3 = "    test    ";
        String text4 = "  1 test 1  ";

        //Act
        String result1 = trim(text1);
        String result2 = trim(text2);
        String result3 = trim(text3);
        String result4 = trim(text4);

        //Assert
        assertNotNull(result1);
        assertNotNull(result2);
        assertNotNull(result3);
        assertNotNull(result4);

        assertEquals("test", result1);
        assertEquals("test", result2);
        assertEquals("test", result3);
        assertEquals("1 test 1", result4);
    }

    @Test
    public void StringUtilTest_trim_String_Numbers_Return_Strings_Clean_OK() {
        //Arrange
        int text1 = 1234;
        long text2 = 1234l;
        Integer text3 = 1234;
        Double text4 = 1234.00;
        Long text5 = 1234L;

        //Act
        String result1 = trim(text1);
        String result2 = trim(text2);
        String result3 = trim(text3);
        String result4 = trim(text4);
        String result5 = trim(text5);

        //Assert
        assertNotNull(result1);
        assertNotNull(result2);
        assertNotNull(result3);
        assertNotNull(result4);
        assertNotNull(result5);

        assertEquals("1234", result1);
        assertEquals("1234", result2);
        assertEquals("1234", result3);
        assertEquals("1234.0", result4);
        assertEquals("1234", result5);
    }

    @Test
    public void StringUtilTest_trim_Object_Return_Clean_OK() {
        //Arrange
        Object text = new Object();

        //Act
        String result = trim(text);

        //Assert
        assertNotNull(result);
        assertEquals(text.toString(), result);
    }
}
