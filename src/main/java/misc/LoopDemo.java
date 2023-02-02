package misc;

public class LoopDemo {
    public static void main(String[] args) {
        int totalNumberOfPassengers = 43;
        int group = totalNumberOfPassengers / 5;
        int r = totalNumberOfPassengers % 5;
        int row = 0;
        for(int count = 1; count <= totalNumberOfPassengers; count = count + 5){
            System.out.println("count: " + count);
            for (row = count; row< count+5 && row<totalNumberOfPassengers; row++){
                // set the test data row
                System.out.println("row: " + row);
            }
        }
    }

}
