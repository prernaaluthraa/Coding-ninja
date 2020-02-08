
public class PalindromeSubstrings
{
    public static int countPalindromeSubstrings(String s)
    {
        int n=s.length();
        int c=0;
        boolean table[][]=new boolean[n][n];
        int maxlen=1;
        for(int i=0;i<n;i++)
        {
            table[i][i]=true;
            c++;
        }
        int start=0;
        for(int i=0;i<n-1;i++)
        {
            if(s.charAt(i)==s.charAt(i+1))
            {
                table[i][i+1]=true;
                start=i;
                maxlen=2;
                c++;
            }
        }
        for(int k=3;k<=n;k++)
        {
            for(int i=0;i<n-k+1;i++)
            {
                int j=i+k-1;
                if(table[i+1][j-1] && s.charAt(i)==s.charAt(j))
                {
                    table[i][j]=true;
                    c++;
                    if(k>maxlen)
                    {
                        start=i;
                        maxlen=k;
                    }
                }
            }
        }
        return c;
    }

}
