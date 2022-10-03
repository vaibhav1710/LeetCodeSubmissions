class Solution {
    public int minCost(String colors, int[] neededTime) {
        String s = colors;
        int max = neededTime[0];
        char curr=colors.charAt(0);
        int ans=0;
        int cnt=1;
        int sum=neededTime[0];
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)==curr){
                max = Math.max(max,neededTime[i]);
                cnt++;
                sum += neededTime[i];
                if(i==s.length()-1){
                    if(cnt>1){
                        ans += sum-max;
                    }
                }
            }else{
                    if(cnt>1){
                        ans += sum-max;
                    }
                    max = neededTime[i];
                    cnt=1;
                    sum =neededTime[i];
                    curr = s.charAt(i);
            }
        }
    return ans;
    }
}