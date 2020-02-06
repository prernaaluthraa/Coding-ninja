package DataStructure;
import java.util.*;

public class ImportantQuestion {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	
        int n = sc.nextInt();
        ArrayList<Integer> al = new ArrayList<>();
        
        for(int i=1;i<=n;i++)
        {
            String name = sc.next() + sc.nextLine();
            String str[] = name.split(" ");
            
            for(int j=0;j<str.length;j++)
            {
                 al.add(Integer.parseInt(str[j]));
            }
            
        }
        Collections.sort(al);
        for(int j=0;j<al.size();j++)
        {
            System.out.print(al.get(j) + " ");
        }
		
	}

}
