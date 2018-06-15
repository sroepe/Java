import java.util.ArrayList;

public class ExceptionGeneric<N>{
  public static void main(String[] args){
    
  }
  public void castToInt(){
    ArrayList<String> myList = new ArrayList<String>();
    myList.add("13");
    myList.add("hello world");
    myList.add(48);
    myList.add("Goodbye World");

    for(int i = 0; i < myList.size(); i++){
      Object o = myList.get(0);   // no cast
      // try{
      //   Integer castedValue = (Integer) myList.get(i);
      //   myList.set(i, castedValue);
      //   System.out.println(myList.get(i));
      // } catch (ClassCastException e) {
      //     System.out.println("ERROR ON INDEX{" + i + "}");
      // }
    }
    
  }
}