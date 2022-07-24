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
    public static void main(String[] args) {
        String str = "abcde";
        rotateString(str);
    }
}
