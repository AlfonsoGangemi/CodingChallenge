package it.gangemi.codingchallenge.stack;

import java.util.stream.IntStream;

public class StackMain {

    public static void main(String[] args) {
        final ArrayStack<Integer> integerArrayStack = new ArrayStack<>(5, Integer.class);
        IntStream.rangeClosed(1, 6).forEach(x -> out_in(integerArrayStack, x));
    }

    private static void out_in(ArrayStack<Integer> integerArrayStack, int x) {
        out(integerArrayStack);
        in(integerArrayStack, x);
    }

    private static void in(ArrayStack<Integer> integerArrayStack, int x) {
        try {
            integerArrayStack.push(x);
            integerArrayStack.push(x * 7);
        } catch (FullStackException e) {
            System.err.println(e.getClass());
        }
    }

    private static void out(ArrayStack<Integer> integerArrayStack) {
        try {
            System.out.println(integerArrayStack.pull());
            System.out.println(integerArrayStack.peek());
        } catch (EmptyStackException e) {
            System.err.println(e.getClass());
        }
    }

}
