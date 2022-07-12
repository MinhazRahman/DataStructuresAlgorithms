package strings;

public class ReplaceCharacter {
    public static void main(String[] args) {
        String str = "bella";
        char ch = 'l';

        System.out.println(str.contains(String.valueOf(ch)));

        System.out.println(str.replaceFirst(String.valueOf(ch), ""));
    }
}
