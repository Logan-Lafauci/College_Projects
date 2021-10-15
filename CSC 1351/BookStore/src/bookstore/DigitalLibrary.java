package bookstore;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList; 
import java.util.Collections;
import java.util.Scanner;
import java.io.PrintWriter;

//Enumeration with all allowed publisher names

public class DigitalLibrary {
    
   private ArrayList<Publication> publications = new ArrayList<>();
   
   public void loadPublications() throws FileNotFoundException
    {
        
        File input = new  File("publications.txt"); 
        Scanner in = new Scanner(input);
        
        while(in.hasNext())
        {
           //COMPLETE: read each line of the file, based on the number of fields, decide whether it is a journal or a proceeding. Extarct the fields and add the publication to the publications ArrayList
           String[] line = in.nextLine().split(";");
           if(line.length == 9)
           {
                publications.add(new Journal(line[0], line[1], line[2], Integer.parseInt(line[4]), Integer.parseInt(line[5]), Integer.parseInt(line[8]), Integer.parseInt(line[6]), Integer.parseInt(line[7])));
           }
           else
           {
               publications.add(new Proceeding(line[0], line[1], line[2], Integer.parseInt(line[5]), Integer.parseInt(line[6]), Integer.parseInt(line[7]), line[4]));
           }
        }
    }
   
   
   
   public void listPublications()
   {
       //COMPLETE: sort publications and print them. Add the numbers [1], [2], etc. at the begining of each line 
           Collections.sort(publications);
           int i = 1;
	   for(Publication p : publications)
           {
               System.out.println("[" + i + "] " + p.Cite());
               i++;
           }
   }
   
   
   
   public void saveCitations(String fileName) throws FileNotFoundException
   {
       PrintWriter prw = new PrintWriter(fileName + ".txt");
       
       //COMPLETE: Save citations to the file "fileName"
	 int number = 1;
	   for(Publication p : publications)
           {
               prw.println("[" + number + "] " + p.Cite());
               number++;
           }  
           prw.close();
       System.out.println(number - 1 + " citations have been saved to the file " + fileName + ".txt");
       
   }
   
   
   
   
}
