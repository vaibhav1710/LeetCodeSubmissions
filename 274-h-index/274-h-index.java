class Solution {
    public int hIndex(int[] citations) {
        bit = new long[1001];
         int m = 1001;
        int n = citations.length;
         int ans=0;
         for(int i=0;i<n;i++) {
             if(citations[i]==0){
                 continue;
             }
        	 update(m,citations[i],1);
        	 if(citations[i] > ans){
        		 long x = sum(m-1) - sum(ans);
        		 if(x>=(ans+1)) {
        			 ans++;
        		 }
        	 }
        	
         }
         return ans;
    }
     long bit[]; // '1' index based array

    public  void update(int n,int i,int x){
    for(;i<n;i+=(i&(-i))){
    bit[i] += x;
    }
    }
    public  long sum(int i){
    long sum=0;
    for(;i>0 ;i -= (i&(-i))){
    sum += bit[i];
    }
    return sum;
    }
}