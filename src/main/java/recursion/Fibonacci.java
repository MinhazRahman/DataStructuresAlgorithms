package recursion;

// Fibonacci series: 0 1 1 2 3 5 8 13 21 34 55....
// fib(n) = 0, if n=0
// fib(n) = 1, if n=1
// fib(n) = fib(n-1) + fib(n-2), if n>1

public class Fibonacci {
    public static int fib(int n){
        // base case
        if (n == 0 || n == 1){
            return n;
        }
        // recursive step
        return fib(n-1) + fib(n-2);
    }

    public static int fibonacci(int n){
        int a = 0, b = 1, c = 0;
        if (n == 0 || n == 1){
            return n;
        }

        for (int i = 2; i <= n; i++){
            c = a + b;
            a = b;
            b = c;
        }

        return c;
    }

    public static int fibIterative(int n){
        // The array fib[0...n] holds the values of the previously completed computations
        int[] fib = new int[n+1];
        fib[0] = 0;
        fib[1] = 1;

        if (n == 0 || n == 1){
            return n;
        }

        for (int i = 2; i<=n; i++){
            fib[i] = fib[i-1] + fib[i-2];
        }
        return fib[n];
    }
    public static void main(String[] args) {
        System.out.println("Recursive fibonacci:");
        System.out.println(fib(0));
        System.out.println(fib(1));
        System.out.println(fib(2));
        System.out.println(fib(3));
        System.out.println(fib(4));
        System.out.println(fib(5));
        System.out.println(fib(6));

        System.out.println("Iterative fibonacci:");
        System.out.println(fibonacci(6));
        System.out.println(fibIterative(6));
    }
}
