import java.util.Scanner;
import java.util.Stack;

/**
 *  Name: Liza Pavlovas
 *  Class Group: GD2A
 */
public class CA3_Question8 {


    public static Stack<Double> numbers = new Stack<>();
    public static Stack<String> operators = new Stack<>();
    /*
        Reads in an equation from the user
     */
    public static double result;

    public static double calc(String equation){
        for(int i = 0; i < equation.length(); i++){
            char checkChar = equation.charAt(i);
            Character numCheck = equation.charAt(i);

            if(numCheck.isDigit(equation.charAt(i))){
                numbers.push(Double.parseDouble(numCheck.toString()));

            } else if (checkChar == '(') {
                operators.push(numCheck.toString());

            } /*else if (checkChar == '*' || checkChar == '/' || checkChar == '+' || checkChar == '-') */
                else if ((checkChar != '(') || (checkChar != ')') || (!numCheck.isDigit(checkChar)) ){

                System.out.println(numbers);
                System.out.println(operators);

                operators.push(numCheck.toString());

                while (operators.peek().charAt(0) == '*' || operators.peek().charAt(0) == '/'){

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

        System.out.println("The result is: " + calc(equation));
    }
}
