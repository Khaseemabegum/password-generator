package org.example;

import java.util.Scanner;

public class PasswordGenerator {

    public static Scanner sc = new Scanner(System.in);
    public static  String input;;
    public static void mainMethod() {

        String choice;

        boolean choiceMade = false;


        do{
            printChoices();
            System.out.print("Choice :");
            choice = sc.next();

            switch (choice)
            {
                case "1":
                    System.out.println("Welcome to password generator please give YES/NO for question");
                    passwordGenerator();
                    choiceMade =true;
                    break;

                case "2" :
                    System.out.println("checking the strength of password");
                    choiceMade =true;
                    break;

                case "3" :
                    System.out.println("Password generation key points");
                    choiceMade =true;
                    break;

                case "4" :
                    System.out.println("Thanks for visiting our website");
                    choiceMade=false;
                    break;
            }

        }while(choiceMade);
    }

    public static void printChoices()
    {
        System.out.println("Enter 1 to create password");
        System.out.println("Enter 2 to check the strength of password");
        System.out.println("Enter 3 to get password creating information");
        System.out.println("Enter 4 to exit");
    }

    public static void inputError(String input)
    {
        if(!input.equalsIgnoreCase("YES") && !input.equalsIgnoreCase("NO"))
        System.out.println("given input is wrong, please enter YES or NO");
    }

    public static boolean isInclude(String input)
    {
        if(input.equalsIgnoreCase("YES"))
            return true;
        else
            return false;
    }

    public static void passwordGenerator()
    {
        boolean includeUpper =false,includeLower=false,includeNumber = false,includeSymbol = false;
        boolean repeat = false;
        do{

            do {
                System.out.println("Do you want use upper case alphabets in password");
                input = sc.next();
                inputError(input);
            } while (!input.equalsIgnoreCase("YES") && !input.equalsIgnoreCase("NO"));

            if(isInclude(input)) includeUpper =true;

            do {
                System.out.println("Do you want use LOWER case alphabets in password");
                input = sc.next();
                inputError(input);
            } while (!input.equalsIgnoreCase("YES") && !input.equalsIgnoreCase("NO"));

            if(isInclude(input)) includeLower =true;

            do {
                System.out.println("Do you want use numbers in password");
                input = sc.next();
                inputError(input);
            } while (!input.equalsIgnoreCase("YES") && !input.equalsIgnoreCase("NO"));

            if(isInclude(input)) includeNumber =true;

            do {
                System.out.println("Do you want use symbols in password");
                input = sc.next();
                inputError(input);
            } while (!input.equalsIgnoreCase("YES") && !input.equalsIgnoreCase("NO"));

            if(isInclude(input)) includeSymbol =true;

            if(!includeLower && !includeUpper && !includeNumber && !includeSymbol)
            {
                System.out.println("Choose any of the option to create password");
                repeat =true;
            }
        }while(repeat);

        System.out.println("Please enter the length of password which should be >= 8");
        int length = sc.nextInt();
        System.out.println("The generated password : "+createPassword(length,includeUpper,includeLower,includeNumber,includeSymbol));

    }

    public static String createPassword(int length,boolean includeUpper,boolean includeLower, boolean includeNumber,boolean includeSymbol)
    {
     String characters= Characters.createPasswordCharacters(includeUpper,includeLower,includeNumber,includeSymbol);

     String password ="";
       for(int i=0;i<=length-1;i++)
       {
           int index = (int)(Math.random()*characters.length());
           password = password +characters.charAt(index);
       }
       return password;
    }

}
