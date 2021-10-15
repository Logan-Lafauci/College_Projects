/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project7;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author logan
 */
public class Project7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] firstTest = new int[1000];
        int[] secondTest = new int[20000];
        int[] thirdTest = new int[100000];
        int[] finalTest = new int[200000];
        int[] backup1 = firstTest;
        int[] backup2 = secondTest;
        int[] backup3 = thirdTest;
        int[] backup4 = finalTest;
        long start;
        long timeTest1;
        long timeTest2;
        long timeTest3;
        long timeTest4;
        populateArray(firstTest);
        populateArray(secondTest);
        populateArray(thirdTest);
        populateArray(finalTest);
        
        //the backup array allows us to reuse the same random array for every test to make sure tests are fair
        backup1 = Arrays.copyOf(firstTest, firstTest.length);
        backup2 = Arrays.copyOf(secondTest, secondTest.length);
        backup3 = Arrays.copyOf(thirdTest, thirdTest.length);
        backup4 = Arrays.copyOf(finalTest, finalTest.length);
        
        System.out.println("-------------------------------------------------");
        System.out.printf("|%-15s|%-6s%-14s%-5s|%n", "", "", "Time in milliseconds", "");
        System.out.println("-------------------------------------------------");
        System.out.printf("|%-15s|%-7s|%-7s|%-7s|%-7s|%n", "Array length", "1,000", "20,000", "100,000", "200,000");
        
        //Here I am doing all of the test for the bubble sort method then diplaying the informatio
        start = System.currentTimeMillis();
        SortingAlgorithms.bubbleSort(firstTest);
        timeTest1 = System.currentTimeMillis() - start;
        firstTest = Arrays.copyOf(backup1, backup1.length);
        
        start = System.currentTimeMillis();
        SortingAlgorithms.bubbleSort(secondTest);
        timeTest2 = System.currentTimeMillis() - start;
        secondTest = Arrays.copyOf(backup2, backup2.length);
        
        start = System.currentTimeMillis();
        SortingAlgorithms.bubbleSort(thirdTest);
        timeTest3 = System.currentTimeMillis() - start;
        thirdTest = Arrays.copyOf(backup3, backup3.length);
        
        start = System.currentTimeMillis();
        SortingAlgorithms.bubbleSort(finalTest);
        timeTest4 = System.currentTimeMillis() - start;
        finalTest = Arrays.copyOf(backup4, backup4.length);
        
        System.out.printf("|%-15s|%-7d|%-7d|%-7d|%-7d|%n", "BubbleSort", timeTest1, timeTest2, timeTest3, timeTest4);
        
        //Here I am doing all of the test for the bubble sort CS method then diplaying the informatio
        start = System.currentTimeMillis();
        SortingAlgorithms.bubbleSortCS(firstTest);
        timeTest1 = System.currentTimeMillis() - start;
        firstTest =  Arrays.copyOf(backup1, backup1.length);
        
        start = System.currentTimeMillis();
        SortingAlgorithms.bubbleSortCS(secondTest);
        timeTest2 = System.currentTimeMillis() - start;
        secondTest = Arrays.copyOf(backup2, backup2.length);
        
        start = System.currentTimeMillis();
        SortingAlgorithms.bubbleSortCS(thirdTest);
        timeTest3 = System.currentTimeMillis() - start;
        thirdTest = Arrays.copyOf(backup3, backup3.length);
        
        start = System.currentTimeMillis();
        SortingAlgorithms.bubbleSortCS(finalTest);
        timeTest4 = System.currentTimeMillis() - start;
        finalTest = Arrays.copyOf(backup4, backup4.length);
        
        System.out.printf("|%-15s|%-7d|%-7d|%-7d|%-7d|%n", "BubbleSortCS", timeTest1, timeTest2, timeTest3, timeTest4);
        
        //Here I am doing all of the test for the selection sort method then diplaying the informatio
        start = System.currentTimeMillis();
        SortingAlgorithms.selectionSort(firstTest);
        timeTest1 = System.currentTimeMillis() - start;
        firstTest =  Arrays.copyOf(backup1, backup1.length);
        
        start = System.currentTimeMillis();
        SortingAlgorithms.selectionSort(secondTest);
        timeTest2 = System.currentTimeMillis() - start;
        secondTest = Arrays.copyOf(backup2, backup2.length);
        
        start = System.currentTimeMillis();
        SortingAlgorithms.selectionSort(thirdTest);
        timeTest3 = System.currentTimeMillis() - start;
        thirdTest = Arrays.copyOf(backup3, backup3.length);
        
        start = System.currentTimeMillis();
        SortingAlgorithms.selectionSort(finalTest);
        timeTest4 = System.currentTimeMillis() - start;
        finalTest = Arrays.copyOf(backup4, backup4.length);
        
        System.out.printf("|%-15s|%-7d|%-7d|%-7d|%-7d|%n", "SelectionSort", timeTest1, timeTest2, timeTest3, timeTest4);
        
        //Here I am doing all of the test for the insertion sort method then diplaying the informatio
        start = System.currentTimeMillis();
        SortingAlgorithms.insertionSort(firstTest);
        timeTest1 = System.currentTimeMillis() - start;
        firstTest =  Arrays.copyOf(backup1, backup1.length);
        
        start = System.currentTimeMillis();
        SortingAlgorithms.insertionSort(secondTest);
        timeTest2 = System.currentTimeMillis() - start;
        secondTest = Arrays.copyOf(backup2, backup2.length);
        
        start = System.currentTimeMillis();
        SortingAlgorithms.insertionSort(thirdTest);
        timeTest3 = System.currentTimeMillis() - start;
        thirdTest = Arrays.copyOf(backup3, backup3.length);
        
        start = System.currentTimeMillis();
        SortingAlgorithms.insertionSort(finalTest);
        timeTest4 = System.currentTimeMillis() - start;
        finalTest = Arrays.copyOf(backup4, backup4.length);
        
        System.out.printf("|%-15s|%-7d|%-7d|%-7d|%-7d|%n", "InsertionSort", timeTest1, timeTest2, timeTest3, timeTest4);
        
        //Here I am doing all of the test for the merge sort method then diplaying the informatio
        start = System.currentTimeMillis();
        SortingAlgorithms.mergeSort(firstTest);
        timeTest1 = System.currentTimeMillis() - start;
        firstTest =  Arrays.copyOf(backup1, backup1.length);
        
        start = System.currentTimeMillis();
        SortingAlgorithms.mergeSort(secondTest);
        timeTest2 = System.currentTimeMillis() - start;
        secondTest = Arrays.copyOf(backup2, backup2.length);
        
        start = System.currentTimeMillis();
        SortingAlgorithms.mergeSort(thirdTest);
        timeTest3 = System.currentTimeMillis() - start;
        thirdTest = Arrays.copyOf(backup3, backup3.length);
        
        start = System.currentTimeMillis();
        SortingAlgorithms.mergeSort(finalTest);
        timeTest4 = System.currentTimeMillis() - start;
        finalTest = Arrays.copyOf(backup4, backup4.length);
        
        System.out.printf("|%-15s|%-7d|%-7d|%-7d|%-7d|%n", "MergeSort", timeTest1, timeTest2, timeTest3, timeTest4);
        
        //Here I am doing all of the test for the quick sort method then diplaying the informatio
        start = System.currentTimeMillis();
        SortingAlgorithms.quickSort(firstTest, 0, firstTest.length - 1);
        timeTest1 = System.currentTimeMillis() - start;
        firstTest =  Arrays.copyOf(backup1, backup1.length);
        
        start = System.currentTimeMillis();
        SortingAlgorithms.quickSort(secondTest, 0, secondTest.length - 1);
        timeTest2 = System.currentTimeMillis() - start;
        secondTest = Arrays.copyOf(backup2, backup2.length);
        
        start = System.currentTimeMillis();
        SortingAlgorithms.quickSort(thirdTest, 0, thirdTest.length - 1);
        timeTest3 = System.currentTimeMillis() - start;
        thirdTest = Arrays.copyOf(backup3, backup3.length);
        
        start = System.currentTimeMillis();
        SortingAlgorithms.quickSort(finalTest, 0, finalTest.length - 1);
        timeTest4 = System.currentTimeMillis() - start;
        finalTest = Arrays.copyOf(backup4, backup4.length);
        
        System.out.printf("|%-15s|%-7d|%-7d|%-7d|%-7d|%n", "QuickSort", timeTest1, timeTest2, timeTest3, timeTest4);
        
        //Here I am doing all of the test for the merge sort method then diplaying the informatio
        start = System.currentTimeMillis();
        SortingAlgorithms.javaSort(firstTest);
        timeTest1 = System.currentTimeMillis() - start;
        firstTest =  Arrays.copyOf(backup1, backup1.length);
        
        start = System.currentTimeMillis();
        SortingAlgorithms.javaSort(secondTest);
        timeTest2 = System.currentTimeMillis() - start;
        secondTest = Arrays.copyOf(backup2, backup2.length);
        
        start = System.currentTimeMillis();
        SortingAlgorithms.javaSort(thirdTest);
        timeTest3 = System.currentTimeMillis() - start;
        thirdTest = Arrays.copyOf(backup3, backup3.length);
        
        start = System.currentTimeMillis();
        SortingAlgorithms.javaSort(finalTest);
        timeTest4 = System.currentTimeMillis() - start;
        finalTest = Arrays.copyOf(backup4, backup4.length);
        
        System.out.printf("|%-15s|%-7d|%-7d|%-7d|%-7d|%n", "JavaSort", timeTest1, timeTest2, timeTest3, timeTest4);
        
        //Here I am doing all of the test for the merge sort method then diplaying the informatio
        start = System.currentTimeMillis();
        SortingAlgorithms.yourSort(firstTest);
        timeTest1 = System.currentTimeMillis() - start;
        
        start = System.currentTimeMillis();
        SortingAlgorithms.yourSort(secondTest);
        timeTest2 = System.currentTimeMillis() - start;
        
        start = System.currentTimeMillis();
        SortingAlgorithms.yourSort(thirdTest);
        timeTest3 = System.currentTimeMillis() - start;
        
        start = System.currentTimeMillis();
        SortingAlgorithms.yourSort(finalTest);
        timeTest4 = System.currentTimeMillis() - start;
        
        System.out.printf("|%-15s|%-7d|%-7d|%-7d|%-7d|%n", "ShellSort", timeTest1, timeTest2, timeTest3, timeTest4);
        
        System.out.println("-------------------------------------------------");
    }
    
    public static void populateArray(int[] arr)
    {
        for(int i = 0; i < arr.length; i++)
        {
            Random r = new Random();
            arr[i] = r.nextInt(1001);
        }
    }
    
    
}
