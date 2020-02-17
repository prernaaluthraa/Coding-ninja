package yayyy;
import java.util.*;
public class wordwise2 {
	public static String wordwise(String input) {
		String a[]=input.split(" ");
		String str="";
		for(int i=a.length-1;i>=0;i--) {
			str=str+a[i]+ " ";
		}
		return str;
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String input=s.nextLine();
		System.out.print(wordwise(input));
	}
}
