


public class Solution {

    public static String breakWords(String input){
        /* Your class should be named Solution
* Don't write main().
* Don't read input, it is passed as function argument.
* Return output and don't print it.
* Taking input and printing output is handled automatically.
*/
//         String result="";
//         int end=0;
//         int i=0;
//         int space =0;
//         int split=0;
//             while(i<=input.length()-1){
//                 if(input.charAt(i)==' ')
//                 {
//                     space = i;
//                     if(space %2!=0)
//                     {
//                          end=space;
//                         result= result + input.substring(split,end/2) +
" " + input.substring(end/2,end);
//                     }
//                    split=space+1;
//                 }
//                 i++;


//             }

// return result;





        String words[]=input.split(" ");
        String s="";
        int j=0;
        for(int i=0;i<words.length;i++){
            int len=words[i].length();

            if(len%2==0 && len>=4){
                String input1=words[i];
                int k=len/2;

                s+=input1.substring(0,k)+" "+input1.substring(k,len)+" ";
