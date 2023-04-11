//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


class FastReader{ 
    BufferedReader br; 
    StringTokenizer st; 

    public FastReader(){ 
        br = new BufferedReader(new InputStreamReader(System.in)); 
    } 

    String next(){ 
        while (st == null || !st.hasMoreElements()){ 
            try{ st = new StringTokenizer(br.readLine()); } catch (IOException  e){ e.printStackTrace(); } 
        } 
        return st.nextToken(); 
    } 

    String nextLine(){ 
        String str = ""; 
        try{ str = br.readLine(); } catch (IOException e) { e.printStackTrace(); } 
        return str; 
    }
    
    Integer nextInt(){
        return Integer.parseInt(next());
    }
} 
    
class GFG {
    public static void main(String args[]) throws IOException {
        FastReader sc = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        int t = sc.nextInt();
        while (t-- > 0) {
            int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt();
    
            Solution ob = new Solution();
            int ans = ob.solve(a, b, c);
            
            out.println(ans);
        }
        out.flush();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    int solve(int a, int b, int c) {
       int a1 = Math.max(a,Math.max(b,c));
       int sum = a+b+c;
       int left = sum-a1;
       if(a1>(2*left+2)){
           return -1;
       }else{
           StringBuilder sb = new StringBuilder();
           PriorityQueue<Pair> pq = new PriorityQueue<>();
             if(a>0){
             pq.add(new Pair('a',a));
             }if(b>0){
             pq.add(new Pair('b',b));
             }if(c>0){
             pq.add(new Pair('c',c));
             }
             char p = '?';
             char pl = '?';
             while(pq.size()>0){
                 Pair r = pq.remove();
                 if(p==r.c && pl==r.c){
                     Pair r1 = pq.remove();
                     pq.add(r);
                     r = r1;
                 }
                 sb.append(r.c);
                 pl = p;
                 p = r.c;
                 r.v -= 1;
                 if(r.v>0) pq.add(new Pair(r.c,r.v));
                 //pl = p;
             }
             return sb.toString().length();
       }
       
    }
    class Pair implements Comparable<Pair>{
        char c;
        int v;
        Pair(char c,int v){
            this.c=c;
            this.v=v;
        }
        public int compareTo(Pair o){
            return o.v - this.v;
        }
    }
};