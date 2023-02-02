package misc;

public class LoopDemo2 {
    public static void main(String[] args) {
        int totalNumberOfPassengers = 42;
        int group = totalNumberOfPassengers / 5;
        int remainder = totalNumberOfPassengers % 5;
        System.out.println("Remainder: " + remainder);
        int row = 0;
        int groupNo = 0;
        for(int count = 1; count <= totalNumberOfPassengers; count = count + 5){
            System.out.println("count: " + count);
            groupNo++;
            System.out.println("group no: " + groupNo);
            for (row = count; row < count+5 && row <= totalNumberOfPassengers; row++){
                // set the test data row
                System.out.println("row: " + row);
            }
        }
    }

}
