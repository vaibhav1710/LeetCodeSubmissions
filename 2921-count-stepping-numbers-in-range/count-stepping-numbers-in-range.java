class Solution {
      int mod = 1000000007;
    long[][][][]dp = new long[101][11][2][2];
    private void resetArray(){
        for(int i=0;i<101;i++){
            for(int j=0;j<11;j++){
                for(int k=0;k<2;k++){
                    Arrays.fill(dp[i][j][k],-1);
                }
            }
        }
    }
    private long solve(String num, int currIndex, int prevDigit, boolean tight, boolean isZero){
        if(num.length()==currIndex){
            return isZero?0:1;
        }

        if(dp[currIndex][prevDigit+1][isZero?1:0][tight?1:0]!=-1){
            return dp[currIndex][prevDigit+1][isZero?1:0][tight?1:0];
        }

        int limit = num.charAt(currIndex)-'0';
        if(!tight){
            limit = 9;
        }

        long ans = 0;
        for(int currDigit = 0;currDigit<=limit; currDigit++){
            boolean nextTight = tight && (currDigit==limit);
            boolean nextZero = isZero && (currDigit == 0);

            if(isZero ||(Math.abs(currDigit-prevDigit)==1)){
                ans += (solve(num, currIndex+1, currDigit, nextTight, nextZero))%mod;
            }
        }
        return dp[currIndex][prevDigit+1][isZero?1:0][tight?1:0] = ans;

    }
    public int countSteppingNumbers(String low, String high) {
       resetArray();
        long ans = solve(high, 0, -1, true, true);
        resetArray();
        ans -= solve(low, 0, -1, true, true);
        ans =  (ans+mod)%mod;

        boolean isLowValid = true;
        for(int i=1;i<low.length();i++){
            if(Math.abs(low.charAt(i)-low.charAt(i-1))!=1){
                isLowValid = false;
                break;
            }
        }
        ans = (ans + mod + (isLowValid?1:0))%mod;
        return (int)ans;
    }
}