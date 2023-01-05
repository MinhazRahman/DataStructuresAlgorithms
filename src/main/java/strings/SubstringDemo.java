package strings;

public class SubstringDemo {
    public static void main(String[] args) {
        String str = "Your Confirmation Number is: EAPIS-333668";
        int i = str.indexOf(":");
        String eapisNumber = str.substring(i+1).trim();
        System.out.println(eapisNumber);
    }
}
