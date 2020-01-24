package yayyy;

import java.util.Scanner;

public class Convertor {
	public static int Convert (int start, int end, int step) {
       int cel = 0;
       for(int i=start;i<=end;i=i+step)
       {
           cel=(int)((5.0/9)*(i-32));
              System.out.println(i+"\t"+cel); 
		
	}
		return cel;
		
	}
	
	


	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int start =s.nextInt();
		int end =s.nextInt();
		int step =s.nextInt();
		int ans= Convert( start,  end, step);
		
		
		
	}
}

