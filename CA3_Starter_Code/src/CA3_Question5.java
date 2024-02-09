import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 *  Name: Liza Pavlovas
 *  Class Group: GD2A
 */

public class CA3_Question5
{
    public static Queue<String> take_off = new LinkedList<>();
    public static Queue<String> landing = new LinkedList<>();
    public static String userInputs;

    public static void runSimulation(){
        String currentPlane;


            if (!landing.isEmpty()) {
                currentPlane = landing.remove();
                System.out.println(currentPlane + " landing.");
            }
            else{
                currentPlane = take_off.remove();
                System.out.println(currentPlane + " is taking off.");
            }
    }

    public static void main(String[] args)
    {
        Scanner kbInput = new Scanner(System.in);

        boolean exit = false;
        System.out.println("Please queue flights for landing or takeoff, run the simulation, or exit.");
        do{
            userInputs = kbInput.nextLine();

           if(userInputs.contains("takeoff Flight-")){
               take_off.add(userInputs);
               System.out.println(userInputs + " is queued");
           } else if (userInputs.contains("land Flight-")) {
               landing.add(userInputs);
               System.out.println(userInputs + " is queued");
           } else if (userInputs.contains("next")) {
               runSimulation();
           }else if (userInputs.contains("exit")) {
                exit = true;
           }
           else {
               System.out.println("Invalid input, please try again.");
           }
        }while (!exit);
    }
}
