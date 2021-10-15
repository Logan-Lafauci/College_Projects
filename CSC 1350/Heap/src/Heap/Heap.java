
package Heap;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Heap {
    
    public Heap() throws FileNotFoundException
    {
        //This reads our files which host all of the commands we need
        File input = new  File("inputFile.txt");
        Scanner in = new Scanner(input);
        
        //these variables are important for setting up the heap and also used to tell my program how to run later on
        int commandAmount = Integer.parseInt(in.next());
        int[] theHeap = new int[commandAmount];
        int newNode = 0;
        int extracted = 0;
        
        //This segment if going through all the commands we have in our txt file
        for(int i = 1; i <= commandAmount; i++)
        {
            switch (in.next()) {
                case "IN":
                    insert(theHeap, Integer.parseInt(in.next()), newNode);
                    newNode++;
                    break;
                case "DK":
                    decreaseKey(theHeap, Integer.parseInt(in.next()), Integer.parseInt(in.next()));
                    break;
                case "EM":
                    newNode--;
                    extracted = extractMin(theHeap, newNode);
                    break;
                default:
                    break;
            }
        }
        
        //this prints out the last extracted value
        System.out.println(extracted);
    }
    
    //This inserts a new element to the end of our array and then we sort it to fit heap notation
    public void insert(int[]arr, int number, int nodeAmount)
    {
        arr[nodeAmount] = number;
        floatUp(arr, nodeAmount);
    }
    
    //This decrease a number at a certain key then makes sure the new number fits the heap
    public void decreaseKey(int[]arr, int position, int number)
    {
        arr[position] = number;
        floatUp(arr, position);
    }
    
    //This takes out the minimum value out of the array and puts the last one in the first position to sink down
    private static int extractMin(int[] arr, int nodeAmount)
    {
        int min = arr[0];
        arr[0] = arr[nodeAmount];
        arr[nodeAmount] = 0; 
        sinkDown(arr, nodeAmount);
        return min;
    }
    
    //This is used to make sure low values that we mess with fit our heap notation
    private static void floatUp(int[] arr, int currentIndex)
    {
        int node = currentIndex;
        //The parent variable is what is used to help the program find the parnet for a eap tree the value is assigned based on what case we run into
        int parent, temp;
        //because of how the node changes within it this while loop should run at log base 3 or shorter of n which is O(log n)
        while(node != 0)
        {
            //the switch is helping me find the parent for the node im currently at then calculating to get to it
            switch (node%3)
            {
                case 0:
                    parent = node/3 - 1;
                    if(arr[node] < arr[parent])
                    {
                        temp = arr[parent];
                        arr[parent] = arr[node];
                        arr[node] = temp;
                        node = parent;
                    }
                    else{node = 0;}
                    break;
                case 1:
                    parent = (node+2)/3 - 1;
                    if(arr[node] < arr[parent])
                    {
                        temp = arr[parent];
                        arr[parent] = arr[node];
                        arr[node] = temp;
                        node = parent;
                    }
                    else{node = 0;}
                    break;
                case 2:
                    parent = (node+1)/3 - 1;
                    if(arr[node] < arr[parent])
                    {
                        temp = arr[parent];
                        arr[parent] = arr[node];
                        arr[node] = temp;
                        node = parent;
                    }
                    else{node = 0;}
                    break;
                default :
                    break;
            }
        }
    }
    
    //This takes the first value in the array and makes it sink down to fit the heap notation
    private static void sinkDown(int[]arr, int currentIndex)
    {
        int node = 0;
        // this gets the children so we can compare them to see which has the lowest value
        int rightChild, middleChild, leftChild, temp;
        while(node < currentIndex)
        {
            rightChild = (node + 1) *3;
            middleChild = rightChild - 1;
            leftChild = rightChild - 2;
            //These if statements check to see if they are min in there section and makes sure it is not aking info from the tail of zeros
            if((arr[node] > arr[rightChild] && arr[rightChild] != 0) && (rightChild < currentIndex && (arr[rightChild] < arr[middleChild] && arr[rightChild] < arr[leftChild])))
            {
                temp = arr[rightChild];
                arr[rightChild] = arr[node];
                arr[node] = temp;
                node = rightChild;
            }
            else if((arr[node] > arr[middleChild] && arr[middleChild] != 0) && (middleChild < currentIndex && ((arr[middleChild] < arr[rightChild] && arr[middleChild] < arr[leftChild]) || (arr[middleChild] < arr[leftChild] && arr[rightChild] == 0))))
            {
                temp = arr[middleChild];
                arr[middleChild] = arr[node];
                arr[node] = temp;
                node = middleChild;
            }
            else if((arr[node] > arr[leftChild] && arr[leftChild] != 0) && (leftChild < currentIndex && ((arr[leftChild] < arr[middleChild] && arr[leftChild] < arr[rightChild]) || (arr[rightChild] == 0 && arr[middleChild] == 0))))
            {
                temp = arr[leftChild];
                arr[leftChild] = arr[node];
                arr[node] = temp;
                node = leftChild;
            }
            else
            {
                node = currentIndex;
            }
            //The else is setting node to the number to break the condition of the while loop if there are no value that work
        }
    }
    
}

class theMain
{
	public static void main(String[] args) throws FileNotFoundException
	{
		Heap test = new Heap();
	}
}