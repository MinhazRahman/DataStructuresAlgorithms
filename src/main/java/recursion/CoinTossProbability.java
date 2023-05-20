package recursion;

public class CoinTossProbability {
    public static double calculateB(int n, double p) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 1 - p;
        }

        return (1 - p) * calculateB(n - 1, p) + p * (1 - calculateB(n - 1, p));

    }

    public static double dpCalculateB(int n, double p) {
        // an array that holds the previously calculated results
        double[] result = new double[n + 1];
        // initial values
        result[0] = 1;
        result[1] = 1 - p;
        // iterate to calculate the other values
        for (int i = 2; i <= n; i++) {
            result[i] = (1 - p) * result[i - 1] + p * (1 - result[i - 1]);
        }
        return result[n];
    }

    public static void main(String[] args) {
        int n = 10; // Number of coin tosses
        double p = 0.5; // Probability of getting heads

        System.out.println("Probability of observing an even number of heads: " + calculateB(n, p));
        System.out.println("Probability of observing an even number of heads: " + dpCalculateB(n,p));

    }
}
