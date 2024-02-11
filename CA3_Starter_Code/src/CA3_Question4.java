import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;
/**
 *  Name: Liza Pavlovas
 *  Class Group: GD2A
 */
public class CA3_Question4 {

    /*
        filename: name of the file to test.
     */
    public static Stack<String> tags = new Stack<>();

    public static boolean validate(String filename) throws FileNotFoundException
    {
        Scanner fileReader = new Scanner(new File(filename));
        while (fileReader.hasNext()){
            String read = fileReader.next();
            if(!read.contains("/")){
                tags.push(read);
            }
            else{
                String top = tags.pop();
                    if (tags.isEmpty() && top.substring(1).equals(read.substring(2))) {
                        return true;
                    }
            }
        }
        return false;
    }

    /*
        This function tests the files in the files array to see if
         they are valid.
         tags_valid.txt should return true;
         tags_invalid.txt should output as invalid;
     */

    public static void main(String[] args) throws FileNotFoundException {
        String[] files = {"CA3_Starter_Code/tags_valid.txt", "CA3_Starter_Code/tags_invalid.txt"};
        for(String fName: files) {
            System.out.print(fName +": ");
            if (validate(fName)) {
                System.out.println("This file is valid");
            } else {
                System.out.println("This file is invalid");
            }
//            System.out.println(tags);

        }
    }
}
