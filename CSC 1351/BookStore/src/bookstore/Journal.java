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
public class Journal extends Publication{
    
    private int volume;
    private int number;
    
    public Journal(String authorList, String title, String venue, int startingPage, int endPage, int year, int volume, int number)
    {
        super(authorList, title, venue, startingPage, endPage, year);
        this.volume = volume;
        this.number = number;
    }
    
}
