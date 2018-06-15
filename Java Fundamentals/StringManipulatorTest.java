public class StringManipulatorTest{
  public static void main(String[] args){
    StringManipulator manipulator = new StringManipulator();
    //Method 1 - Trim and Concat
    String str3 = manipulator.trimAndConcat("  Hello  ","  World  ");
    System.out.println(str3);
    //Method 2 - Return the index of a particular letter or null if none
    char letter = 'o';
    Integer a = manipulator.getIndexOrNull("Coding", letter);
    Integer b = manipulator.getIndexOrNull("Hello World", letter);
    Integer c = manipulator.getIndexOrNull("Hi", letter);
    System.out.println(a); 
    System.out.println(b); 
    System.out.println(c); 
    //Method 3 - Return index of substring in a string
    Integer d = manipulator.getIndexOrNull("Hello", "llo");
    Integer e = manipulator.getIndexOrNull("Hello", "World");
    System.out.println(d);
    System.out.println(e);
    //Method 4 - Get substring using a starting and ending index, and concat with second string
    String word = manipulator.concatSubstring("Hello", 1, 2, "world");
    System.out.println(word);
  }
}