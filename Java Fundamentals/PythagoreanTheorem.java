public class PythagoreanTheorem{
  public double calculateHypotenuse(int legA, int legB) {
    //hypotenuse = sqrt of a squared + b squared
    double square = (legA * legA) + (legB * legB);
    double hypo = Math.sqrt(square);
    return hypo;
  }
}