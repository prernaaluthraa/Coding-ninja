import java.util.HashMap;
public class Solution {

    public static int maxFrequencyNumber(int[] arr){
        /* Your class should be named Solution
* Don't write main().
* Don't read input, it is passed as function argument.
* Return output and don't print it.
* Taking input and printing output is handled automatically.
*/

        HashMap<Integer,Integer> map=new HashMap();
        int max=1;
        int maxelem=arr[0];
        for(int i=0;i<arr.length;i++)
        {
            if(map.containsKey(arr[i]))
            {
                int freq=map.get(arr[i]);
                map.put(arr[i],freq+1);
            }
            else
                map.put(arr[i],1);

            int n=map.get(arr[i]);
            if(n>max)
            {
                max=n;
                maxelem=arr[i];
            }
        }
        return maxelem;
    }
}
