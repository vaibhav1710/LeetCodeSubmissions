class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        List<Integer> al = triangle.get(0);
        int dp[] = new int[1];
        dp[0] = al.get(0);
        for(int j=1;j<triangle.size();j++){
            al = triangle.get(j);
            int dp1[]= new int[al.size()];
            for(int i=0;i<al.size();i++){
                if(i==0){
                    dp1[i] += al.get(i)+dp[0];
                }else if(i==al.size()-1){
                    dp1[i] += al.get(i) + dp[dp.length-1];
                }else{
                    dp1[i] = al.get(i) + Math.min(dp[i],dp[i-1]);
                }
            }
            
            dp = dp1;
        }
        int max = Integer.MAX_VALUE;
        for(int i=0;i<dp.length;i++){
            max = Math.min(max,dp[i]);
        }
        return max;
    }
}