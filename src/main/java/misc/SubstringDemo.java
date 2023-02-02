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
    }
}
