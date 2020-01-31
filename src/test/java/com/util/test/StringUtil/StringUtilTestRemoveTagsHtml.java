/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.util.test.StringUtil;

import static com.util.StringUtil.removeTagsHtml;
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
public class StringUtilTestRemoveTagsHtml {

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
    public void StringUtilTest_RemoveTagsHtml_String_Null_Return_Null() {
        //Arrange
        String text = null;

        //Act
        String result = removeTagsHtml(text);

        //Assert
        assertNull(result);
    }

    @Test
    public void StringUtilTest_RemoveTagsHtml_String_Empty_Return_Null() {
        //Arrange
        String text1 = "  ";
        String text2 = "    ";
        String text3 = "        ";

        //Act
        String result1 = removeTagsHtml(text1);
        String result2 = removeTagsHtml(text2);
        String result3 = removeTagsHtml(text3);

        //Assert
        assertNull(result1);
        assertNull(result2);
        assertNull(result3);
    }

    @Test
    public void StringUtilTest_RemoveTagsHtml_String_With_Tags_Return_Clean() {
        //Arrange
        String text1 = "<p>\n"
                + "	Hello <strong>world</strong>!!\n"
                + "	</br> I'm a html paragraph.\n"
                + "</p>";
        String text2 = "<div>\n"
                + "                        <h5 class=\"-title\"><a href=\"https://example.com\" data-gps-track=\"footer.click({ location: 2, link: 30 })\">Stack Exchange<br> Network</a></h5>\n"
                + "                        <ul class=\"-list\">\n"
                + "                            <li class=\"-item\"><a href=\"#\" class=\"-link _expandable \" data-gps-track=\"footer.click({ location: 2, link: 24 })\" data-target=\"Technology\">Technology</a></li>\n"
                + "                            <li class=\"-item\"><a href=\"#\" class=\"-link _expandable \" data-gps-track=\"footer.click({ location: 2, link: 24 })\" data-target=\"Life / Arts\">Life / Arts</a></li>\n"
                + "                            <li class=\"-item\"><a href=\"#\" class=\"-link _expandable \" data-gps-track=\"footer.click({ location: 2, link: 24 })\" data-target=\"Culture / Recreation\">Culture / Recreation</a></li>\n"
                + "                            <li class=\"-item\"><a href=\"#\" class=\"-link _expandable \" data-gps-track=\"footer.click({ location: 2, link: 24 })\" data-target=\"Science\">Science</a></li>\n"
                + "                            <li class=\"-item\"><a href=\"#\" class=\"-link _expandable \" data-gps-track=\"footer.click({ location: 2, link: 24 })\" data-target=\"Other\">Other</a></li>\n" + "\n"
                + "                        </ul>\n"
                + "                    </div>";
        String text3 = "  <div class=\"p-note user-profile-bio js-user-profile-bio\"><div>21 yo, IT Technician, Information Systems Student(Faculdade de Tecnologia Impacta) Java programmer.</div></div>";

        //Act
        String result1 = removeTagsHtml(text1);
        String result2 = removeTagsHtml(text2);
        String result3 = removeTagsHtml(text3);

        //Assert
        assertNotNull(result1);
        assertNotNull(result2);
        assertNotNull(result3);
    }

    @Test
    public void StringUtilTest_RemoveTagsHtml_String_Without_Tags_Return_the_Same_String() {
        //Arrange
        String text1 = "Hello world!! I'm a html paragraph.";
        String text2 = "Stack Exchange Network Technology Life / Arts Culture / Recreation Science Other";
        String text3 = "21 yo, IT Technician, Information Systems Student(Faculdade de Tecnologia Impacta) Java programmer.";

        //Act
        String result1 = removeTagsHtml(text1);
        String result2 = removeTagsHtml(text2);
        String result3 = removeTagsHtml(text3);

        //Assert
        assertNotNull(result1);
        assertNotNull(result2);
        assertNotNull(result3);
        
        assertEquals(text1, result1);
        assertEquals(text2, result2);
        assertEquals(text3, result3);
    }

}
