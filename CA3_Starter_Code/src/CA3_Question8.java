import java.util.Scanner;
import java.util.Stack;

/**
 *  Name: Liza Pavlovas
 *  Class Group: GD2A
 */
public class CA3_Question8 {


    public static Stack<Double> numbers = new Stack<>();
    public static Stack<String> operators = new Stack<>();
    public static char[] hPOp = {'*', '/'};
    public static char[] lPOp = {'+', '-'};
    /*
        Reads in an equation from the user
     */
    public static double result;

    public static double calc(String equation){
        for(int i = 0; i < equation.length(); i++){
            char checkChar = equation.charAt(i);
            Character numCheck = equation.charAt(i);

            if(numCheck.isDigit(checkChar)){
                numbers.push(Double.parseDouble(numCheck.toString()));

            } else if (checkChar == '(') {
                operators.push(numCheck.toString());

            } else if (checkChar == hPOp[0] || checkChar == hPOp[1] || checkChar == lPOp[0] || checkChar == lPOp[1]) {
                System.out.println("Crash test");
                while (operators.peek().charAt(0) == hPOp[0] || operators.peek().charAt(0) == hPOp[1] && checkChar == lPOp[0] || checkChar == lPOp[1]){
                    evaluateTop();
                }
                operators.push(numCheck.toString());
            } else if (checkChar == ')') {
                while (!operators.peek().equals("(")){
                    evaluateTop();
                }

                operators.pop();
            }
        }
        while (!operators.isEmpty()){
            evaluateTop();
        }

        return result;
    }

    public static void evaluateTop(){
        double number = 0;

        double x = numbers.pop();
        double y = numbers.pop();

        String operator = operators.pop();
        System.out.println("Wave");

        if (operator.trim().equals("*")||operator.trim().equalsIgnoreCase("x")){
            number = y*x;
        } else if (operator.trim().equals("/")) {
            number = y/x;
        } else if (operator.trim().equals("+")) {
            number = y+x;
        } else if (operator.trim().equals("-")) {
            number = y-x;
        }
        numbers.push(number);
    }

    public static void main(String[] args) {
        String equation;
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter equation");
        equation = in.nextLine().trim();
        calc(equation);
        System.out.println("The result is: " + result);
    }
}
