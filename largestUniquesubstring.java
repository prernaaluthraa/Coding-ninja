
import java.util.*;
public class solution {

    public static String findLargestUniqueSubstring(String str){

        String s="";
        int osi=0;
        int ose=0;
        int l=Integer.MIN_VALUE;
      //  HashMap<Character, Integer> mapp = new HashMap<Character,
Integer>();

        int j;
        for(int i=0;i<str.length();i++){
            HashMap<Character, Integer> mapp = new HashMap<Character,
Integer>();
            j=i;
            while(j<str.length()){
                if(mapp.containsKey(str.charAt(j))){
                    break;
                }else{

                    mapp.put(str.charAt(j),0);
                    j++;
                }
            }
            if(l<mapp.size()){
                osi= i;
                ose= j;
                l=mapp.size();
            }


        }

        for(int i=osi;i<ose;i++){
            s+=str.charAt(i);
        }
        return s;
    }

}
