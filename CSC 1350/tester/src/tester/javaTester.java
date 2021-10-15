package tester;

import java.util.Scanner;
public class javaTester {
	
		public static void main(String[] args){
			
			    int[][] test = { {5,7,9}, {5,8,3}, {10,11,3}};
			    
			    int[][] b = subMatrixSum(test, 2, 2);
			    
			    for(int i = 0; i <= 2; i++)
			    {
			    	for(int j = 0; j <= 2; j++)
			    	{
			    		System.out.print(b[i][j] + " ");
			    	}
			    	System.out.println();
			    }
		}
		
		static public void sortKArray(int[] arr, int k, int n)
		{
			//k is the space between values
			//n is the length of the index 
			//arr is the k sorted arr
			//minHeap is our min heap
			//index is used to keep track of changing the values of the arr we have
			
			for(int i = 0; i < k+1; i++)
			{
				minHeap.add(arr[i]);
			}
			
			int index = 0;
			for(int i = k+1; i < n; i++)
			{
				arr[index] = minHeap.extractMin();
				index++;
				minHeap.add(arr[i]);
			}
			
			for(int i = 0; i < k+1; i++)
			{
				arr[index] = minHeap.extractMin();
				index++;
			}
					
		}
		
		//find closest fore father
//		public int foreFather (int k1, int k2,node x)
//		{
//			int foreFatherNode;
//			if(k1 > x && k2 > x)
//			{
//				foreFather(k1, k2, x.right);
//			}
//			else if(k2 < x)
//			{
//				foreFather(k1, k2, x.left);
//			}
//			else if(k1 < x && k2 > x)
//			{
//				foreFatherNode = x;
//			}
//			return foreFatherNode;
//		}

		//subMatrixSum
//		static int[][] subMatrixSum(int[][] a, int k, int l)
//		{
//			int [][] arr = new int[k+1][l+1];
//			for(int i = 0; i <= k; i++)
//			{
//				for(int j = 0; j <= l; j++)
//				{
//					int sum = 0;
//					if(i > 0 && j > 0)
//					{
//						sum += arr[i][j-1];
//						sum -= arr[i-1][j-1];
//						sum += arr[i-1][j];
//					}
//					else if(i > 0)
//					{
//						sum += arr[i-1][j];
//					}
//					else if(j > 0)
//					{
//						sum += arr[i][j-1];
//					}
//					sum += a[i][j];
//					arr[i][j] = sum;
//				}
//			}
//			return arr;
//		}
		
		//
//		static String contiguousSum(int[] arr, int sumCheck)
//		{
//			int x = 0;
//			int y = 1;
//			int sum = arr[x] + arr[y];
//			while(y < arr.length - 1)
//			{
//				if(sum < sumCheck)
//				{
//					y++;
//					sum += arr[y];
//				}
//				else if(sum > sumCheck)
//				{
//					sum -= arr[x];
//					x++;
//				}
//				else
//				{
//					break;
//				}
//			}
//			if(sum == sumCheck) {return sumCheck + " is a contiguous sum between index " + x +" and " + y + ".";}
//			return sumCheck + " is not in the array given.";
//		}
		
		
//		 static int binSearchMax(int A[], int start, int end)
//		 {
//		     int mid;
//		     if (start < end && end - start >= 3)
//		     {
//		         mid = (start+end)/2;
//		         if ((A[mid] > A[mid + 1] && A[mid] > A[mid-1]) ) return A[mid]; 
//		 // this will return and check for the highest value
//		         else if (A[mid] > A[mid-1]) return binSearchMax(A,mid + 1,end);
//		 //this checks the value behind mid to make sure the values are still increasing
//		         else if(A[mid] < A[mid-1]) return binSearchMax(A,start,mid - 1);
//		 //Finally this checks to see if the array is decreasing then eliminates that side
//		     }
//		     else if(start <= end)
//		     {
//		    	 if(A[start] > A[end]) return A[start];
//		    	 else return A[end];
//		     }
//		     return -1;
//		 }

}
