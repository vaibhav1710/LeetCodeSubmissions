//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import java.math.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = Integer.parseInt(sc.next());
		while(t-- > 0)
		{
		    int n = Integer.parseInt(sc.next());
		    int k = Integer.parseInt(sc.next());
		    
		    String[] words = new String[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        words[i] = sc.next();
		    }
		    
		    Solution ob = new Solution();
		  //  System.out.println(T.findOrder(words,k));
		    String order = ob.findOrder(words,n,k);
		    if(order.length() == 0){
		        System.out.println(0);
		        continue;
		    }
		    String temp[] = new String[n];
		    for(int i=0;i<n;i++)
		        temp[i] = words[i];
		    
		    Arrays.sort(temp, new Comparator<String>(){
		    
		      @Override
                public int compare(String a, String b) {
                    int index1 = 0;
                    int index2 = 0;
                    for(int i = 0; i < Math.min(a.length(), b.length()) 
                                        && index1 == index2; i++) {
                        index1 = order.indexOf(a.charAt(i));
                        index2 = order.indexOf(b.charAt(i));
                    }
                
                    if(index1 == index2 && a.length() != b.length()) 
                    {
                        if(a.length() < b.length())
                            return -1;
                        else
                            return 1;
                    }
                
                    if(index1 < index2)
                        return -1;
                    else
                        return 1;
                        
                }
		    });
		    
		    int flag = 1;
		    for(int i=0;i<n;i++)
		    {
		        if(!words[i].equals(temp[i]))
	            {
	                flag = 0;
	                break;
	            }
		    }
		    
		    System.out.println(flag);
		}
	}
	
}

// } Driver Code Ends


//User function Template for Java

class Solution
{ 
    ArrayList<Integer> al[];
    public String findOrder(String [] dict, int N, int K)
    {
       al = new ArrayList[K];
       for(int i=0;i<K;i++) al[i] = new ArrayList<>();
       for(int l=1;l<dict.length;l++){
           String a = dict[l-1];
           String b = dict[l];
           int i=0;
           int j=0;
           while(i<a.length() && j<b.length()){
               if(a.charAt(i)==b.charAt(j)){
                   i++;
                   j++;
               }else{
                   if(!al[a.charAt(i)-'a'].contains(b.charAt(j)-'a')){
                   al[a.charAt(i)-'a'].add(b.charAt(j)-'a');
                   //break;
                   }
                   break;
               }
           }
       }
       return topo(K);
    }
     boolean vis[];
     Stack<Integer> st;
    public String topo(int v){
      st = new Stack<>();
      vis = new boolean[v];
      
      for(int i=0;i<v;i++){
          if(!vis[i]) dfs(i);
      }
      StringBuilder sb = new StringBuilder();
      while(st.size()!=0){
          sb.append((char)(st.pop()+'a'));
      }
      return sb.toString();
    }
    public void dfs(int node){
        vis[node] = true;
        for(int v:al[node]){
            if(!vis[v]) dfs(v);
        }
        st.push(node);
    }
    
}