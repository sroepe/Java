import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class PuzzleJava{
  public ArrayList printSum(int[] array){
    ArrayList<Integer> newArr = new ArrayList<Integer>();
    int sum = 0;
    for(int i = 0; i < array.length; i++){
      if(array[i] > 10){
        newArr.add(array[i]);
      }
      sum += array[i];
    }
    System.out.println(sum);
    System.out.println(newArr);
    return newArr;
  }

  public ArrayList printNames(String[] array){
    ArrayList<String> newArr = new ArrayList<String>();
    Collections.shuffle(Arrays.asList(array));
    for(int i = 0; i < array.length; i++){
      System.out.println(array[i]);
      if(array[i].length() > 5){
        newArr.add(array[i]);
      }
    }
    System.out.println(newArr);
    return newArr;
  }

  public ArrayList alphaShuffle(Character[] array){
    ArrayList<Character> newArr = new ArrayList<Character>();
    Collections.shuffle(Arrays.asList(array));
    for(int i = 0; i < array.length; i++){
      newArr.add(array[i]);
    }
    char first = newArr.get(0);
    char last = newArr.get(25);
    System.out.println(first);
    System.out.println(last);
    char[] vowels = {'a','e','i','o','u'};
    for(int j = 0; j < vowels.length; j++){
      if(vowels[j] == first){
        System.out.println("The first letter of the array is a VOWEL!!!!");
      }
    }
    return newArr;
  }

  public ArrayList randArrayList(int min, int max){
    ArrayList<Integer> newArr = new ArrayList<Integer>();
    Random rand = new Random();
    int n;
    for(int i = 0; i <= 9; i++){
      n = rand.nextInt((max - min)  + 1) + min;
      newArr.add(n);
    }
    System.out.println(newArr);
    return newArr;
  }

  public ArrayList randArrayListSort(int min, int max){
    ArrayList<Integer> newArr = new ArrayList<Integer>();
    Random rand = new Random();
    int n;
    for(int i = 0; i <= 9; i++){
      n = rand.nextInt((max - min)  + 1) + min;
      newArr.add(n);
    }
    Collections.sort(newArr);
    System.out.println(newArr);
    int first = newArr.get(0);
    int last = newArr.get(9);
    System.out.println(first);
    System.out.println(last);
    return newArr;
  }

  public String randString(){
    Random rand = new Random();
    String newStr = "";
    char c;
    for(int i = 0; i <= 4; i++){
       c = (char) (rand.nextInt(26) + 'a');
       newStr += c;
    }
    System.out.println(newStr);     
    return newStr;
  }

  public void randStringArray(){
    ArrayList<String> newArr = new ArrayList<String>();
    Random rand = new Random();
    char c;
    String newStr = "";
    for(int i = 0; i < 10; i++){
      newStr = "";
      for(int j = 1; j <= 5; j++){
        c = (char) (rand.nextInt(26) + 'a');
        newStr += c;
      }
      newArr.add(newStr);
    }
    System.out.println(newArr);     
  }
}