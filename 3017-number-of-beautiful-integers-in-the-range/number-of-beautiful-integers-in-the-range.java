class Solution {
    int f(int i, boolean flag, int even, int odd, int rem, String s, Integer dp[][][][][], int k){
        if(i == s.length()){
            if(even == odd && rem == 0) return 1;
            else return 0;
        }
        if(dp[i][flag ? 1 : 0][even][odd][rem] != null) return dp[i][flag ? 1 : 0][even][odd][rem];
        int maxDigits = -1;
        if(flag){
            maxDigits = s.charAt(i)-'0';
        }
        else{
            maxDigits = 9;
        }
        int count = 0;
        for(int it = 0; it <= maxDigits; it++){
          int tempRem = Integer.valueOf(rem+""+it)%k;
          if(it%2 == 0){
           count += f(i+1, flag&&(it == s.charAt(i)-'0'), (even == 0 && odd == 0 && it == 0) ? even : even+1,
                                   odd, tempRem, s, dp, k);
          }
          else{
           count += f(i+1, flag && (it == s.charAt(i)-'0'), even, odd+1, tempRem, s, dp, k);
          }
        }
        return dp[i][flag ? 1 : 0][even][odd][rem] = count;
    }
    public int numberOfBeautifulIntegers(int low, int high, int k) {
        String s1 = (low-1)+"";
        Integer dp1[][][][][] = new Integer[s1.length()][2][11][11][21];
        int lowCount = f(0, true, 0, 0, 0, s1, dp1, k);
        String s2 = high+"";
        Integer dp2[][][][][] = new Integer[s2.length()][2][11][11][21];
        int highCount = f(0, true, 0, 0, 0, s2, dp2, k);
        return highCount-lowCount;
    }
}