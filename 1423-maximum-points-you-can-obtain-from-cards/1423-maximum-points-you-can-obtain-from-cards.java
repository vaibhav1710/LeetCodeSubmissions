class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int sum = 0;
        int curs = 0;
        int n = cardPoints.length;
        for(int i=0;i<cardPoints.length;i++){
         sum += cardPoints[i];
            if(i == (n-k-1)){
                curs = sum;
            }
        }
        int ans = sum-curs;
         int i=0;  // i = 0
        int j = n-k; // j = 3-1 = 2
        
        while(j<cardPoints.length){
            ans = Math.max(ans , sum-curs);
            curs += cardPoints[j];
            curs -= cardPoints[i];
            j++;
            i++;
            
        }
        ans = Math.max(ans,sum-curs);
        return ans;
    }
}
        
        