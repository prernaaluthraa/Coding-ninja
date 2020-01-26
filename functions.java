package codingninja1;

import java.util.Scanner;

public class functions {
	/*public static int factorial(int n) {
		int ans = 1;
		for(int i=1; i<=n;i++) {
			ans=ans*i;
			
		}
		return ans;
	}
	
	public static void main(String[] args) {
		Scanner s= new Scanner(System.in);
		int n = s.nextInt();
		int r = s.nextInt();
		
		int num=factorial(n);
		int den1= factorial(r);
		int den2=factorial(n-r);
		
int ans= num /(den1*den2);
System.out.println(ans);
}
//function-black box which takes some input and gives out some output.
// public static (output type) function_name (input)
		
}
*/
	//For finding nCr-->
	
	public static int factorial(int n) {
	int ans = 1;
	for(int i=1; i<=n;i++) {
		ans=ans*i;
		
	}
	return ans;
}
public static boolean isPrime(int n) {
	int d=2;
	while(d<n)
	{
			if(n%d==0) {
				return false;
				
			}
			d++;
			
	}
	return true;
	
}
public static void printtillN(int n) {
	if(n<=0 ) {
		return;
	}
	for(int i = 1; i<=n; i++) {
		System.out.println(i);
		
	}
}

public static void main(String[] args) {
	Scanner s= new Scanner(System.in);
	int n = s.nextInt();
	int r = s.nextInt();
	
	boolean ansPrime = isPrime(13);
	System.out.println(ansPrime);
	
	
	int num=factorial(n);
	int den1= factorial(r);
	int den2=factorial(n-r);
	
int ans= num /(den1*den2);
System.out.println(ans);	
}
}
