/**
* I will be creating a program that forms a movie library
* and allows the user to search for specific titles in the library 
* 
* CSC 1350 Programming project No 8
* Section 2
* 
* @author Logan Lafauci
* @since 11/25/2019
*/
public class Movie {
	private String title;
	private int year;
	private String rating;
	
	public Movie()
	{
		title = "";
		year = 0;
		rating = "";
	}
	
	public void SetMovieTitle(String NewTitle)
	{
		title = NewTitle;
	}
	
	public void setReleaseYear(int NewYear)
	{
		year = NewYear;
	}
	
	public void setRating(String NewRating)
	{
		rating = NewRating;
	}
	
	public String MovieTitle()
	{
		return title;
	}
	
	public int ReleaseYear()
	{
		return year;
	}
	
	public String Rating()
	{
		return rating;
	}
}
