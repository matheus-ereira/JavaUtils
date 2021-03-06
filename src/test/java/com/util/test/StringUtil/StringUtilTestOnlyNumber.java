package com.util.test.StringUtil;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import static com.util.StringUtil.onlyNumber;
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
public class StringUtilTestOnlyNumber {

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

    @Test
    public void StringUtilTest_OnlyNumber_String_Null_Return_Null() {
        //Arrange
        String text = null;

        //Act
        String result = onlyNumber(text);

        //Assert
        assertNull(result);
    }

    @Test
    public void StringUtilTest_OnlyNumber_String_Empty_Return_Null() {
        //Arrange
        String text1 = "  ";
        String text2 = "    ";
        String text3 = "        ";

        //Act
        String result1 = onlyNumber(text1);
        String result2 = onlyNumber(text2);
        String result3 = onlyNumber(text3);

        //Assert
        assertNull(result1);
        assertNull(result2);
        assertNull(result3);
    }

    @Test
    public void StringUtilTest_OnlyNumber_String_With_Characters_Return_Clean() {
        //Arrange
        String text1 = "123544AAAA554114";
        String text2 = "AAB2151BBB151251BAA";
        String text3 = "sadsd144141414141asddasd";

        //Act
        String result1 = onlyNumber(text1);
        String result2 = onlyNumber(text2);
        String result3 = onlyNumber(text3);

        //assert
        assertNotNull(result1);
        assertNotNull(result2);
        assertNotNull(result3);
        
        assertEquals("123544554114", result1);
        assertEquals("2151151251", result2);
        assertEquals("144141414141", result3);
    }

    @Test
    public void StringUtilTest_OnlyNumber_String_Without_Numbers_Return_Empty() {
        //Arrange
        String text1 = "dgsvgagdv/;/;;;/;/avwdadss";
        String text2 = "dasdsdsaw@##@$%$%$%dadasd";
        String text3 = "asddasskjfiksodkfkidsijfiwasbgvgbadsd";

        //Act
        String result1 = onlyNumber(text1);
        String result2 = onlyNumber(text2);
        String result3 = onlyNumber(text3);

        //Assert
        assertNotNull(result1);
        assertNotNull(result2);
        assertNotNull(result3);
        
        assertEquals("", result1);
        assertEquals("", result2);
        assertEquals("", result3);
    }
    
    @Test
    public void StringUtilTest_OnlyNumber_String_With_White_Spaces_and_Numbers_Return_Clean() {
        //Arrange
        String text1 = "     1 2    3 4 5    7 8 9     12";
        String text2 = "1245      78    96      456   147    561   12323";
        String text3 = "51   515 1561      545    651  5 611 15     51 55 1 151  1 41 45  151 ";

        //Act
        String result1 = onlyNumber(text1);
        String result2 = onlyNumber(text2);
        String result3 = onlyNumber(text3);

        //Assert
        assertNotNull(result1);
        assertNotNull(result2);
        assertNotNull(result3);
        
        assertEquals("1234578912", result1);
        assertEquals("1245789645614756112323", result2);
        assertEquals("5151515615456515611155155115114145151", result3);
    }
}
