
package route;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Route {

    
    public static void main(String[] args) throws FileNotFoundException
    {
        File input = new  File("airports.txt");
        Scanner in = new Scanner(input);
        
        Vertex[] heapArray = new Vertex[1000];
        Vertex[] hashArray = new Vertex[1000];
        
        int numCommands = in.nextInt();
        int amountInHeap = numCommands - 1;
        
        for(int i = 0; i < numCommands; i++)
        {
            String airport = in.next();
            int position = hashFunc(airport);
            if(hashArray[position] == null)
                hashArray[position] = new Vertex(airport);
            else
            {
                while(hashArray[position] != null)
                {
                    position++;
                    if(position >= hashArray.length)
                    {
                        position = 0;
                    }
                }
                hashArray[position] = new Vertex(airport);
            }
            hashArray[position].hashPos = position;
            heapArray[i] = hashArray[position];
            heapArray[i].heapPos = i;
            
        }
        
        input = new File("flights.txt");
        in = new Scanner(input);
        
        numCommands = in.nextInt();
        in.nextLine();
        in.nextLine();
        
        for(int i = 0; i < numCommands; i++)
        {
            Edge flight = new Edge(in.next(), in.nextInt(), in.next(), in.next(), in.nextInt(), in.nextInt(), in.nextInt());
            int hashPos = getVertex(hashArray, flight.origin);
            Edge next = hashArray[hashPos].adjList;
            if(next == null)
            {
                hashArray[hashPos].adjList = flight;
            }
            else
            {
                while(next.next != null)
                {
                    next = next.next;
                }
                next.next = flight;
            }
            
        }
        
        //TESTERS
        String start = "BTR";
        String end = "PVD";
        
        int startPosition = getVertex(hashArray, start);
        decreaseKey(heapArray,hashArray[startPosition].heapPos, 0);
        
        Vertex extracted = null;
        while(extracted == null || !extracted.airport.equals(end))
        {
            extracted = extractMin(heapArray, amountInHeap);
            amountInHeap--;
            
            //below was a tester i used to make sure heap property was being followed
            //System.out.println(extracted.parent + " " + extracted.airport + " " + extracted.dvalue);
            
            Edge flight = extracted.adjList;
            while(flight != null)
            {
                if(extracted.dvalue <= flight.departTime)
                {
                    int position = getVertex(hashArray, flight.dest);

                    if(hashArray[position].dvalue > flight.arrivalTime)
                    {
                        decreaseKey(heapArray, hashArray[position].heapPos, flight.arrivalTime);
                        int originPos = getVertex(hashArray, flight.origin);
                        hashArray[position].parent = hashArray[originPos].airport;
                    }
                }
                flight = flight.next;
            }
        }
        
        printRoute(extracted, hashArray);
        System.out.println((int)extracted.dvalue);
    }
    
    static class Vertex
    {
        public String airport, parent;
        public int heapPos, hashPos;
        public double dvalue = Double.POSITIVE_INFINITY;
        Edge adjList;
                
        public Vertex(String airport)
        {
            this.airport = airport;
        }
    }
    
    static class Edge
    {
        public String origin, dest, airlines;
        public int flightNum, departTime, arrivalTime, distance;
        Edge next;
        
        public Edge(String airlines, int flightNum, String origin, String dest, int departTime, int arrivalTime, int distance)
        {
            this.airlines = airlines;
            this. flightNum = flightNum;
            this.origin = origin;
            this.dest = dest;
            this.departTime = departTime;
            this.arrivalTime = arrivalTime;
            this.distance = distance;
        }
    }
    
    public static int hashFunc(String airport)
    {
        int p0 = (int) airport.charAt(0)-'A'+1;
        int p1 = (int) airport.charAt(1)-'A'+1;
        int p2 = (int) airport.charAt(2)-'A'+1;
        
        int p3 = p0*467*467+p1*467+p2;
        
        int p4 = p3%7193;
        
        return p4%1000;
    }
    
    private static void decreaseKey(Vertex[] arr, int position, int number)
    {
        arr[position].dvalue = number;
        floatUp(arr, position);
    }
    
    private static Vertex extractMin(Vertex[] arr, int nodeAmount)
    {
        Vertex min = arr[0];
        arr[0] = arr[nodeAmount];
        arr[0].heapPos = 0;
        arr[nodeAmount] = null; 
        sinkDown(arr, nodeAmount);
        return min;
    }
    
    private static void floatUp(Vertex[] arr, int currentIndex)
    {
        int node = currentIndex;
        int parent;
        Vertex temp;
        while (node != 0)
        {
            switch(node%2)
            {
                case 0:
                    parent = node/2 - 1;
                    if(arr[node].dvalue < arr[parent].dvalue)
                    {
                        arr[parent].heapPos = node;
                        arr[node].heapPos = parent;
                        temp = arr[parent];
                        arr[parent] = arr[node];
                        arr[node] = temp;
                        node = parent;
                    }
                    else{node = 0;}
                    break;
                case 1:
                    parent = (node+1)/2 - 1;
                    if(arr[node].dvalue < arr[parent].dvalue)
                    {
                        arr[parent].heapPos = node;
                        arr[node].heapPos = parent;
                        temp = arr[parent];
                        arr[parent] = arr[node];
                        arr[node] = temp;
                        node = parent;
                    }
                    else{node = 0;}
                    break;
            }
        }
    }
    
    private static void sinkDown(Vertex[] arr, int currentIndex)
    {
        int node = 0;
        int rightChild, leftChild;
        Vertex temp;
        while(node < currentIndex)
        {
            //These are the indexes of the children of our current node
            rightChild = (node + 1) *2;
            leftChild = rightChild - 1;
            
            //These if statements check to see if they are min in there section and makes sure it is not taking info from the tail of zeros
            if((arr[rightChild] != null) && (arr[node].dvalue > arr[rightChild].dvalue && arr[rightChild].dvalue <= arr[leftChild].dvalue))
            {
                arr[rightChild].heapPos = node;
                arr[node].heapPos = rightChild;
                temp = arr[rightChild];
                arr[rightChild] = arr[node];
                arr[node] = temp;
                node = rightChild;
            }
            else if((arr[rightChild] == null && arr[leftChild] != null) || (arr[leftChild] != null &&(arr[leftChild].dvalue < arr[node].dvalue && arr[leftChild].dvalue <= arr[rightChild].dvalue)))
            {
                arr[leftChild].heapPos = node;
                arr[node].heapPos = leftChild;
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
    
    public static int getVertex(Vertex[] arr, String airportCode)
    {
        int hashPos = hashFunc(airportCode);
        while(!arr[hashPos].airport.equals(airportCode))
        {
            hashPos++;
            if(hashPos >= arr.length)
            {
                hashPos = 0;
            }
        }
        return hashPos;
    }
    
    public static void printRoute(Vertex v, Vertex[] arr)
    {
        if(v.parent != null)
        {
            int position = hashFunc(v.parent);
            while(!arr[position].airport.equals(v.parent))
            {
                position++;
                if(position >= arr.length)
                {
                    position = 0;
                }
            }
            Vertex w = arr[position];
            printRoute(w, arr);
        }
        
        System.out.print(v.airport + "-");
    }
}
