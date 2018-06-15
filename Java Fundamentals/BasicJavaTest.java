import java.util.stream.IntStream;
import java.util.Arrays;

public class BasicJavaTest{
  public static void main(String[] args) {
    BasicJava iD = new BasicJava();
    // //Print 1 to 255
    int[] myArray = IntStream.rangeClosed(1, 255).toArray();
    iD.printArrVals(myArray);

    // //Print Odd 1 to 255
    iD.printOddVals(myArray);

    //Print 0 to 255 and Sum as goes
    iD.printSum(0, 255);

    //Iterate through Array and print each member
    int[] arr1 = {1,3,5,7,9,13};
    iD.iterateArray(arr1);

    //Find Max
    int[] arr2 = {2, 8, 65, 22, 87, 15};
    int[] arr3 = {1, -1, -15, 90, 2, 17, 0};
    int[] arr4 = {-30, -10, -3, -4, 0};
    iD.findMax(arr2);
    iD.findMax(arr3);
    iD.findMax(arr4);

    //Get Average
    int[] arr5 = {1, 2, 3};
    iD.getAvg(arr2);
    iD.getAvg(arr3);
    iD.getAvg(arr4);
    iD.getAvg(arr5);

    //Array with Odd Numbers
    System.out.println(iD.oddArray());

    //Greater Than Y
    int[] arr6 = {1, 3, 5, 7};
    int[] arr7 = {-3, -2, 0, 2, 4};
    int y1 = 2;
    int y2 = -1;
    iD.greaterY(arr6, y1);
    iD.greaterY(arr7, y2);

    //Square Values of Array
    int[] arr8 = {1, 5, 10, -2};
    iD.squareVal(arr8);

    //Eliminate Negatives
    int[] arr9 = {-1, -10, -2, -8};
    iD.elimNegs(arr8);
    iD.elimNegs(arr9);

    //Max, Min, Avg
    int[] arr10 = {1, 0, 5, 10};
    iD.maxMinAvg(arr8);
    iD.maxMinAvg(arr9);
    iD.maxMinAvg(arr10);

    //Shifting Values to front by 1
    iD.shiftVals(arr2);
    iD.shiftVals(arr7);
  }
}