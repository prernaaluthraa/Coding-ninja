package yayyy;

public class bubblesort {
     public static void bubblesort(int[] arr) {
    	
    	int temp=0;
    	 for(int i=0;i<arr.length-1;i++)//no.ofrounds
    	 {
    		 for(int j=0;j<arr.length-1;j++)//as starting from 0 evertime
    		 {
    			 if(arr[j]>arr[j+1])
    			 {
    				 temp=arr[j];
    				 arr[j]=arr[j+1];
    				 arr[j+1]=temp;
    			 }
    		 }
    	 }
     }
     public static void main(String[] args) {
    	 int arr[]= {2,5,8,1,9};
    	 bubblesort(arr);
    	 for(int i=0;i<arr.length;i++) {
    		 System.out.print(arr[i]+ " ");
    	 }
    		 
    	 
     }
}
