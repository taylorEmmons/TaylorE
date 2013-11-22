
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/** 
    Description: 

    @author Teresa Cole
    @version CS125
*/
public class ReadFromFile
{

    /** main method */
    public static void main( String [] args)
    {
        int count = 0;

        if (args.length == 0) {
            System.err.println();
            System.err.println("Usage: java ReadFromFile <filename>");
            System.err.println();
            System.exit(1);
        }
        File file = new File(args[0]);

        try {
            Scanner inFile = new Scanner( file);
            while (inFile.hasNext()) 
            {
                String line = inFile.nextLine();
                count++;
            }
            System.out.println(args[0] + " has " + count + " lines.");
        } catch (FileNotFoundException e) {
            System.err.println();
            System.err.println("ReadFromFile: File " + args[0] + " does not exist.");
            System.err.println();
        }
    }
        
}
