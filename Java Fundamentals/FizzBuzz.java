public class FizzBuzz{
  public String fizzBuzz(int number){
    String fizz = "Fizz";
    String buzz = "Buzz";
    String fizzbuzz = "FizzBuzz"; 

    if(number % 15 == 0){
      return fizzbuzz;
    }
    else if(number % 3 == 0){
      return fizz;
    }
    else if(number % 5 == 0){
      return buzz;
    }
    
    else{
      return String.valueOf(number);
    }
  }
}
