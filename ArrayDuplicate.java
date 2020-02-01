package yayyy;

import java.util.Scanner;

public class ArrayDuplicate {
	
	public static int duplicate(int[] arr){
		int b=0;//in which we will store the duplicate elements
	
		int count=0;//no of times element occur
		
		for(int i=0;i<arr.length;i++)//to call every element once
		{
			count=1;//a no. exists atleast once
			for(int j=i+1;j<arr.length;j++)//counting once again
			{
				if(arr[i]==arr[j])
					{ 
					count++;
					}
				
			}
		
		if(count>1)
		{
			b=arr[i];
			
		}
		
	}
	return b;
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
		System.out.print(duplicate(arr));
	}
}
