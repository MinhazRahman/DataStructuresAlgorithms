package strings;

import java.util.*;

public class SortCharactersByFrequency {

    public static String frequencySort(String s){
        // create a hash map
        final Map<Character, Integer> charFrequencyMap = new HashMap<Character, Integer>();

        int strLen = s.length();
        // create the character frequency map
        for (int i=0; i<strLen; i++){
            char ch = s.charAt(i);
            if (charFrequencyMap.containsKey(ch)){
                charFrequencyMap.put(ch, charFrequencyMap.get(ch) + 1);
            }else {
                charFrequencyMap.put(ch, 1);
            }
        }

        // copy the values into a list
        List<Character> characters = new ArrayList<Character>(charFrequencyMap.keySet());
        // sort the list
        Collections.sort(characters, (a, b) -> charFrequencyMap.get(b) - charFrequencyMap.get(a));

        // convert the map into a string using string builder
        StringBuilder stringBuilder = new StringBuilder();
        for (char c: characters){
            int val = charFrequencyMap.get(c);
            for (int i=0; i<val; i++){
                stringBuilder.append(c);
            }
        }

        return stringBuilder.toString();
    }
    public static void main(String[] args) {
        System.out.println(frequencySort("trffeee"));
    }
}
