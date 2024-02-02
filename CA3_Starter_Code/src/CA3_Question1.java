import java.util.Stack;
import java.util.Scanner;

/**
 *  Name: Liza Pavlovas
 *  Class Group: GD2A
 */
public class CA3_Question1
{
    static int license;
    Scanner kbInput = new Scanner(System.in);

    Stack<Integer> driveway = new Stack<Integer>();
    Stack<Integer> street = new Stack<Integer>();


    static void drivewayPush(Stack<Integer> driveway){
        driveway.push(license);
    }

    static void drivewayPop(Stack<Integer> driveway){
        driveway.pop();
    }

    static void streetPush(Stack<Integer> street){
        street.push(license);
    }

    static void streetPop(Stack<Integer> street){
        street.pop();
    }

    public static void runSimulation()
    {

    }

    public static void main(String[] args) {
        runSimulation();
    }
}
