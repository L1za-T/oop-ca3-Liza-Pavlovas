import java.util.Scanner;
import java.util.Stack;

/**
 *  Name:
 *  Class Group:
 */

public class CA3_Question5
{
    public static Stack<String> take_off = new Stack<>();
    public static Stack<String> landing = new Stack<>();
    public static String planeInputs;

    public static void runSimulation(){
        String currentPlane;
        int queueSize = (take_off.size() + landing.size());
        for (int i = queueSize; i !=0; i--) {

            if (!landing.empty()) {
                currentPlane = landing.pop();
                System.out.println(currentPlane + " landing.");
            }
            else{
                System.out.println(take_off);
                currentPlane = take_off.pop();
                System.out.println(currentPlane + " is taking off.");
            }
        }
    }


    public static void main(String[] args)
    {
        Scanner kbInput = new Scanner(System.in);

        boolean exit = false;
        System.out.println("Please choose to queue flights for landing or takeoff, run the simulation, or exit.");
        do{
            System.out.printf("%s %n %s %n %s %n %s %n", "1: Queue for landing.", "2: Queue for takeoff.", "3: Run simulation.", "4: Exit.");
            int menuChoice = kbInput.nextInt();
            planeInputs = "Not Zero";
            switch (menuChoice){
                case 1:
                    System.out.println("Enter flight number to land. Enter 0 to return to the menu.");
                    while (!planeInputs.equals("0")){
                        planeInputs = kbInput.nextLine();
                        if(!planeInputs.equals("0")){
                            landing.push(planeInputs);
                        }
                    }
                    break;
                case 2:
                    System.out.println("Enter flight number to take off. Enter 0 to return to the menu.");
                    while (!planeInputs.equals("0")) {
                        planeInputs = kbInput.nextLine();
                        if (!planeInputs.equals("0")) {
                            take_off.push(planeInputs);
                        }
                    }
                    break;
                case 3:
                    runSimulation();
                    break;
                case 4:
                    System.out.println("Exiting software.");
                    exit = true;
                    break;
            }
        }while (!exit);
    }
}
