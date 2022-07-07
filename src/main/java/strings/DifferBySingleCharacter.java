package strings;

public class DifferBySingleCharacter {



    public static boolean isDifferBySingleCharacter(String word1, String word2){
        if (word1.length() != word2.length()){
            return false;
        }

        int diffs = 0;

        for (int i=0; i<word1.length(); i++){
            char ch = word1.charAt(i);
            if (word2.indexOf(ch) == -1){ // if ch is not in word2 then it returns -1
                diffs++;
            }
        }

        return diffs == 1;
    }

    public static void main(String[] args) {
        System.out.println(isDifferBySingleCharacter("hit", "hot"));
        System.out.println(isDifferBySingleCharacter("hot", "dot"));
        System.out.println(isDifferBySingleCharacter("hit", "dot"));
    }
}
