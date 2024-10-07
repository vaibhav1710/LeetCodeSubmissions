class Solution {
    public int minSubarray(int[] a, int p) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        
        int n = a.length;
        int sum = 0;
        int ans = Integer.MAX_VALUE;

        for(int i=0;i<n;i++){
            sum += a[i];
            sum %= p;
        }
         
         int rtm = sum;

         if(rtm==0) return 0;
         
         sum = 0;
         
         for(int i=0;i<n;i++){
             
             sum += a[i];
             int mod = sum%p;
             sum = mod;

             int cmod = (mod+p-rtm)%p;

             if(hm.containsKey(cmod)) ans = Math.min(ans, i - hm.get(cmod));
             if (cmod == 0) ans = Math.min(ans, i+1);

             hm.put(mod,i); 
         }
         if(ans==Integer.MAX_VALUE || ans == n){
            return -1;
         }else return ans;

    }
}