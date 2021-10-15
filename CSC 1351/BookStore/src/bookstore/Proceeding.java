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
public class Proceeding extends Publication{
    
    private String city;
    
    public Proceeding(String authorList, String title, String venue, int startingPage, int endPage, int year, String city)
    {
        super(authorList, title, venue, startingPage, endPage, year);
        this.city = city;
    }
    
}
