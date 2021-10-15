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
public class Author implements Comparable<Author>{
    
    protected String firstName;
    protected String lastName;
    protected String institution;
    
    public Author(String name)
    {
        String[] names = name.split(" ");
        firstName = names[0];
        lastName = names[1];
    }
            
    public void setInstitution()
    {
        
    }
    
    public int compareTo(Author other)
    {
        if(lastName.compareTo(other.lastName) != 0)
        {
            return lastName.compareTo(other.lastName);
        }
        return firstName.compareTo(other.firstName);
    }
}
