package yayyy;

import java.util.Scanner;

public class ArraySwap {
	
public static void swapAlternate(int[] input) {
	int i=0;
	int b=0;
	long x=input.length;
	if(x%2==0)
	{
		while(i<x) {
			b=input[i];
			input[i]=input[i+1];
			input[i+1]=b;
			i=i+2;
		}
	}
	else { 
		while(i<x-1)
		{
			b=input[i];
			input[i]=input[i+1];
			input[i+1]=b;
			i=i+2;
		}
	
	
	}
}

	static Scanner s = new Scanner(System.in);
public static int[] takeInput(){
		
		int size = s.nextInt();
		int[] input = new int[size];
		for(int i = 0; i < size; i++){
			input[i] = s.nextInt();
		}
		return input;//Array made.
	}
	
	public static void main(String[] args) {
		
		int[] input = takeInput();
		swapAlternate(input);
		for(int i = 0; i < input.length; i++){
			System.out.print(input[i] +" ");
		}
		
	}

}


