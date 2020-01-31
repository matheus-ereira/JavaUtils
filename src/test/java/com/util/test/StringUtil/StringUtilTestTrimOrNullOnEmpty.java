/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.util.test.StringUtil;

import static com.util.StringUtil.trimOrNullOnEmpty;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Matheus
 */
public class StringUtilTestTrimOrNullOnEmpty {

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

    //Test for trimOrNullOnEmpty
    @Test
    public void StringUtilTest_trimOrNullOnEmpty_String_Empty_Return_Null_OK() {
        //Arrange
        String text1 = "  ";
        String text2 = "    ";
        String text3 = "        ";

        //Act
        String result1 = trimOrNullOnEmpty(text1);
        String result2 = trimOrNullOnEmpty(text2);
        String result3 = trimOrNullOnEmpty(text3);

        //Assert
        assertNull(result1);
        assertNull(result2);
        assertNull(result3);
    }

    @Test
    public void StringUtilTest_trimOrNullOnEmpty_Object_Null_Return_Null_OK() {
        //Arrange
        Object object = null;
        String string = null;
        Integer integer = null;
        Double doublee = null;

        //Act
        String result1 = trimOrNullOnEmpty(object);
        String result2 = trimOrNullOnEmpty(string);
        String result3 = trimOrNullOnEmpty(integer);
        String result4 = trimOrNullOnEmpty(doublee);

        //Assert
        assertNull(result1);
        assertNull(result2);
        assertNull(result3);
        assertNull(result4);
    }

    @Test
    public void StringUtilTest_trimOrNullOnEmpty_String_With_White_Spaces_Return_Clean_OK() {
        //Arrange
        String text1 = "test";
        String text2 = "    test";
        String text3 = "    test    ";
        String text4 = "  1 test 1  ";

        //Act
        String result1 = trimOrNullOnEmpty(text1);
        String result2 = trimOrNullOnEmpty(text2);
        String result3 = trimOrNullOnEmpty(text3);
        String result4 = trimOrNullOnEmpty(text4);

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
    public void StringUtilTest_trimOrNullOnEmpty_Numbers_Return_Strings_Clean_OK() {
        //Arrange
        int text1 = 1234;
        long text2 = 1234l;
        Integer text3 = 1234;
        Double text4 = 1234.00;
        Long text5 = 1234L;

        //Act
        String result1 = trimOrNullOnEmpty(text1);
        String result2 = trimOrNullOnEmpty(text2);
        String result3 = trimOrNullOnEmpty(text3);
        String result4 = trimOrNullOnEmpty(text4);
        String result5 = trimOrNullOnEmpty(text5);

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
        String result = trimOrNullOnEmpty(text);

        //Assert
        assertNotNull(result);
        assertEquals(text.toString(), result);
    }
}
