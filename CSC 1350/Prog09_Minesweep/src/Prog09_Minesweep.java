/**
* I will be creating a program that forms the basis for minesweeper
* 
* CSC 1350 Programming project No 8
* Section 2
* 
* @author Logan Lafauci
* @since 11/18/2019
*/
import java.util.Scanner;

public class Prog09_Minesweep {

	public static void main(String[] args) {
		//this takes in value for the user to create the size of the board
		int rows = arrayAmount("Enter number of rows in a matrix (must be more than 4):");
		int columns = arrayAmount("Enter number of columns in a matrix (must be more than 4):");
		int[][] board = new int[rows][columns];
		
		//here we calculate the amount of bombs needed and place them randomly in the 2d array
		int bombs = (int)(rows * columns * .10);
		int placed = 0;
		while(placed < bombs)
		{
			int randomRow = randomNum(rows, 0);
			int randomColumn = randomNum(columns, 0);
			if(randomNum(bombs, 0) == 0 && board[randomRow][randomColumn] != -1)
			{
				board[randomRow][randomColumn] = -1;
				placed++;
			}
		}
		
		//Here we are figuring how any "bombs" are near a certain element in the array 
		
		//This checks the internal values
		for(int i = 1; i < rows - 1; i++)
		{
			for(int j = 1; j < columns - 1; j++)
			{
				int numBomb = 0;
				if(board[i][j] != -1)
				{
					if(board[i-1][j-1] == -1)
					{
						numBomb ++;
					}
					if(board[i-1][j] == -1)
					{
						numBomb ++;
					}
					if(board[i-1][j+1] == -1)
					{
						numBomb ++;
					}
					if(board[i][j-1] == -1)
					{
						numBomb ++;
					}
					if(board[i][j+1] == -1)
					{
						numBomb ++;
					}
					if(board[i+1][j-1] == -1)
					{
						numBomb ++;
					}
					if(board[i+1][j] == -1)
					{
						numBomb ++;
					}
					if(board[i+1][j+1] == -1)
					{
						numBomb ++;
					}
					board[i][j] = numBomb;
				}
			}
		}
		
		// This part checks the corners
		{
			if(board[0][0] != -1)
			{
				int numBomb = 0;
				if(board[0][1] == -1)
				{
					numBomb ++;
				}
				if(board[1][0] == -1)
				{
					numBomb ++;
				}
				if(board[1][1] == -1)
				{
					numBomb ++;
				}
				board[0][0] = numBomb;
			}
			if(board[0][columns-1] != -1)
			{
				int numBomb = 0;
				if(board[0][columns-2] == -1)
				{
					numBomb ++;
				}
				if(board[1][columns-2] == -1)
				{
					numBomb ++;
				}
				if(board[1][columns-1] == -1)
				{
					numBomb ++;
				}
				board[0][columns-1] = numBomb;
			}
			if(board[rows-1][0] != -1)
			{
				int numBomb = 0;
				if(board[rows-2][0] == -1)
				{
					numBomb ++;
				}
				if(board[rows-2][1] == -1)
				{
					numBomb ++;
				}
				if(board[rows-1][1] == -1)
				{
					numBomb ++;
				}
				board[rows-1][0] = numBomb;
			}
			if(board[rows-1][columns-1] != -1)
			{
				int numBomb = 0;
				if(board[rows-2][columns-2] == -1)
				{
					numBomb ++;
				}
				if(board[rows-2][columns-1] == -1)
				{
					numBomb ++;
				}
				if(board[rows-1][columns-2] == -1)
				{
					numBomb ++;
				}
				board[rows-1][columns-1] = numBomb;
			}
		}
		
		//This checks the sides
		{
			for(int i = 1; i < rows-1; i ++)
			{
				if(board[i][0] != -1)
				{
					int numBomb = 0;
					if(board[i-1][0] == -1)
					{
						numBomb ++;
					}
					if(board[i-1][1] == -1)
					{
						numBomb ++;
					}
					if(board[i][1] == -1)
					{
						numBomb ++;
					}
					if(board[i+1][0] == -1)
					{
						numBomb ++;
					}
					if(board[i+1][1] == -1)
					{
						numBomb ++;
					}
					board[i][0] = numBomb;
				}
				
				if(board[i][columns-1] != -1)
				{
					int numBomb = 0;
					if(board[i-1][columns-1] == -1)
					{
						numBomb ++;
					}
					if(board[i-1][columns-2] == -1)
					{
						numBomb ++;
					}
					if(board[i][columns-2] == -1)
					{
						numBomb ++;
					}
					if(board[i+1][columns-1] == -1)
					{
						numBomb ++;
					}
					if(board[i+1][columns-2] == -1)
					{
						numBomb ++;
					}
					board[i][columns-1] = numBomb;
				}
			}
		}
		
		//This checks the top and bottom row
		{
			for(int i = 1; i < columns-1; i ++)
			{
				if(board[0][i] != -1)
				{
					int numBomb = 0;
					if(board[0][i-1] == -1)
					{
						numBomb ++;
					}
					if(board[1][i-1] == -1)
					{
						numBomb ++;
					}
					if(board[1][i] == -1)
					{
						numBomb ++;
					}
					if(board[0][i+1] == -1)
					{
						numBomb ++;
					}
					if(board[1][i+1] == -1)
					{
						numBomb ++;
					}
					board[0][i] = numBomb;
				}
				
				if(board[rows-1][i] != -1)
				{
					int numBomb = 0;
					if(board[rows-1][i-1] == -1)
					{
						numBomb ++;
					}
					if(board[rows-2][i-1] == -1)
					{
						numBomb ++;
					}
					if(board[rows-2][i] == -1)
					{
						numBomb ++;
					}
					if(board[rows-1][i+1] == -1)
					{
						numBomb ++;
					}
					if(board[rows-2][i+1] == -1)
					{
						numBomb ++;
					}
					board[rows-1][i] = numBomb;
				}
			}
		}
		
		//This outputs the info 
		System.out.println(bombs+"");
		for(int i = 0; i < rows; i++)
		{
			System.out.print("-");
			for(int k = 0; k < columns; k++)
			{
				System.out.print("----");
			}
			System.out.printf("%n| ");
			for(int j = 0; j < columns; j++)
			{
				if(board[i][j] == -1)
				{
					System.out.print("* | ");
				}
				else
				{
					System.out.print(board[i][j] + " | ");
				}
			}
			System.out.println("");
		}
		System.out.print("-");
		for(int i = 0; i < columns; i++)
		{
			System.out.print("----");
		}
	}
	
	/**
	 * This method validates a number that the user inputs to create an array for the user
	 * Developed: 11-11-2019 
	 * @author Logan Lafauci
	 * @param question is the question you want the user to answer to create an array for info
	 * @return returns the users valid answer
	 */
	public static int arrayAmount(String question)
	{
		boolean check = true;
		int num = 0;
		Scanner in = new Scanner(System.in);
		System.out.println(question);
		while(check)
		{
			while(!in.hasNextInt())
			{
				String bad = in.next();
				System.out.println("Enter in a valid number");
				System.out.println(question);
			}
			num = in.nextInt();
			if(num < 4)
			{
				System.out.println("Enter in a valid number");
				System.out.println(question);
			}
			else
			{
				check = false;
			}
		}
		return num;
	}
	
	/**
	 * This method creates a number within a set range 
	 * Developed: 11-18-2019 
	 * @author Logan Lafauci
	 * @param Takes a lower and upper bound number to create a random number within that range
	 * @return returns a number that has een randomly generated
	 */
	public static int randomNum(int upper, int lower)
	{
		double num = Math.random() * (upper - lower) + lower;
		return (int)num;
	}
}
