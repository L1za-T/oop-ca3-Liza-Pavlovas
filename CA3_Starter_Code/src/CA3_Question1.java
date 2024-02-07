import java.util.Stack;
import java.util.Scanner;

/**
 *  Name: Liza Pavlovas
 *  Class Group: GD2A
 */
public class CA3_Question1
{
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
            } else if (license == 0) {
                System.out.println(driveway);
                break;
            } else{
                license = (license * -1);
                
                boolean done = false;
                    do{
                        if(driveway.peek()==license){
                            driveway.pop();
                            done = true;
                        }
                        else
                        {
                        street.push(driveway.pop());

                        }
                    }while (!done);
                    while (!street.isEmpty()){
                        driveway.push(street.peek());
                        street.pop();
                    }
                }
                System.out.println(driveway);
                System.out.println(street);


        } while (license != 0);

    }

    public static void main(String[] args) {
        runSimulation();
    }
}