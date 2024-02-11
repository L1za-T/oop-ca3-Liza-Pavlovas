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
            Character numCheck = equation.charAt(i);
            String digitNumber;

            if(Character.isDigit(numCheck)){
                digitNumber = numCheck.toString();
                for(int j = i+1; true; j++)
                {
                    if (j == equation.length())
                    {
                        i += (j-i-1);
                        break;
                    }
                    else if (!Character.isDigit(equation.charAt(j)))
                    {
                        i += (j-i-1);
                        break;
                    }
                    else
                    {
                        digitNumber += equation.charAt(j);
                    }
                }
                numbers.push(Double.parseDouble(digitNumber));
            } else if (numCheck.toString().equals("(")) {
                operators.push(numCheck.toString());
            }
                else if ((numCheck.toString().equals ("*")) ||(numCheck.toString().equals("/"))|| (!Character.isDigit(numCheck)) ){

                    if(!operators.isEmpty()) {
                        while (operators.peek().equals("*") || operators.peek().equals("/")) {

                            evaluateTop();
                        }
                    }
                operators.push(numCheck.toString());

            } else if (numCheck.toString().equals( ")")) {
                while (!operators.isEmpty() && !operators.peek().equals("(")){
                    evaluateTop();
                }
                operators.pop();
            }
        }
        while (!operators.isEmpty()){
            evaluateTop();
        }

        return result=numbers.peek();
    }

    public static void evaluateTop(){
        double number = 0;

        double x = numbers.pop();
        double y = numbers.pop();

        String operator = operators.pop();

        if (operator.equals("*")||operator.equalsIgnoreCase("x")){
            number = y*x;
        } else if (operator.equals("/")) {
            number = y/x;
        } else if (operator.equals("+")) {
            number = y+x;
        } else if (operator.equals("-")) {
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
