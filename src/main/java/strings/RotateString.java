package strings;

public class RotateString {
    public static void rotateString(String str){
        for (int i=0; i<str.length(); i++){
            for (int j=i+1; j<=str.length(); j++){
                String sub = str.substring(j) + str.substring(0, j);
                System.out.println(sub);
            }
        }
    }

    public static void rotate(String str){
        int n = str.length();

        for (int i=0; i<n; i++){
            String sub = str.substring(i+1, n) + str.substring(0, i+1);
                System.out.println(sub);
        }
    }
    public static void main(String[] args) {
        String str = "abcde";
        System.out.println(str);
        rotate(str);
    }
}
