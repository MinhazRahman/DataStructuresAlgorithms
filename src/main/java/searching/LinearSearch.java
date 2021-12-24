package searching;

public class LinearSearch {

    // if value is in arr[0...n-1] then search() method returns the index
    // otherwise returns -1
    public static int search(int[] arr, int value){
        int index = -1;
        int n = arr.length;
        for (int i=0; i<n; i++){
            if (arr[i] == value){
                return value;
            }
        }

        return index;
    }
    public static void main(String[] args) {
        int[] input = {5, 2, 3, 1, 7};

        System.out.println(search(input, 2));
        System.out.println(search(input, 10));

    }
}

// precondition:
// post-condition:
// design idea:
// loop invariant:
// proof:

