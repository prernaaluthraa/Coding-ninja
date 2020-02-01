package yayyy;

import java.util.Scanner;

public class ArrayLinearSearch {
	
	public static int findIndex(int arr[], int num) {
		int a=0;
		int b=0;
		int flag=0;
		for(int i=0;i<arr.length;i++)
		{
			if (num==arr[i])
			{
				flag=1;
				break;
				
			}
			else {
				flag=0;
			     }			
		}                   
		if(flag==1) 
		{
			a=b;
		}
		else {
			b=-1;
	         }
		return b;
	}

	/*
	public static int findIndex(int[] arr,int num) {
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i]==num)
			return i;
		}
		return -1;
		
	}*/
	static Scanner s = new Scanner(System.in);
public static int[] takeinputs() {
			
		
		int size=s.nextInt();
		int arr[]= new int[size];
		for(int i=0;i<size;i++){
			arr[i]=s.nextInt();
			
		}
		return arr;
	}
	
	public static void main(String[] args) {
		
		int[] arr= takeinputs();
		int num=s.nextInt();
		System.out.print(findIndex(arr,num));
	}
		
	
	
	
	
}
