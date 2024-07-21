class Solution {
    public long minimumOperations(int[] a, int[] b) {
        int n = a.length;
        int dif[] = new int[a.length];
        
        for(int i=0;i<n;i++){
            dif[i] = b[i]-a[i];
        }
        long ans = 0l;
        for(int i=0;i<n;i++){
            if(i==0) ans += Math.abs(dif[i]);
            else{
            int prev = b[i-1]-a[i-1];
            int curr = b[i] - a[i];
            
            if(prev>0){
                if(curr>0){
                    if(curr>prev) ans+= (curr-prev);
                }
                else  ans += Math.abs(curr);
            }else{
                if(curr<0){
                    if(curr<prev) ans += Math.abs(curr-prev);
                }
                else ans += curr;
            }
        }
            
        }
     return ans;
    }
}