package yayyy;

import java.util.Scanner;

public class ArrayIntersection {
	public static void intersections(int arr[],int arr2[])  {
		
		for(int i=0;i<arr.length;i++)
	    {
	        for(int j=0;j<arr2.length;j++)
	        {
	            if(arr[i]==arr2[j])
	            {
	                
	                System.out.println(arr[i]);
	                break;
	            }
	        }
	    }
}

	
		 static Scanner s = new Scanner(System.in);
	   public static int[] takeInput() {
			int size = s.nextInt();
			int arr[] = new int[size];
			for (int i = 0; i < size; i++) {
				arr[i] = s.nextInt();
			}
			return arr;
		}
		
		public static void main(String[] args) {
			int[] arr1 = takeInput();
			int[] arr2 = takeInput();
			intersections(arr1, arr2);
		}
}