/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
*/

package project7;
import java.util.*;
/**
 *
 * @author logan
 */
public class SortingAlgorithms {
    
    public static void bubbleSort(int[] arr)
    {
        for(int i = 0; i < arr.length-1; i++)
        {
            for(int j = 0; j < arr.length-i-1; j++)
            {
                if(arr[j+1] < arr[j])
                {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
    
    public static void bubbleSortCS(int[] arr)
    {
        for(int i = 0; i < arr.length-1; i++)
        {
            boolean shortCircut = false;
            for(int j = 0; j < arr.length-i-1; j++)
            {
                if(arr[j+1] < arr[j])
                {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    shortCircut = true;
                }
            }
            if(!shortCircut)
                break;
        }
    }
    
    public static void selectionSort (int[] arr)
    {
        for(int i = 0; i < arr.length; i++)
        {
            int index = i;
            for(int j = i+1; j < arr.length; j++)
            {
                if(arr[j] < arr[index])
                {
                    index = j;
                }
            }
            int min = arr[index];
            arr[index] = arr[i];
            arr[i] = min;
        }
    }
    
    public static void insertionSort(int[] arr)
    {
        for(int i = 1; i < arr.length; i++)
        {
            int j = i - 1;
            int key = arr[i];
            while(j >= 0 && arr[j] > key)
            {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
    }
    
    public static void mergeSort(int[] arr)
    {
        if(arr.length < 2)
        {
            return;
        }
        int mid = arr.length / 2;
        int[] l = new int[mid];
        int[] r = new int[arr.length - mid];

        for(int i = 0; i < mid; i++)
        {
            l[i] = arr[i];
        }

        for(int i = mid; i < arr.length; i++)
        {
            r[i - mid] = arr[i];
        }
          
        mergeSort(l);
        
        mergeSort(r);
        
        merge(arr, l, r, mid, arr.length - mid);
    }
    
        private static void merge (int[] arr, int[] l, int[] r, int left, int right)
        {
            int i = 0;
            int j = 0;
            int k = 0;
            while(i < left && j < right)
            {
                if(l[i] < r[j])
                {
                    arr[k] = l[i];
                    i++;
                }
                else
                {
                    arr[k] = r[j];
                    j++;
                }
                k++;
            }
            
            while( i < left)
            {
                arr[k++] = l[i++];
            }
            while( j < right)
            {
                arr[k++] = r[j++];
            }
        }
    
    public static void quickSort(int[] arr, int begin, int end)
    {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);

            quickSort(arr, begin, partitionIndex-1);
            quickSort(arr, partitionIndex+1, end);
        }
    }
    
    private static int partition(int arr[], int begin, int end) 
    {
        int pivot = arr[end];
        int i = (begin-1);

        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;

                int swapTemp = arr[i];
                arr[i] = arr[j];
                arr[j] = swapTemp;
            }
        }

        int swapTemp = arr[i+1];
        arr[i+1] = arr[end];
        arr[end] = swapTemp;

        return i+1;
    }
    
    public static void javaSort(int[] arr)
    {
        Arrays.sort(arr);
    }
    
    public static void yourSort(int[] arr)
    {
        int n = arr.length;
        
        for (int gap = n / 2; gap > 0; gap /= 2) 
        {
            for (int i = gap; i < n; i++) 
            {
                int key = arr[i];
                int j = i;
                while (j >= gap && arr[j - gap] > key) 
                {
                    arr[j] = arr[j - gap];
                    j -= gap;
                }
                arr[j] = key;
            }
        }
    }
}
