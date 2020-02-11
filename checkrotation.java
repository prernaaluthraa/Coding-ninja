package yayyy;

public class checkrotation {
	public static int rotatecheck(int[] arr) {
		
		int min=arr[0];
		int min_index=0;
		for(int i=0;i<arr.length;i++)
		{
			if(min>arr[i])
			{
				min=arr[i];
				min_index=i;
			}
		}
		return min_index;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
int[] arr= {2,3,4,1,5,6};

System.out.print(rotatecheck(arr));
	

}
}