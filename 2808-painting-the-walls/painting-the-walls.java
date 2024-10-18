class Solution {
    HashMap<String,Integer> hm;
    public int paintWalls(int[] cost, int[] time) {
      hm = new HashMap<>();
      return solve(0,0,cost.length,cost, time);
    }  

    public int solve(int i, int ext, int n, int c[], int t[]){
        
        if(i==n && ext<0) return 1000000000;
        if(i==n && ext>0) return 0;
        if(ext > (n-i-1)) return 0;

        String f = i+"#"+ext;
        if(hm.containsKey(f)) return hm.get(f);
        
        int ans = 1000000000;
        ans = Math.min(ans, c[i] + solve(i+1, ext + t[i], n, c, t));
        ans = Math.min(ans, solve(i+1, ext-1, n, c, t));

        hm.put(f,ans);
        return ans;
    }
}