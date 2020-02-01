package yayyy;

import java.util.Scanner;

public class ArraySort01 {
	public static void sortBinaryArray(int[] arr) {
		int count=0;
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i]==0)
			{
				count++;
			}
		}
			for(int i=0;i<count;i++)
			{
			arr[i]=0;
		    }
			for(int i=count;i<arr.length;i++)
			{
				arr[i]=1;
			}
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

	public static void print(int[] arr){
		for(int i=0; i<arr.length; i++){
			System.out.print(+arr[i]+" ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		int[] arr = takeInput();
		sortBinaryArray(arr);
		print(arr);
	}
}
