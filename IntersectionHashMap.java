
import java.util.HashMap;
public class Intersection{

    public static void intersection(int[] arr1, int[] arr2){
        HashMap<Integer,Integer> map=new HashMap();
        int n=arr1.length;
        int m=arr2.length;
   


        for(int i=0;i<n;i++)
        {
            if(map.containsKey(arr1[i]))
            {
                int freq=map.get(arr1[i]);
                map.put(arr1[i],freq+1);
            }
            else
                map.put(arr1[i],1);
        }
        for(int i=0;i<m;i++)
        {
            if(map.containsKey(arr2[i]))
            {
                int f=map.get(arr2[i]);
               
           
                    System.out.println(arr2[i]);
                    map.put(arr2[i],f-1);
               
                if(f-1==0)
                {
                    map.remove(arr2[i]);
                }
            }
        }

    }
}


