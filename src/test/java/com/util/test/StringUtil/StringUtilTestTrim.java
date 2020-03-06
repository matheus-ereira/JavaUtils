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
        String string = null;

        //Act
        String result = trim(string);

        //Assert
        assertNotNull(result);
        assertEquals("", result);
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
}
