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
    public static Stack<String> openTags = new Stack<>();
    public static Stack<String> closeTags = new Stack<>();

    public static boolean validate(String filename) throws FileNotFoundException
    {
        Scanner fileReader = new Scanner(new File(filename));
        while (fileReader.hasNext()){
            String read = fileReader.next();
            if(!read.contains("/")){
                openTags.push(read);
            }
            else{
                closeTags.push(read);
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
        String[] files = {"tags_valid.txt", "tags_invalid.txt"};
        for(String fName: files) {
            System.out.print(fName +": ");
            if (validate(fName)) {
                System.out.println("This file is valid");
            } else {
                System.out.println("This file is invalid");
            }
            System.out.println(openTags);
            System.out.println(closeTags);
        }
    }
}
