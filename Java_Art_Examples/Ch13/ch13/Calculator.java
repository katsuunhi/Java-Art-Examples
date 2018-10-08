package ch13;

import java.lang.Math;
import java.util.HashMap;
import java.util.Stack;
import java.util.StringTokenizer;

/*
Calculator class evaluates expressions with numbers ,including integers and floating-point values,
and operators, including +, -, *, /, %, ^, (, and ).
method - isValidExpression(expr : String) : boolean - validates the expression.
method - evaluate(expr : String) : Number - evaluates the expression.
NOTE:
  Every token in the expression should be separated by white space.
  Operator ^ stands for power.
  Number can be negative.
*/

class Calculator
{
  private Stack<String> stack;
  private HashMap<String, Integer> map;

  Calculator() {
    stack = new Stack<String>();

    map = new HashMap<String, Integer>();
    map.put( "+", 1 );
    map.put( "-", 1 );
    map.put( "*", 2 );
    map.put( "/", 2);
    map.put( "%", 2);
    map.put( "^", 3 );
  }

  public boolean isValidExpression(String expr)  {
    StringTokenizer stringTokens = new StringTokenizer(expr);
    boolean firstToken = true;
    boolean isOperator = false;
    boolean isRP = false;
    int rpCount = 0;
    boolean isLP = false;
    int lpCount = 0;
    boolean isData = false;
    boolean isValid = true;
    String currentToken = null;

    while (stringTokens.hasMoreTokens() && isValid) {
      currentToken = stringTokens.nextToken();
      if (firstToken && currentToken.matches("-?[0-9]*\\.?[0-9]+")){
        isData = true;
        firstToken = false;
      } else if (firstToken && currentToken.equals("(")){
        isLP = true;
        firstToken = false;
        lpCount = lpCount + 1;
      } else if (isData && currentToken.matches("[+\\-*/%^]")) {
        isData = false;
        isOperator = true;
      } else if (isData && currentToken.equals(")")) {
        isData = false;
        isRP = true;
        rpCount = rpCount + 1;
      } else if (isOperator && currentToken.equals("(")){
        isLP = true;
        isOperator = false;
        lpCount = lpCount + 1;
      } else if (isOperator && currentToken.matches("-?[0-9]*\\.?[0-9]+") ){
        isData = true;
        isOperator = false;
      } else if (isLP && currentToken.equals("(")){
        isLP = true;
        lpCount = lpCount + 1;
      } else if (isLP && currentToken.matches("-?[0-9]*\\.?[0-9]+") ){
        isLP = false;
        isData = true;
      } else if (isRP && currentToken.matches("[+\\-*/%^]") ) {
        isRP = false;
        isOperator = true;
      } else if (isRP && currentToken.equals(")")) {
        isRP = true;
        rpCount = rpCount + 1;
      } else {
        isValid = false;
      }
    }
    if (isValid && (!(currentToken.matches( "-?[0-9]*\\.?[0-9]+" ) || currentToken.equals(")")) || lpCount != rpCount)) {
      isValid = false;
    }
    return isValid;
  }

  public Number evaluate(String expr) {
    StringTokenizer stringTokens = new StringTokenizer(expr);
    while (stringTokens.hasMoreTokens()) {
      String currentToken = stringTokens.nextToken();
      if (currentToken.matches("[+\\-*/%^]")){
         stack.push(recursiveOperate(currentToken, stack));
         stack.push(currentToken);
      } else if (currentToken.equals(")")) {
         stack.push(recursiveOperate(currentToken, stack));
      } else {
         stack.push(currentToken);
      }
    }
    String result = recursiveOperate("end", stack);
    return (Number) Double.parseDouble(result);
  }

  private String recursiveOperate(String currentToken, Stack<String> stack0) {
    String temp = stack0.pop();

    System.out.println("stack0: " + stack0);
    System.out.println("temp: " + temp);
    System.out.println("currentToken: " + currentToken);
    System.out.println("stack0.isEmpty(): " + stack0.isEmpty());
    System.out.println("map: " + map);
    
    System.out.println("map.get(): " + map.get(currentToken));
    if(!stack0.isEmpty()){
       System.out.println("stack0.peek(): " + stack0.peek());
       System.out.println("map.get(stack0.peek()): " + map.get(stack0.peek()));
       System.out.println("stack0.peek().equals((): " + stack0.peek().equals("("));
    }
    System.out.println("!currentToken.equals(): " + !(currentToken.equals(")")));
    
    if (stack0.isEmpty() ) {
    	return temp;
    }
    else if (!currentToken.equals(")") && (map.get(stack0.peek()) < map.get(currentToken) || stack0.peek().equals("("))) {
    	
    	//System.out.println("stack0.isEmpty() in if: " + stack0.isEmpty());
    	return temp;
    } else if (currentToken.equals(")") && stack0.peek().equals("(")) {
      stack0.pop();
      return temp;
    } else {
      stack0.push(temp);
      stack0.push(oneOperate(stack0));

     
      return  recursiveOperate(currentToken, stack0);
    }
  }

  private String oneOperate(Stack<String> stack0) {
	String secondStr = stack0.pop();
    Double second = Double.parseDouble(secondStr);
    String op = stack0.pop();

    String firstStr = stack0.pop();
    Double first = Double.parseDouble(firstStr);

    if (op == "+") {
      first =  first  + second;
    } else if (op == "-") {
      first =  first  - second;
    } else if (op == "*") {
      first =  first  * second;
    } else if (op == "/") {
      first =  first  / second;
    } else if (op == "%") {
      first =  first  % second;
    } else if (op == "^") {
      first =  Math.pow(first, second);
    }
    return  first.toString();
  }
}
