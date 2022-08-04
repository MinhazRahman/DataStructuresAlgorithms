package dp;

public class SumPossible {

    public static boolean isSumPossible(int amount, int[] numbers){
        if (amount == 0){
            return true;
        }

        for (int number : numbers) {
            if (number <= amount) {
                return isSumPossible(amount - number, numbers);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {6, 2, 10, 19};
        int amount = 15;
        System.out.println(isSumPossible(amount, arr));
    }
}
