package yayyy;

import java.util.Scanner;

public class Array3 {
	
		public static int searchIndex(int x) {
			int n= arr.length;
			for(int i = 0; i < n; i++) 
		    { 
		        if(arr[i] == x) 
		            return i; 
		    } 
		    return -1; 
		}
        public static int[] takeInputss()
        {
        	Scanner s=new Scanner(system.in);
        	int size= s.nextInt();
        	int arr[]=new int[size];
        	
        	for(int i=0;i<size;i++)
        	{
        		arr[i]=s.nextInt();
        		
        	}
        }
        
        public static main(Strint[] args) {

            int result = searchIndex(x); 
            if(result == -1) 
                System.out.print("Element is not present in array"); 
            else
                System.out.print("Element is present at index " + result);
        }
}
