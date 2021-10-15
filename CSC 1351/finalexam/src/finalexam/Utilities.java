//Name: Logan Lafauci
//LSU ID: 892431322
//As a Louisiana State University student I will conduct myself with honor and integrity at all times. I will not lie, cheat, or steal, nor will I accept the actions of those who do.

package finalexam;

import java.io.*; 
import java.util.*; 

public class Utilities {
    
    //20 points: complete the sortNames method by implementing Bubble Sort. 
    //You are not allowed to use any of Java sorting utilities such as Arrays.sort() or Collections.sort()
    //Remember, Strings can be compared using the compareTo method
    public static void SortNames(String[] names)
    {
       for(int i = 0; i < names.length-1; i++)
        {
            for(int j = 0; j < names.length-i-1; j++)
            {
                if(names[j+1].compareTo(names[j]) < 0)
                {
                    String temp = names[j];
                    names[j] = names[j+1];
                    names[j+1] = temp;
                }
            }
        }
    }
    
    //20 points: complete Binary Search method to search for names. 
    //You should implement Binary Search Algorithm for strings. You are not allowed to use Java search utilities 
    //Remember, Strings can be compared using the compareTo method
    public static int BinarySearchNames(String[] names, String target)
    {
        int min = 0;
        int max = names.length - 1;
        int retVal = -1;
        while (min <= max)
        {
            int mid = (min + max) / 2;
            if (names[mid].compareTo(target) < 0) 
            {
                min = mid + 1;
            }
            else if (names[mid].compareTo(target) > 0)
            {
                max = mid - 1;
            }
            else if (names[mid].compareTo(target) == 0)
            {
                retVal = mid;
                break;
            }
        }
        return retVal;
    }
    
    //20 points: complete isPalendrome method. 
    //You are allowed to use any implementation, recursive, using stacks, or iterative  
    public static boolean isPalendrome(String input) 
    {         
        String tester = input.toLowerCase();
        Stack<String>reverse = new Stack<>();
        String reversed = "";
        for(int i = 0; i < tester.length(); i++)
        {
            reverse.push(tester.substring(i, i+1));
        }
        for(int i = 0; i < tester.length(); i++)
        {
            reversed += reverse.pop();
        }
        
        return reversed.equals(tester);
    }

    
     
    //20 points: complete reverseName method that takes a String name as input and reverses it. For example "Nash" would be returned as "hsaN". 
    public static String reverseName(String name)
    {
        Stack<String>reverse = new Stack<>();
        String reversed = "";
        for(int i = 0; i < name.length(); i++)
        {
            reverse.push(name.substring(i, i+1));
        }
        for(int i = 0; i < name.length(); i++)
        {
            reversed += reverse.pop();
        }
        return reversed; 
    }
    
    //20 points: Complete the method nameToHex to return the Hexadecimal code of the input name. 
    //You are not allowed to use Java's Hexadecimal code generator.  
    public static String nameToHex(String name)
        {
               char[] chars = name.toCharArray();
               
               //Loading the MAP with the hexadecimal codes of each character in the alphabet
			   Map<Character, String> hexCodes = new TreeMap<>(); 
               hexCodes.putAll(loadHexMap());
               
               //Your code goes here. Get the Hexadecimal code (value) of each character (key) from the map and accumulate them in a string.
               String hex = "";
               
               for(char key: chars)
               {
                   hex += hexCodes.get(key);
               }

               return hex; 
        }
    
    
    //----------------------------- END OF EXAM QUESTIONS------------------------------------------------------------------------// 
     //A method which loads a map of each letter and its equivalent hexadecimal code 
    public static Map<Character, String> loadHexMap()
        {
            Map<Character, String> hexCodes = new TreeMap<>(); 
                hexCodes.put('a', "61"); 
                hexCodes.put('b', "62"); 
                hexCodes.put('c', "63"); 
                hexCodes.put('d', "64"); 
                hexCodes.put('e', "65"); 
                hexCodes.put('f', "66"); 
                hexCodes.put('g', "67"); 
                hexCodes.put('h', "68"); 
                hexCodes.put('i', "99"); 
                hexCodes.put('j', "6A"); 
                hexCodes.put('k', "6B"); 
                hexCodes.put('l', "6C"); 
                hexCodes.put('m', "6D"); 
                hexCodes.put('n', "6E"); 
                hexCodes.put('o', "6F"); 
                hexCodes.put('p', "70"); 
                hexCodes.put('q', "71"); 
                hexCodes.put('r', "72"); 
                hexCodes.put('s', "73"); 
                hexCodes.put('t', "74"); 
                hexCodes.put('u', "75"); 
                hexCodes.put('v', "76"); 
                hexCodes.put('w', "77"); 
                hexCodes.put('x', "78"); 
                hexCodes.put('y', "79"); 
                hexCodes.put('z', "7A");     
                hexCodes.put('A', "41"); 
                hexCodes.put('B', "42"); 
                hexCodes.put('C', "43"); 
                hexCodes.put('D', "44"); 
                hexCodes.put('E', "45"); 
                hexCodes.put('F', "46"); 
                hexCodes.put('G', "47"); 
                hexCodes.put('H', "48"); 
                hexCodes.put('I', "49"); 
                hexCodes.put('J', "4A"); 
                hexCodes.put('K', "4B"); 
                hexCodes.put('L', "4C"); 
                hexCodes.put('M', "4D"); 
                hexCodes.put('N', "4E"); 
                hexCodes.put('O', "4F"); 
                hexCodes.put('P', "50"); 
                hexCodes.put('Q', "51"); 
                hexCodes.put('R', "52"); 
                hexCodes.put('S', "53"); 
                hexCodes.put('T', "54"); 
                hexCodes.put('U', "55"); 
                hexCodes.put('V', "56"); 
                hexCodes.put('W', "57"); 
                hexCodes.put('X', "58"); 
                hexCodes.put('Y', "59"); 
                hexCodes.put('Z', "5A"); 
                                
                return hexCodes;
                
        }

   
    //For your convenience, a method to print the content of a String array
    public static void printArray(String[] arr)
    {
        for(String a: arr)
            System.out.println(a);
    }
    
    //A method to load the content of an arrayList in a String Array
    public static String[] GetStringArray(ArrayList<String> arr) 
    { 
  
        String str[] = new String[arr.size()]; 
  
        for (int j = 0; j < arr.size(); j++) { 
            str[j] = arr.get(j); 
        } 
  
        return str; 
    } 
    
    //Load the names from the file names into an arrayList
    public static ArrayList<String> loadNames() throws FileNotFoundException
    {
        File inputFile = new File("names.txt"); 
        Scanner in = new Scanner(inputFile); 
        
        ArrayList<String> names = new ArrayList<>(); 
        
        while(in.hasNext())
            names.add(in.next()); 
            
        return names; 
    }
    
}
