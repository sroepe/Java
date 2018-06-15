public class StringManipulator{
  public String trimAndConcat(String str1, String str2){
    String trim1 = str1.trim();
    String trim2 = str2.trim();
    return trim1.concat(trim2);
  }
  public Integer getIndexOrNull(String str1, char letter){
    
    if(str1.indexOf(letter) == -1){
      return null;
    }
    else{
      return str1.indexOf(letter);
    }
  }
  public Integer getIndexOrNull(String str1, String sub1){
    if(str1.indexOf(sub1) == -1){
      return null;
    }
    else{
      return str1.indexOf(sub1);
    }
  }
  public String concatSubstring(String str1, int num1, int num2, String str2){
    String sub1 = str1.substring(num1, num2);
    return sub1.concat(str2);
    // StringManipulator manipulator = new StringManipulator();
    // String word = manipulator.concatSubstring("Hello", 1, 2, "World");
    // return word;
  }
}