package yayyy;

public class rotateArray {
	public static void rotate(int[] inputArray,int n) {
		int temp;
        
        for (int i = 0; i < n; i++)
        {
            temp = inputArray[0];
             
            for (int j = 0; j < inputArray.length-1; j++) 
            {
                inputArray[j] = inputArray[j+1];
            }
             
            inputArray[inputArray.length - 1] = temp;
        } 


	}
	
	public static void main(String[] args) {
		int inputArray[]= {1,2,3,4,5,6,7};
		int n=3;
		rotate(inputArray,n);
		for(int i=0;i<inputArray.length;i++) {
			System.out.println(inputArray[i]+ " ");
		}
		}
}
