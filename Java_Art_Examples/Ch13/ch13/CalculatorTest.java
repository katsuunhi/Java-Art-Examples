package ch13;

public class CalculatorTest {
  public static void main(String[] args) {

    //String expr = "-48.5 + ( 2.0 - 3 - 2 ) ^ 2 ^ 3 * 2 * ( ( 2 * 3 % 2 % 2 ) % 3 - 3 / 2 / 2 ) - 2 + 3";
    //var expr = "2 + ( 2 - 3 - 2 ) ^ ( 2 ^ 3 ) * 2 * ( ( 2 * 3 / 2 / 2 ) / 3 - 2 ) - 2 + 3"
    //var expr = "1 - ( -48 + ( 4.5 ) / 3 * ( -48 + 4 / 3 * ( -48.12 + 4 / 3 * 2 ) * 2 - 2 ) + 2 ) + 2 / 3"
    //var expr = "3 + 9 * 2 - 2 * 3 - 4 / 2 * ( 3 * ( 1 + 1 ) )"
    //var expr = "3 + 9 * 2 - 2 * 3 + 4 / 2 * ( 3 * ( 1 + 1 ) )"
    //var expr = "3 + 9 * 2 + 2 * 3 + 4 / 2 * ( 3 * ( 1 + 1 ) )"
    //var expr = "2 * 3 + 4 / 2 * ( 3 * ( 1 + 1 ) )"
    //var expr = "4 / 2 * ( 3 * ( 1 + 1 ) )"
    //var expr = "( ( 1 + 2 * 3 + 1 ) + 4 ) / ( 3 * ( 1 + 1 ) )"
    //var expr = "( ( 1 - 2 * 3 + 1 ) + 2 ) * 3"
    String expr = "1 - ( ( 2 - 3 ) * 4 - 5 )";

    Calculator calculator = new Calculator();
    if (calculator.isValidExpression( expr )) {
      Number actual =  calculator.evaluate( expr );
      System.out.println(actual);
    } else {
      System.out.println("Expression is invalid");
    }
  }
}