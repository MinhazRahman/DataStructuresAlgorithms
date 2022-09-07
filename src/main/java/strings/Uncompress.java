package strings;

import java.util.Arrays;

/**
 * Write a function, uncompress, that takes in a string as an argument.
 * The input string will be formatted into multiple groups according to the following pattern:
 *
 * <number><char>
 * for example, '2c' or '3a'.
 *
 * The function should return an uncompressed version of the string
 * where each 'char' of a group is repeated 'number' times consecutively.
 * You may assume that the input string is well-formed according to the previously mentioned pattern.
 *
 * uncompress("2c3a1t"); // -> 'ccaaat'
 * uncompress("4s2b"); // -> 'ssssbb'
 * uncompress("2p1o5p"); // -> 'ppoppppp'
 * uncompress("3n12e2z"); // -> 'nnneeeeeeeeeeeezz'
 * uncompress("127y"); // ->'yyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy'
 *
 * Understand:
 * - input always be of the format <number><char>
 * - input can have same <char>: "2p1o5p"
 * - input can be null
 * Match:
 * - string problem
 * - we can't use hash table here because of the possibility of duplicate characters in the input string
 * - regular expression
 * Plan:
 * -
 *
 * Regular expression:
 * ^ match the start of the string
 * [] consider characters as a group
 * \d any decimal digit
 * \s any white space character
 * + match preceding character/group one or more times
 * */

public class Uncompress {
    public static String uncompress(String input){
        String[] numbers = input.split("[a-z|A-Z]");
        String[] chars = input.split("[\\d]+"); // array

        System.out.println(Arrays.toString(numbers));
        System.out.println(Arrays.toString(chars));

        StringBuilder sb = new StringBuilder();
        // iterate over numbers
        int i = 1; // since chars[0] will be null, so we start from chars[1]
        for (String num: numbers){
            int n = Integer.parseInt(num);
            for (int j = 0; j <n; j++){
                sb.append(chars[i]);
            }
            i++;
        }
        return sb.toString();
    }

    public static String uncompressString(String input){
        String[] numbers = input.split("[a-z|A-Z]");
        String chars = input.replaceAll("[\\d]+", ""); // output string

        System.out.println(Arrays.toString(numbers));
        System.out.println(chars);

        StringBuilder sb = new StringBuilder();
        // iterate over numbers
        int i = 0; // since chars[0] will be null, so we start from chars[1]
        for (String num: numbers){
            int n = Integer.parseInt(num);
            for (int j = 0; j <n; j++){
                sb.append(chars.charAt(i));
            }
            i++;
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        System.out.println(uncompress("2p1o5p"));
        System.out.println(uncompress("3n12e2z"));

        System.out.println(uncompressString("2p1o5p"));
        System.out.println(uncompressString("3n12e2z"));
    }
}
