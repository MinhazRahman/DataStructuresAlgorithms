package recursion;
// Sum of n natural numbers using recursion
// Recursively we can write as follows:
// sum(n) = 0, if n = 0
// sum(n) = n + sum(n-1), if n > 0.

public class SumOfN{
    public static int sum(int n){
        //base case
        if (n == 0){
            return 0;
        }
        // recursive step
        return n + sum(n-1);
    }

    public static void main(String[] args) {
        System.out.println(sum(10));
        System.out.println(sum(5));
    }
}
