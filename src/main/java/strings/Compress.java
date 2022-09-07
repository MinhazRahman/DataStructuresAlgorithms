package strings;
/**
 * Write a function, compress, that takes in a string as an argument.
 * The function should return a compressed version of the string
 * where consecutive occurrences of the same characters are compressed into
 * the number of occurrences followed by the character.
 * Single character occurrences should not be changed.
 *
 * 'aaa' compresses to '3a'
 * 'cc' compresses to '2c'
 * 't' should remain as 't'
 *
 * compress('ccaaatbbb'); // -> '2c3at3b'
 * compress('ssssbbz'); // -> '4s2bz'
 * compress('ppoppppp'); // -> '2po5p'
 * compress('nnneeeeeeeeeeeezz'); // -> '3n12e2z'
 *
 * */
public class Compress {

    public static String compress(String input){
        StringBuilder sb = new StringBuilder();

        int i = 0;
        for (int j = 0; j < input.length(); j++){
            if (input.charAt(i) != input.charAt(j)){
                if (j - i > 1){sb.append(j - i);}
                sb.append(input.charAt(i));
                i = j;
            }
            if (j == input.length() - 1 && input.charAt(i) == input.charAt(j)){
                if (j + 1 - i > 1){ sb.append(j + 1 - i);}
                sb.append(input.charAt(i));
            }
        }
       return sb.toString();
    }
    public static void main(String[] args) {
        System.out.println(compress("ccaaatbbb"));
        System.out.println(compress("ssssbbz"));
        System.out.println(compress("ppoppppp"));
        System.out.println(compress("nnneeeeeeeeeeeezz"));
    }
}
