/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.util;

import com.google.common.base.Strings;
import java.text.Normalizer;

/**
 *
 * @author Matheus
 */
public class StringUtil {

    /**
     * Method responsible for removing white spaces in start and end of an
     * string
     *
     * @param text text to be formatted
     * @return returns an empty string if the string is null, otherwise it
     * returns a string without white spaces.
     */
    public static String trim(String text) {
        if (text == null) {
            return "";
        }

        return String.valueOf(text).trim();
    }

    /**
     * Method responsible for removing white spaces in start and end of an
     * object
     *
     * @param text text to be formatted
     * @return returns null if the string is null or empty, otherwise it returns
     * a string without white spaces.
     */
    public static String trimOrNullOnEmpty(String text) {
        if (text == null) {
            return null;
        }

        String result = String.valueOf(text).trim();

        if (result.isEmpty()) {
            return null;
        }
        return result;
    }

    /**
     * Method responsible for removing any character in a string
     *
     * @param text text to be formatted
     * @return returns null if the string is null, otherwise it returns a string
     * without characters.
     */
    public static String onlyNumber(String text) {
        text = trim(text);
        if (text.isEmpty()) {
            return null;
        }

        return text.replaceAll("[^0-9]", "");
    }

    /**
     * Method responsible for removing any tag html in a string
     *
     * @param text text to be formatted
     * @return returns null if the string is null, otherwise it returns a string
     * without tags.
     */
    public static String removeTagsHtml(String text) {
        text = trim(text);
        if (text.isEmpty()) {
            return null;
        }

        return text.replaceAll("<[^>]*>", "");
    }

    /**
     * Method responsible for returning the next index of a substring
     *
     * @param body text where it will be searched
     * @param subString substring that will be the reference of the next index
     * of
     * @return returns -1 if the string or substring is null, otherwise it will
     * return the next substring index
     */
    public static int nextIndexOf(String body, String subString) {
        return nextIndexOf(body, subString, 0);
    }

    /**
     * Method responsible for returning the next index of a substring
     *
     * @param body text where it will be searched
     * @param subString substring that will be the reference of the next index
     * of
     * @param initialIndex initial index where it will be searched
     * @return returns -1 if the string or substring is null, otherwise it will
     * return the next substring index
     */
    public static int nextIndexOf(String body, String subString, int initialIndex) {
        if (Strings.isNullOrEmpty(body) || Strings.isNullOrEmpty(subString)) {
            return -1;
        } else if (body.indexOf(subString, initialIndex) == -1) {
            return -1;
        }
        return body.indexOf(subString, initialIndex) + subString.length();
    }

    public static String removeLeadingZeros(String text) {
        text = text.replaceAll("^[0]+", "");
        if (text.equals("")) {
            return "0";
        }
        return text;
    }

    public static String onlyLetters(String text) {
        return Normalizer
                .normalize(text, Normalizer.Form.NFD)
                .replaceAll("[^\\p{ASCII}]", "");
    }

    public static String substringPowerful(String body, String initialStr, String finalStr) {
        return substringPowerful(body, initialStr, null, finalStr, null, 0);
    }

    public static String substringPowerful(String body, String initialStr, String finalStr, int initialIndex) {
        return substringPowerful(body, initialStr, null, finalStr, null, initialIndex);
    }

    public static String substringPowerful(String body, String initialStr, String intermedStr, String finalStr) {
        return substringPowerful(body, initialStr, intermedStr, finalStr, null, 0);
    }

    public static String substringPowerful(String body, String initialStr, String intermedStr, String finalStr, int initialIndex) {
        return substringPowerful(body, initialStr, intermedStr, finalStr, null, initialIndex);
    }

    public static String substringPowerful(String body, String initialStr, String intermedStr, String finalStr, String maxStr, int initialIndex) {
        String result;
        int maxIndex = -1;

        if (Strings.isNullOrEmpty(body) || initialStr == null || finalStr == null) {
            return null;
        }

        if (!Strings.isNullOrEmpty(maxStr)) {
            maxIndex = body.indexOf(maxIndex, initialIndex);
            if (maxIndex < 0) {
                return null;
            }
        }

        if (maxIndex < 0) {
            maxIndex = body.length();
        }

        result = body.substring(initialIndex, maxIndex);

        int startIndex = nextIndexOf(result, initialStr);
        if (startIndex == -1) {
            return null;
        }
        result = result.substring(startIndex);

        if (intermedStr != null) {
            int index = nextIndexOf(result, intermedStr);
            if (index == -1) {
                return null;
            }
            result = result.substring(index);
        }

        int endIndex = result.indexOf(finalStr);
        if (endIndex < 0) {
            return null;
        }

        return result.substring(0, endIndex);
    }

}
