package recursion;

// Calculate the factorial of an integer n,
// n! = n*(n-1)*(n-2)...3*2*1 and the factorial of zero is 1, 0! = 1
// 5! = 5*4*3*2*1

// Recursively we can write the factorial function as follows:
// fact(n) = 1 , if n = 0.
// fact(n) = n*fact(n-1), otherwise

public class Factorial {

    // precondition: The input n is an integer and n>=0.
    // post-condition: The program return the factorial of n, that is n!.
    public static int fact(int n){
        // base case
        if (n == 0){
            return 1;
        }
        // recursive step
        return n*fact(n-1);
    }
    public static void main(String[] args) {
        System.out.println(fact(0));
        System.out.println(fact(1));
        System.out.println(fact(4));
        System.out.println(fact(5));
    }
}

// Here we are inducting on the input n.
// basis:
// induction hypothesis: If the precondition is satisfied then the recursive call works.
// induction step:

