import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * Write a description of class WC here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WC
{
    public static void main(String[] args) throws FileNotFoundException
    {
        Scanner ask = new Scanner(System.in);
        System.out.println("What is the file name you are looking for: ");
        String file = ask.next();
        
        File f = new File(file);
        Scanner in1 = new Scanner(f);
        
        in1.useDelimiter("");
        int characters = 0;
        while (in1.hasNext())
        {
            String rand = in1.next();
            characters++;
        }
        System.out.println("Characters: " + characters);
        in1.close();
        
        Scanner in2 = new Scanner(f);
        
        int words = 0;
        while (in2.hasNext())
        {
            String rand = in2.next();
            words++;
        }
        System.out.println("Words: " + words);
        in2.close();
        
        Scanner in3 = new Scanner(f);
        
        int enters = 0;
        in3.useDelimiter("\n");
        while (in3.hasNext())
        {
            String rand = in3.next();
            enters++;
        }
        System.out.println("Lines: " + enters);
        in3.close();
    }

    
}
