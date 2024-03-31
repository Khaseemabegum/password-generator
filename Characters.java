package org.example;

public class Characters {

    public static String upperCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
    public static String numbers = "1234567890";
    public static String symbols = "!@$#%^&*()?/><{}[]\\";


    public static String createPasswordCharacters(boolean includeUpper, boolean includeLower, boolean includeNumber, boolean includeSymbol) {

        StringBuilder characters = new StringBuilder();
        if(includeUpper)
            characters.append(upperCaseLetters);
        if(includeLower)
            characters.append(lowerCaseLetters);
        if(includeNumber)
            characters.append(numbers);
        if(includeSymbol)
            characters.append(symbols);

        return characters.toString();
    }
}
