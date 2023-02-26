package misc;

public class SubstringDemo {
    public static String replaceParenthesis(String str){
        // remove parentheses from the string and replace ")" with "-"
        String result = str.replaceAll("\\(", "").
                replaceAll("\\)", "-").
                replaceAll("\\s+", "");
        return result;
    }
    public static void main(String[] args) {

        System.out.println(replaceParenthesis("123-456-3920"));
        System.out.println(replaceParenthesis("123.456.3920"));
        System.out.println(replaceParenthesis("(123) 456-3920"));

        // if there is no matching then replaceAll gives error or
        // simply returns the string
        String str = "This is a string";
        String replacedString1 = str.replaceAll("This", "It");
        System.out.println(replacedString1);
        String replacedString2 = str.replaceAll("That", "It"); // returns the same string
        System.out.println(replacedString2);

    }
}
