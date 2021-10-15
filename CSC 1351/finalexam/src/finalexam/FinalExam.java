package finalexam;


import java.io.FileNotFoundException;
import java.util.*;

public class FinalExam {

    
     public static void main(String[] args) throws FileNotFoundException{
        
        //Loading the list of names into a string array
        String[] namesArray = Utilities.GetStringArray(Utilities.loadNames()); 
        
        //Sorting names 
        Utilities.SortNames(namesArray);
        
        //Reversing a name
        String name = "Steven";
        System.out.println(name + " reversed is: " + Utilities.reverseName(name));          
        
        System.out.println("-----------------------------------------------------------------------");  
        
        //Searching for a name 
        int targetIndex = Utilities.BinarySearchNames(namesArray, name);
        
        if( targetIndex > 0)
            System.out.println(name + " is found at index: " + targetIndex);  
        else 
            System.out.println("Not found");  
        
        System.out.println("-----------------------------------------------------------------------");  
        
        //Generating the hexadecimal code of the name  
        System.out.println("Hexadecimal code for " + name + " is: " + Utilities.nameToHex(name)); 
        
        
        System.out.println("-----------------------------------------------------------------------");  
        
        //Printing out all the palendrome names  
        for(String a: namesArray)
            if(Utilities.isPalendrome(a))
                System.out.println(a + " is a palendrome!");  
        
        System.out.println("-----------------------------------------------------------------------");  
        
        
    }
    
}
