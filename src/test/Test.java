package test;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        String[] strings = {"10", "2"};
        Arrays.sort(strings);

        for (String number : strings) {
            System.out.println(number);
        }
    }
}
