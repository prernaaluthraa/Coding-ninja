package yayyy;

import java.util.Scanner;

public class ArrayAssignment1 {
				
	public static int findUnique(int arr[]) {
		int res = 0; 
	    for (int i = 0; i < arr.length; i++) 
	        res = res ^ arr[i]; 
	    return res; 
			// We know that A XOR A = 0.
   // If we XOR all the elements in array,
	    //all the elements which are repeated twice will become 0 
	    //and remaining will the element which is appearing only once.
		}
	
	public static int[] takeInput() {
		Scanner s = new Scanner(System.in);
		int size = s.nextInt();
		int arr[] = new int[size];
		for (int i = 0; i < size; i++) {
			arr[i] = s.nextInt();
		}
		return arr;
	}
	
	public static void main(String[] args) {
		int[] arr = takeInput();
		System.out.print(findUnique(arr));
	}
}
