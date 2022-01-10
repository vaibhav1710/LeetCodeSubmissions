class Solution {
    public boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }
        int check = x;
        int ans=0;
        while(x!=0){
            int r = x%10;
            ans = ans*10 + r;
            x /= 10;
        }
        return ans==check;
    }
}