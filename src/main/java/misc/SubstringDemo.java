package misc;

public class SubstringDemo {
    public static void main(String[] args) {
        String str = "(123) 456-3920";
        // remove parentheses from the string and replace ")" with "-"
        String result = str.replaceAll("\\(", "").
                            replaceAll("\\)", "-").
                            replaceAll("\\s+", "");

        System.out.println(result);
    }
}
