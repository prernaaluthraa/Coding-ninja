package yayyy;

public class PrimeTwoToN {
	
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
	
	public static void printprimes(int n) {
		for(int i=2; i<=n; i++) {
			//need to check if i is prime or not
			boolean isPrime = isPrime(i);
			if(isPrime) {
				System.out.println(i);
			}
		}
	}
	
	public static void main(String[] args) {
		printprimes(100);
		System.out.println("100");
	}
}
	
//starts from main
//avoiding repetitions. higher readibility.
//good for testing.
	/*
public static int increment(int n) {
	n=n+1;
	return n;
}
public static void main(String[] args) {
	int a=10;
	a= increment(a);
	System.out.println(a);//updating a, withut doing this the value will have no change.
	
}

}
	*/