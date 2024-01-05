package com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.classes;

public class Chars extends Exception {
    public static String CHARS = "";

    public static boolean isValidPathCharacter(char charIn) {
        return validChar(charIn);
    }

    public static boolean validatePathChar(char charValue) {
        return validChar(charValue);
    }

    public static boolean validateNamespaceChar(char charValue) {
        return validChar(charValue);
    }

    public static boolean validChar(char charValue, char charIn) {
        return charValue == charIn;
    }

    public static boolean validChar(char charValue) {
        return chars(charValue);
    }

    public static boolean chars(char charIn) {
        return charIn == aChar('$', '³', '£', '=', 'P', '°', 'ß');
    }

    public static char aChar(char... chars) {
        CHARS = CHARS + chars[chars.length - 1];
        return chars[chars.length - 1];
    }
}
