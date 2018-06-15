import java.util.ArrayList;
import java.util.Arrays;

public class BasicJava{
  public void printArrVals(int[] array){
    for(int i = 0; i < array.length; i++){
      System.out.println(array[i]);
    }
  }
  public void printOddVals(int[] array){
    for(int i = 0; i < array.length; i++){
      if(array[i] % 2 != 0){
        System.out.println(array[i]);
      }
    }
  }
  public void printSum(int int1, int int2){
    int sum = 0;
    while(int1 < int2 + 1){
      sum += int1;
      System.out.println("New number: " + int1 + " " + "Sum: " + sum);
      int1++;
    }
  }
  public void iterateArray(int[] array){
    for(int i = 0; i < array.length; i++){
      System.out.println(array[i]);
    }
  }
  public void findMax(int[] array){
    int maxVal = array[0];
    for(int i = 0; i < array.length; i++){
      if(array[i] > maxVal){
        maxVal = array[i];
      }
    }
    System.out.println(maxVal);
  }
  public void getAvg(int[] array){
    int avg = 0;
    int sum = 0;
    for(int i = 0; i < array.length; i++){
      sum += array[i];
    }
    avg = sum / array.length;
    System.out.println(avg);
  }
  public ArrayList oddArray(){
    ArrayList<Integer> y = new ArrayList<Integer>();
    for(int i = 1; i < 256; i++){
      if(i % 2 != 0){
        y.add(i);
      }
    }
    return y;
  }
  public void greaterY(int[] array, int y){
    int count = 0;
    for(int i = 0; i < array.length; i++){
      if(array[i] > y){
        count += 1;
      }
    }
    System.out.println(count);
  }
  public void squareVal(int[] arr){
    int temp = 0;
    for(int i = 0; i < arr.length; i++){
      temp = arr[i] * arr[i];
      arr[i] = temp;
    }
    System.out.println(Arrays.toString(arr));
  }
  public void elimNegs(int[] array){
    for(int i = 0; i < array.length; i++){
      if(array[i] < 0){
        array[i] = 0;
      }
    }
    System.out.println(Arrays.toString(array));
  }
  public void maxMinAvg(int[] array){
    int min = array[0];
    int max = array[0];
    int avg = 0;
    int sum = 0;
    for(int i = 0; i < array.length; i++){
      if(array[i] < min){
        min = array[i];
      }
      if(array[i] > max){
        max = array[i];
      }
      sum += array[i];
    }
    avg = sum / array.length;
    int[] newArr = {min, max, avg};
    System.out.println(Arrays.toString(newArr));
  }
  public void shiftVals(int[] array){      
    for(int i = 0; i < array.length - 1; i++){
      array[i] = array[i + 1];
    }
    array[array.length-1] = 0;  
    System.out.println(Arrays.toString(array));
  }
}