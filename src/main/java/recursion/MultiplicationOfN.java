package recursion;
// Multiply the first N natural numbers using recursion
// Recursively we can write as follows:
// mul(n) = 1 , if n = 1
// mul(n) = n * mul(n-1), if n > 1

// precondition: input n is a positive integer, where n>=1.

public class MultiplicationOfN {
    public static long mul(int n){
        //base case
        if (n == 1){
            return 1;
        }
        //recursive step
        return n * mul(n-1);
    }
    public static void main(String[] args) {
        System.out.println(mul(5));
        System.out.println(mul(10));
    }
}

// What are we inducting on? We are inducting on the input n.
// basis: When n equals to 1 then the program returns 1. Which is true.

// induction hypothesis: If the precondition holds then the program works
// i) n is an integer and n>1
// ii) the program reaches the recursive step
//  n * mul(n-1) and in the recursive call the value of the input in an integer and is less than n
// So, the recursive call works on smaller input.

