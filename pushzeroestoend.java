package yayyy;

public class pushzeroestoend {
	public static void pushZeroestoend(int[] arr) {
		int a=0;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]!=0)
			{
				arr[a]=arr[i];
				a++;
			}
		}
		while(a<arr.length) {
			arr[a]=0;
			a++;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
int arr[]= {1,0,2,3,0,5,0,6};
pushZeroestoend(arr);
for(int i=0;i<arr.length;i++)
{
	System.out.println(arr[i]+" ");
}
	}

}
