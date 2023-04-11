//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Geeks
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine().trim());
        
        while(t-- > 0)
        {
            String s[]=in.readLine().trim().split(" ");
            String a = s[0];
            String b = s[1];
            Solution g = new Solution();
            if(g.isScramble(a,b)){
                out.println("Yes");
            }
            else{
                out.println("No");
            }
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static HashMap<String,Boolean> hm = new HashMap<>();
    static boolean isScramble(String S1,String S2)
    {
         if(S1.length()!=S2.length()) return false;
        if(S1.equals(S2)) return true;
        if(S1.length()==1) return false;
        String key = S1+" "+S2;
        boolean flag = false;
        if(hm.containsKey(key)) return hm.get(key);
        for(int i=1;i<S1.length();i++){
            // great     // rgeat
            // gr / eat   // rg / eat
            // g/r        // r/g
            // g&r & r&g || (g&g && r&r)   
flag |= (isScramble(S1.substring(0,i),S2.substring(0,i)) && isScramble(S1.substring(i),S2.substring(i)));

 flag |= (isScramble(S1.substring(0,i),S2.substring(S1.length()-i)) && isScramble(S1.substring(i),S2.substring(0,S1.length()-i)));
          
        }

        hm.put(key,flag);
        return flag;
    }
}
