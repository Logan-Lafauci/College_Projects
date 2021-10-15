/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore;

/**
 *
 * @author logan
 */
import java.util.*;

enum Publisher{ELSEVIER, SPRINGER, IEEE, TAYLORFRANCIS, WILEY, ACM};

public class Publication implements Citable, Comparable<Publication>{
    
    private ArrayList<Author> authors = new ArrayList<>();
    private Publisher publisher;
    private String venue;
    private String title;
    protected int startingPage;
    protected int endPage;
    protected int year;
    private String acronym = "";
    
    public Publication(String authorList, String title, String venue, int startingPage, int endPage, int year)
    {
        //this starts to create the list for authors on a certain piece
        String[] list = authorList.split(",");
        int i = 0;
        for(String author: list)
        {
            authors.add(new Author(list[i]));
            i++;
        }
       
        this.title = title;
        this.venue = venue;
        
        //Figure out what to do with publisher
        
        this.startingPage = startingPage;
        this.endPage = endPage;
        this.year = year;
        
        //this creates the acronym
        String[] venueName = venue.split(" ");
        for(String name: venueName)
        {
            acronym += name.toUpperCase().charAt(0);
        }
    }
    
    public int compareTo(Publication other)
    {
        if(authors.get(0).lastName.compareTo(other.authors.get(0).lastName) != 0)
        {
            return authors.get(0).lastName.compareTo(other.authors.get(0).lastName);
        }
        else if(venue.compareTo(other.venue) != 0)
        {
            return venue.compareTo(other.venue);
        }
        else
        {
            return Integer.compare(year, other.year);
        }
    }
    
    public String Cite()
    {
        String citing = "";
        Collections.sort(authors);
        for(Author author: authors)
        {
            citing += author.firstName.charAt(0) + ". " + author.lastName + ", ";
        }
        citing += "\"" + title + "\", ";
        citing += venue + " (" + acronym + "), ";
        return citing;
    }
    
}
