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
    public static String digitNumber;

    public static double calc(String equation){
        for(int i = equation.length()-1; i >= 0; i--){
            Character checkChar = equation.charAt(i);

            if(Character.isDigit(checkChar)){
                digitNumber = checkChar.toString();
                for(int j = i-1; true; j--)
                {
                    if (j < 0)
                    {
                        i -= (i-j-1);
                        break;
                    }
                    else if (!Character.isDigit(equation.charAt(j)))
                    {
                        i -= (i-j-1);
                        break;
                    }
                    else
                    {
                        digitNumber = equation.charAt(j) + digitNumber;
                    }
                }
                numbers.push(Double.parseDouble(digitNumber));


            } else if (checkChar.equals(')')) {
                operators.push(checkChar.toString());

            }
            else if ((checkChar != '(') || (checkChar != ')') || (!Character.isDigit(checkChar)) ){

                if ((checkChar != '*') && (checkChar != '/'))
                {
                    while(!operators.isEmpty()) {
                        if (operators.peek().equals("*") || operators.peek().equals("/")) {
                            evaluateTop();
                        }
                        else{
                            break;
                        }
                    }
                }
                operators.push(checkChar.toString());

            } else if (checkChar.equals('(')) {
                while (!operators.isEmpty()){
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
            number = x*y;
        } else if (operator.equals("/")) {
            number = x/y;
        } else if (operator.equals("+")) {
            number = x+y;
        } else if (operator.equals("-")) {
            number = x-y;
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
