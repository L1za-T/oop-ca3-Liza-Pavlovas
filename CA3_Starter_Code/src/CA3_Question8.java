import java.util.Scanner;
import java.util.Stack;

/**
 *  Name: Liza Pavlovas
 *  Class Group: GD2A
 */
public class CA3_Question8 {


    public Stack<Integer> numbers = new Stack<>();
    public Stack<String> operators = new Stack<>();
    /*
        Reads in an equation from the user
     */
    public double result;

    public double calc (String equation){


        return result;
    }

    public void evaluateTop(){
        int number = 0;
        int x = numbers.pop();
        int y = numbers.pop();

        String operator = operators.pop();

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
    }
}
