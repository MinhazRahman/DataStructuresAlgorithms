package recursion;

/**
 * a(n) = {1, 2, 3, 7, 22, 155, 3411...} for a(0) = 1, a(1) = 2
 * From the above sequence we can write the recursive function as follows:
 * a(n) = 1 for n = 0
 * a(n) = 2 for n = 1
 * a(n) = a(n-1)*a(n-2) + 1 for n>=2
 *
 * */
public class InfiniteSequence {

    static int cal(int n){
        if (n == 0) return 1;
        if (n == 1) return 2;

        return cal(n-1) * cal(n-2) + 1;
    }

    // memoization or dynamic programming techniques to store and reuse previously calculated values.
    static int dpCal(int n){
        // an array that holds the previous results
        int[] result = new int[n+1];

        result[0] = 1;
        if (n == 0) return result[n];

        result[1] = 2;
        if (n == 1) return result[n];

        for (int i=2; i <= n; i++){
            result[i] = result[i-1]*result[i-2] + 1;
        }
        return result[n];
    }

    // this algorithm doesn't produce the same output as the sequence above
    static int calculate(int n){
        if (n == 0) return 1;
        if (n == 1) return 2;

        return cal(n-1) * cal(n-2) + n^2;
    }

    // this algorithm doesn't produce the same output as the sequence above
    static int dpCalculate(int n) {
        int[] dp = new int[n + 1];  //Create a list to store previously calculated values
        if (n == 0) {
            return 1;
        }
        else if (n ==1) {
            return 2;
        }
        else {
            dp[0] = 1;
            dp[1] = 2;
        }

        for (int i=2; i<=n; i++) {
            dp[i] = dp[i - 1] * dp[i - 2] + i^2;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println("Recursion: ");
        System.out.println(cal(0));
        System.out.println(cal(1));
        System.out.println(cal(2));
        System.out.println(cal(3));
        System.out.println(cal(4));
        System.out.println(cal(5));
        System.out.println(cal(6));
        System.out.println(cal(7));

        System.out.println("Dynamic Programming: ");
        System.out.println(dpCal(0));
        System.out.println(dpCal(1));
        System.out.println(dpCal(2));
        System.out.println(dpCal(3));
        System.out.println(dpCal(4));
        System.out.println(dpCal(5));
        System.out.println(dpCal(6));
        System.out.println(dpCal(7));

        System.out.println("Recursion: ");
        System.out.println(calculate(0));
        System.out.println(calculate(1));
        System.out.println(calculate(2));
        System.out.println(calculate(3));
        System.out.println(calculate(4));
        System.out.println(calculate(5));
        System.out.println(calculate(6));
        System.out.println(calculate(7));

        System.out.println("Dynamic programming: ");
        System.out.println(dpCalculate(0));
        System.out.println(dpCalculate(1));
        System.out.println(dpCalculate(2));
        System.out.println(dpCalculate(3));
        System.out.println(dpCalculate(4));
        System.out.println(dpCalculate(5));
        System.out.println(dpCalculate(6));
        System.out.println(dpCalculate(7));

    }
}
