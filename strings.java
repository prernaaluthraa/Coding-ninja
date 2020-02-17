package yayyy;

import java.util.Scanner;

public class strings {
	public static int countwords(String str) {
		int count=0;
		for(int i=0;i<str.length();i++)
		{
			if(str.charAt(i)==' ')
			{
				count++;
			}
			else
				continue;
		}
		return count;
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String str=s.nextLine();
		System.out.println(countwords(str));
	}
}
