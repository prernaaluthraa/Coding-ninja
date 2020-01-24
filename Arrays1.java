package yayyy;

import java.util.Scanner;


public class Arrays1 {
	
	
	public static int largestinArray(int arr[]) {
		int max = Integer.MIN_VALUE; //in the start, -infinity as the minimum value a array can store.
		for(int i=0;i<arr.length;i++) {
			if(arr[i]>max) {
				max=arr[i];//updated max
				
				
			}
		}
		return max;
	}

	public static int[] takeInput() {//indicates that this fuction will return an array
		Scanner s = new Scanner(System.in);
		int size=s.nextInt();//ask the size
		int arr[]=new int[size];//making array, size-specified by user
	//now taking the values-
		for( int i=0;i<size;i++) {
			arr[i]=s.nextInt();
	}
	return arr;
	}
	public static void print(int arr[]) {
	int size=arr.length;
	
		for(int i=0;i<size;i++) {
			System.out.print(arr[i] +" ");
			
		}
		
		
	}
	
	public static void main(String[] args) {
		//inserting at every values.
			
			int arr[]=takeInput();
			print(arr);
		int largest = largestinArray(arr);
		System.out.println("Largest "+ largest);
		
		
	
}
}

