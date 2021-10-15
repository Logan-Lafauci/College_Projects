
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Heap {
    
    public static void main(String[] args) throws FileNotFoundException
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
            switch (in.next())
            {
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
        
        //This prints out the last extracted value
        System.out.println(extracted);
    }
    
    //This inserts a new integer to the end of our array and then we sort it to fit heap notation
    private static void insert(int[]arr, int number, int nodeAmount)
    {
        arr[nodeAmount] = number;
        floatUp(arr, nodeAmount);
    }
    
    //This decrease a number at a certain key then makes sure the new number fits the heap
    private static void decreaseKey(int[]arr, int position, int number)
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
        //because of how the node changes to the parent the program should run in about log base 3 or O(log n)
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
        int rightChild, middleChild, leftChild, temp;
        //because of how the node becomes the minimum child the program should run in about log base 3 or O(log n)
        while(node < currentIndex)
        {
            //These are the indexes of the children of our current node
            rightChild = (node + 1) *3;
            middleChild = rightChild - 1;
            leftChild = rightChild - 2;
            
            //These if statements check to see if they are min in there section and makes sure it is not taking info from the tail of zeros
            if(viableCheck(rightChild, currentIndex, node, arr) && ((arr[rightChild] < arr[middleChild] && arr[rightChild] < arr[leftChild])))
            {
                temp = arr[rightChild];
                arr[rightChild] = arr[node];
                arr[node] = temp;
                node = rightChild;
            }
            else if(viableCheck(middleChild, currentIndex, node, arr) && ((arr[middleChild] < arr[rightChild] && arr[middleChild] < arr[leftChild]) || (arr[middleChild] < arr[leftChild] && arr[rightChild] == 0)))
            {
                temp = arr[middleChild];
                arr[middleChild] = arr[node];
                arr[node] = temp;
                node = middleChild;
            }
            else if(viableCheck(leftChild, currentIndex, node, arr) && ((arr[leftChild] < arr[middleChild] && arr[leftChild] < arr[rightChild]) || (arr[rightChild] == 0 && arr[middleChild] == 0)))
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
    
    /*viable check makes sure the child isn't out of bounds
    * that it is less than the node we are currently on
    * and that it is not zeros because those values aren't in our heap just place holders 
    */
    
    private static boolean viableCheck(int child, int index, int node, int[] arr)
    {
        return child < index && (arr[node] > arr[child] && arr[child] != 0);
    }
    
}