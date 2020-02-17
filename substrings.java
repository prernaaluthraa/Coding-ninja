package yayyy;

public class substrings {
	public static void substr(String str) {
		for(int i=0;i<str.length();i++) {
			System.out.println(str.substring(0,i));
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str="abcde";
		substr(str);
	}

}
