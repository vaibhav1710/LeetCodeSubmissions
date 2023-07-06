//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] str = br.readLine().trim().split(" ");
            int N = Integer.parseInt(str[0]);
            int M = Integer.parseInt(str[1]);
            int[][] matrix = new int[N][M];
            for(int i=0; i<N; i++)
            {
                String[] s = br.readLine().trim().split(" ");
                for(int j=0; j<M; j++)
                    matrix[i][j] = Integer.parseInt(s[j]);
            }
            
            Solution obj = new Solution();
            System.out.println(obj.closedIslands(matrix, N, M));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int closedIslands(int[][] matrix, int N, int M)
    {
        int ans=0;
        boolean vis[][] = new boolean[N][M];
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(!vis[i][j] && matrix[i][j]==1){
                    if(dfs(i,j,vis,matrix)) ans++;
                }
            }
        }
        return ans;
    }
    
    public boolean dfs(int i, int j, boolean vis[][], int [][] g){
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i,j});
        vis[i][j] = true; 
        boolean ans = true;
        while(q.size()!=0){
            int a[] = q.remove();
           
            if(a[0]==0 || a[0]==(g.length-1) || a[1]==0 || a[1]==g[0].length-1) ans = false;
            
            if(a[0]+1<g.length && !vis[a[0]+1][a[1]]  && g[a[0]+1][a[1]]==1){
                if((a[0]+1)==(g.length-1)){
                    ans = false;
                } 
                    q.add(new int[]{a[0]+1,a[1]});
                    vis[a[0]+1][a[1]] = true;
            }
            
             if(a[1]+1<g[0].length && !vis[a[0]][a[1]+1]  && g[a[0]][a[1]+1]==1){
                if((a[1]+1)==(g[0].length-1))  {ans = false;}
                    q.add(new int[]{a[0],a[1]+1});
                     vis[a[0]][a[1]+1] = true;
                }
                
             if(a[0]-1>=0 && !vis[a[0]-1][a[1]]  && g[a[0]-1][a[1]]==1){
                if((a[0]-1)==(0)) {ans = false;}
                    q.add(new int[]{a[0]-1,a[1]});
                     vis[a[0]-1][a[1]] = true;
                 }
                 
             if(a[1]-1>=0 && !vis[a[0]][a[1]-1]  && g[a[0]][a[1]-1]==1){
                if((a[1]-1)==(0))  {ans = false;}
                    q.add(new int[]{a[0],a[1]-1});
                     vis[a[0]][a[1]-1] = true;
             }
            
        }
        return ans;
    }
}