import java.util.Stack;
import java.util.Scanner;

/**
 *  Name: Liza Pavlovas
 *  Class Group: GD2A
 */
public class CA3_Question1
{


    static void drivewayPop(Stack<Integer> driveway){
        driveway.pop();
    }

    static void streetPop(Stack<Integer> street){
        street.pop();
    }

    public static void runSimulation()
    {
        int license;

        Scanner kbInput = new Scanner(System.in);

        Stack<Integer> driveway = new Stack<Integer>();

        Stack<Integer> street = new Stack<Integer>();

        System.out.println("Please enter the license number of the parked car.");
        do{
            license = kbInput.nextInt();
            if(license > 0){
                driveway.push(license);
                System.out.println(driveway);
            } else if (license < 0) {
                System.out.println(driveway.search(license));
                System.out.println(driveway);
            } else if (license == 0){
                System.out.println(driveway);
                break;
            }

        } while (license != 0);

    }

    public static void main(String[] args) {
        runSimulation();
    }
}
