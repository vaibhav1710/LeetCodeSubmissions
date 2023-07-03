//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0)
        {
            int N = sc.nextInt();
            int M[][] = new int[N][N];
            for(int i=0; i<N; i++)
            {
                for(int j=0; j<N; j++)
                {
                    M[i][j] = sc.nextInt();
                }
            }
            System.out.println(new Solution().celebrity(M,N));
            t--;
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java


class Solution
{ 
    //Function to find if there is a celebrity in the party or not.
    int celebrity(int M[][], int n)
    {
     Stack<Integer> st = new Stack<>();
     for(int i=0;i<n;i++) st.push(i);
     
     while(st.size()>=2){
         int a = st.pop();
         int b = st.pop();
         
         if(M[a][b] == 1 && M[b][a]==0) st.push(b);
         if(M[b][a]==1 && M[a][b]==0) st.push(a);
         if(M[b][a]==0 && M[a][b]==0) continue;
         if(M[b][a]==1 && M[a][b]==1) continue;
     }
     if(st.size()==1){
         int v= st.pop();
         for(int i=0;i<n;i++){
             if(i==v)continue;
             else{
                 if(M[v][i]==0 && M[i][v]==1) continue;
                 else return -1;
             }
         }
         return v;
     }else{
         return -1;
     }
    }
}