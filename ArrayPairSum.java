package yayyy;

import java.util.Scanner;

public class ArrayPairSum {
	public static void pairSum(int[] input, int x) {
		for(int i=0;i<input.length;i++)
		{
			for(int j=i+1;j<input.length;j++) {
				if (input[i]+input[j]==x)
				{
					if(input[i]<input[j])
					{
						System.out.println(input[i]+" "+ input[j]);
						
					}
					else
					{
						System.out.println(input[j]+" " +input[i]);
					}
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
		int[] input = takeInput();
		int x = s.nextInt();
		pairSum(input, x);
	}

}
