class Solution {
    public long maximumTotalSum(int[] a) {
        Arrays.sort(a);
        long ans = 0;
        int min = a[a.length-1];
        HashSet<Integer> h = new HashSet<>();
        for(int i=a.length-1;i>=0;i--){
           if(!h.contains(a[i])){
             h.add(a[i]);
             ans += a[i];
             min = a[i]-1;
           }
           else{
             a[i] = Math.min(a[i],min);
             while(h.contains(a[i]) && a[i]>0) {
                a[i]--;
             }

             if(a[i]==0) {
                return -1;
             }
             ans += a[i];
             h.add(a[i]);
             min = a[i];
           }
        }
        return ans;
    }
}