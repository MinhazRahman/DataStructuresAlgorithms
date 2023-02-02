package date.time;

public class SubstringDemo {
    public static void main(String[] args) {
        String str = "P - PASSPORT";
        System.out.println(str.substring(1));
        System.out.println(str.substring(2));
        System.out.println(str.substring(3));

        String subStr = str.substring(3).trim();
        System.out.println(subStr);
        String first = subStr.substring(0,1);
        System.out.println(first);
        String capDocType = subStr.charAt(0) + subStr.substring(1).toLowerCase();
        System.out.println(capDocType);

        String myStr = "VA";
        System.out.println(myStr.substring(0, 2));
    }
}
