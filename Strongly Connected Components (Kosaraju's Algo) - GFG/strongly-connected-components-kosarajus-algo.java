//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Gfg
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            // arraylist of arraylist to represent graph
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            int V = Integer.parseInt(sc.next());
            int E = Integer.parseInt(sc.next());
            
            for(int i =0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
                
            for(int i = 1; i <= E; i++)
            {    int u = Integer.parseInt(sc.next());
                 int v = Integer.parseInt(sc.next());
                 
                 // adding directed edgese between 
                 // vertex 'u' and 'v'
                 adj.get(u).add(v);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.kosaraju(V, adj));
		}
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to find number of strongly connected components in the graph.
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        int n = adj.size();
       boolean vis[] = new boolean[n];
	    Stack<Integer> st = new Stack<>();
	    for(int i=0;i<n;i++){
	        if(!vis[i]){
	            dfs(i,adj,vis,st);
	        }
	    }
	    
	    // step 2 rg
	    ArrayList<ArrayList<Integer>> rg = new ArrayList<>();
	    //ArrayList<ArrayList<Integer> g = new ArrayList<>();
	    for(int i=0;i<n;i++){
	        rg.add(new ArrayList<>());
	    }
	    
	    for(int i=0;i<n;i++){
	        ArrayList<Integer> nbr = adj.get(i);
	        for(int v1:nbr){
	            rg.get(v1).add(i);
	        }
	    }
	    
	    // dfs in stack order
	    int ans=0;
	    vis = new boolean[n];
	    while(st.size()!=0){
	        int rem = st.pop();
	        if(!vis[rem]){
	            dfs1(rem,rg,vis);
	            ans++;
	        }
	    }
	   return ans;
    }
    
    	public void dfs1(int v,ArrayList<ArrayList<Integer>> g, boolean vis[]){
		    vis[v] = true;
		    ArrayList<Integer> nbr = g.get(v);
		    for(int vv:nbr){
		       if(!vis[vv]) dfs1(vv,g,vis);
		    }
		}
		
		public void dfs(int v, ArrayList<ArrayList<Integer>> g, boolean vis[], Stack<Integer> st){
		    vis[v] = true;
		    ArrayList<Integer> nbr = g.get(v);
		    for(int v1:nbr){
		        if(!vis[v1]){
		            dfs(v1,g,vis,st);
		        }
		    }
		    st.push(v);
		}

}
