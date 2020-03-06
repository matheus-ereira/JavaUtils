/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.util.test.StringUtil;

import static com.util.StringUtil.*;
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
public class StringUtilTestNextIndexOf {

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
    public void StringUtilTest_nextIndexOf_Null_Return_Negative_OK() {
        //Arrange
        int result1;
        int result2;

        //Act
        result1 = nextIndexOf(null, null);
        result2 = nextIndexOf(null, "substring");

        //Assert
        assertNotNull(result1);
        assertNotNull(result2);

        assertEquals(-1, result1);
        assertEquals(-1, result2);
    }

    @Test
    public void StringUtilTest_nextIndexOf_String_of_White_Spaces_Return_Index_OK() {
        //Arrange
        String text1 = "  ";
        String text2 = "    ";
        String text3 = "        ";
        String subString1 = " ";
        String subString2 = "   ";
        String subString3 = "       ";

        //Act
        int result1 = nextIndexOf(text1, subString1);
        int result2 = nextIndexOf(text2, subString2);
        int result3 = nextIndexOf(text3, subString3);

        //Assert
        assertNotNull(result1);
        assertNotNull(result2);
        assertNotNull(result3);

        assertEquals(1, result1);
        assertEquals(3, result2);
        assertEquals(7, result3);
    }

    @Test
    public void StringUtilTest_nextIndexOf_String_With_References_Return_Index_OK() {
        //Arrange
        String text1 = "<result: {id=1234, name=John Doe}>";
        String text2 = "<result: {id=1235, name=Jane Doe, type=Female}>";
        String text3 = "<result: {id=1236, name=Thor, type=Animal, age=2}>";
        String subString1 = "name=";
        String subString2 = "type=";
        String subString3 = "age=";

        //Act
        int result1 = nextIndexOf(text1, subString1);
        int result2 = nextIndexOf(text2, subString2);
        int result3 = nextIndexOf(text3, subString3);

        //Assert
        assertNotNull(result1);
        assertNotNull(result2);
        assertNotNull(result3);

        assertEquals(24, result1);
        assertEquals(39, result2);
        assertEquals(47, result3);
    }
    
    @Test
    public void StringUtilTest_nextIndexOf_References_NotFound_Return_Negative_OK() {
        //Arrange
        String text1 = "<result: {id=1234, name=John Doe, type=null, age=null}>";
        String text2 = "<result: {id=1235, name=Jane Doe, type=Female, age=null}>";
        String text3 = "<result: {id=1236, name=Thor, type=Animal, age=2}>";
        String subString1 = "jedi";
        String subString2 = "sith";
        String subString3 = "grey";

        //Act
        int result1 = nextIndexOf(text1, subString1);
        int result2 = nextIndexOf(text2, subString2);
        int result3 = nextIndexOf(text3, subString3);

        //Assert
        assertNotNull(result1);
        assertNotNull(result2);
        assertNotNull(result3);

        assertEquals(-1, result1);
        assertEquals(-1, result2);
        assertEquals(-1, result3);
    }

}
