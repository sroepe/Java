import java.util.stream.IntStream;
import java.util.ArrayDeque;
import java.util.Arrays;

public class PuzzleJavaTest{
  public static void main(String[] args){
    PuzzleJava iD = new PuzzleJava();

    //Print Sum of numbers in array and return array with only values greater than 10
    // int[] arr1 = {3,5,1,2,7,9,8,13,25,32};
    // iD.printSum(arr1);

    //Shuffle array and print the name of each person; return array with names longer than 5 characters
    // String[] arr2 = {"Nancy", "Jinichi", "Fujibayashi", "Momochi", "Ishikawa"};
    // iD.printNames(arr2);

    //Shuffle array of all 26 alphabet characters, print last letter and first letter of shuffled array.  If first letter is a vowel, have it display a message.
    // Character[] arr3 = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    // iD.alphaShuffle(arr3);

    //Generate and return array with 10 random numbers b/w 55 and 100
    // int min = 55;
    // int max = 100;
    // iD.randArrayList(min, max);

    //Generate and return array with 10 random numbers, sort it and display all the sorted; print min and max values
    // iD.randArrayListSort(min, max);

    //Create random String 5 characters long
    // iD.randString();

    //Generate an array with 10 random strings of 5 chars each
    iD.randStringArray();
  }
}