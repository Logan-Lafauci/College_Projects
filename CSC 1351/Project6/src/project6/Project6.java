package project6;

public class Project6 {


    public static void main(String[] args) {
        
        System.out.printf("%-10s%-15s%-15s%-10s\n", "x", "fib(x)", "Recursive(ns)", "Iterative(ns)");
        System.out.println("======================================================");
        
        //Add your code to calculate the Fibonacci number for the numbers {10, 20, .., 50} and generate the execution time table. 
        for(int i = 10; i <= 50; i += 10)
        {
            long start= System.nanoTime();
            Fibonacci.recursiveFib(i);
            long recursiveElapsed = System.nanoTime() - start;
            
            start = System.nanoTime();
            Fibonacci.iterativeFib(i);
            long iterativeElapsed = System.nanoTime() - start;
            
            System.out.printf("%-10d%-15d%-15d%-10d\n", i, Fibonacci.iterativeFib(i), recursiveElapsed, iterativeElapsed);
        }
	
        
                
        System.out.println("======================================================");
        
    }
}

