import java.util.HashMap;

public class Solution {
    public static void PairSum(int[] arr, int size) {

        /* Your class should be named Solution
* Don't write main().
* Don't read input, it is passed as function argument.
* Print the desired output and don't return anything.
* Taking input is handled automatically.
*/
        HashMap<Integer,Integer> map=new HashMap();
        for(int i=0;i<size;i++)
        {
            if(map.containsKey(arr[i]))
            {
                int f=map.get(arr[i]);
                map.put(arr[i],f+1);
            }
            else
                map.put(arr[i],1);
        }

        for(int i=0;i<size;i++)
        {
            int find = 0 - arr[i];
            if(find<0)
            {
                if(map.containsKey(find))
                {
                    for(int k=0;k<map.get(find);k++)
                    {
                        if(find<0)
                        {

                            System.out.print(find + " " + arr[i]);
                            System.out.println();
                        }
                        else
                        {

                            System.out.print( arr[i]+ " " +find );
                            System.out.println();
                        }
                    }
                }

            }
        }
    }
}
