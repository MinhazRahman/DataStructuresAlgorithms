package strings;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Write a function, mostFrequentChar, that takes in a string as an argument.
 * The function should return the most frequent character of the string.
 * If there are ties, return the character that appears earlier in the string.
 *
 * You can assume that the input string is non-empty.
 *
 * mostFrequentChar('bookeeper'); // -> 'e'
 * mostFrequentChar('david'); // -> 'd'
 * mostFrequentChar('abby'); // -> 'b'
 * mostFrequentChar('mississippi'); // -> 'i'
 * mostFrequentChar('potato'); // -> 'o'
 * mostFrequentChar('eleventennine'); // -> 'e'
 * mostFrequentChar("riverbed"); // -> 'r'
 * */

public class MostFrequentCharacter {

    public static char mostFrequentChar(String string){
        Map<Character, Integer> count = new HashMap<>();
        // count the frequency of each char in string
        for (char ch: string.toCharArray()){
            if (count.containsKey(ch)){
                count.put(ch, count.get(ch) + 1);
            }else {
                count.put(ch, 1);
            }
        }

        int max = Collections.max(count.values());
        for (char ch: string.toCharArray()){
            if (count.get(ch) == max){
                return ch;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        System.out.println(mostFrequentChar("potato"));
        System.out.println(mostFrequentChar("mississippi"));
    }
}
