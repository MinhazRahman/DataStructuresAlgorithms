package recursion;

// Fibonacci series: 1 1 2 3 5 8 13 21 34 55....
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
    public static void main(String[] args) {
        System.out.println(fib(0));
        System.out.println(fib(1));
        System.out.println(fib(2));
        System.out.println(fib(3));
        System.out.println(fib(4));
        System.out.println(fib(5));
        System.out.println(fib(6));
    }
}
