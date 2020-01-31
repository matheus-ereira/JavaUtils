/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.util;

/**
 *
 * @author Matheus
 */
public class StringUtil {

    /**
     * Method responsible for removing white spaces in start and end of an
     * string
     *
     * @param object text to be formatted
     * @return returns an empty string if the object is null, otherwise it
     * returns a string without white spaces.
     */
    public static String trim(Object object) {
        if (object == null) return "";
        
        return String.valueOf(object).trim();
    }

    /**
     * Method responsible for removing white spaces in start and end of an
     * object
     * 
     * @param object text to be formatted
     * @return returns null if the object is null or empty, otherwise it
     * returns a string without white spaces.
     */
    public static String trimOrNullOnEmpty(Object object){
        if(object == null) return null;
        
        String result = String.valueOf(object).trim();
        
        if(result.isEmpty()) return null;
        return result;
    }
    
    /**
     * Method responsible for removing any character in a string
     * 
     * @param text  text to be formatted
     * @return returns null if the string is null, otherwise it
     * returns a string without characters.
     */
    public static String onlyNumber(String text){
        text = trim(text);
        if(text.isEmpty()) return null;
        
        return text.replaceAll("[^0-9]", "");
    }
    
    /**
     * Method responsible for removing any tag html in a string
     * 
     * @param text  text to be formatted
     * @return returns null if the string is null, otherwise it
     * returns a string without tags.
     */
    public static String removeTagsHtml(String text){
        text = trim(text);
        if(text.isEmpty()) return null;
        
        return text.replaceAll("<[^>]*>", "");
    }
}
