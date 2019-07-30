package it.gangemi.codingchallenge.reverse;


import java.util.function.UnaryOperator;

public class ReverseString {

    private static int countRecursive = 0;

    public static void main(String[] args) {
        String text = "Hello World!!";
        System.out.println(new StringBuilder(text).reverse());
        System.out.println(reverseFunctional(text, x -> new StringBuilder(x).reverse().toString()));
        System.out.println(reverseManuallyRecursive(text));
    }

    private static String reverseFunctional(String text, UnaryOperator<String> fun) {
        return fun.apply(text);
    }

    private static String reverseManuallyRecursive(String text) {
        return new String(reverseManuallyRecursive(text.toCharArray(), 0));
    }

    private static char[] reverseManuallyRecursive(char[] text, int i) {
        if (i < text.length) {
            char[] reverse = reverseManuallyRecursive(text, i + 1);
            reverse[countRecursive++] = text[i];
            return reverse;
        }
        return new char[text.length];
    }
}
