package dp;

public class SumPossible {

    public static boolean isSumPossible(int amount, int[] numbers){
        if (amount < 0){
            return  false;
        }
        if (amount == 0){
            return true;
        }

        for (int number : numbers) {
            if (isSumPossible(amount - number, numbers)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        int amount = 5;
        System.out.println(isSumPossible(amount, arr));

        arr = new int[]{6, 2, 10, 19};
        amount = 15;
        System.out.println(isSumPossible(amount, arr));
    }
}
