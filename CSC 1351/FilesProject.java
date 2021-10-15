//Student Name: Logan Lafauci
//LSU ID: llafau1
//Lab Section: 1
//Assignment: Lab 1
//Submission Time: 6:15

package filesproject;
import java.io.FileNotFoundException;
import java.io.File;
import java.io.PrintWriter;
import java.util.*;
/**
 *
 * @author llafau1
 */
public class FilesProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)throws FileNotFoundException 
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter your file name:");
        String fileName = in.next() + ".txt";
        System.out.println("Eneter your file size:");
        int size = in.nextInt();
        populateFile(fileName, size);
        System.out.printf("File: %-15s Mean: %-8.2f Max: %d\n", fileName, getMean(fileName), getMax(fileName));
    }
    
    //this fills the folder with a set amount of random integers as the user has specified 
    public static void populateFile(String file, int size)throws FileNotFoundException
    {
        PrintWriter randomFile = new PrintWriter(file);
        Random rand = new Random();
        for(int i = 0; i < size; i++)
        {
            randomFile.println(rand.nextInt(1001)+1000);
        }
        randomFile.close();
    }
    
    // this takes the file created by the user and calculates the average value of the random numbers
    public static double getMean(String file)throws FileNotFoundException
    {
        File inputFile = new File(file);
        Scanner in = new Scanner(inputFile);
        int sum = 0;
        int count = 0;
        
        while(in.hasNextInt())
        {
            sum += in.nextInt();
            count ++;
        }
        return (double)sum / count;
    }
    
    //this method searches a file already created for the maximum value
    public static int getMax(String file)throws FileNotFoundException
    {
        File inputFile = new File(file);
        Scanner in = new Scanner(inputFile);
        int max = 0;
        
        while(in.hasNextInt())
        {
            int compare = in.nextInt();
            if(compare > max)
                max = compare;
        }
        return max;
    }
}
