package recursion;
/**
 * Xn = n^2
 * Xn = {0, 1, 4, 9, 16, 25...} where n = 0, 1, 2, 3, 4, 5...
 *
 * */
public class SquareSeries {
    static int cal(int n){
        if (n == 0){
            return 0;
        }
        return n*n + cal(n-1);
    }

    static int a(int n){
        if (n == 0){
            return 0;
        }
        return a(n-1) + (2*n -1);
    }

    static int dpa(int n){
        int[] result = new int[n+1];
        result[0] = 0;

        for (int i=1; i<=n; i++){
            result[i] = result[i-1] + (2*i -1);
        }

        return result[n];
    }

    int Calc(int n){
        int[] result = new int[n+1];
        result[0] = 0;

        for (int i=1; i<=n; i++){
            result[i] = result[i-1] + (2*i -1);
        }

        return result[n];
    }

    public static void main(String[] args) {
        System.out.println(cal(2));
        System.out.println(cal(3));
        System.out.println(cal(4));

        System.out.println();
        System.out.println(a(2));
        System.out.println(a(3));
        System.out.println(a(4));

        System.out.println();
        System.out.println(dpa(2));
        System.out.println(dpa(3));
        System.out.println(dpa(4));
    }
}
