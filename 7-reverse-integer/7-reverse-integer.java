class Solution {
    public int reverse(int x) {
        long ans=0;
        //2,147,483,648
        long tmp = Math.abs(x);
        while(tmp>0){
            ans = ans*10;
            ans += (tmp%10);
            tmp /= 10;
        }
        if(x<0){
            ans *= -1l;
        }
       
        long neg = -2147483648;
         long pos = 2147483647;
        
            if(x<0){
                if(ans<neg){
                    return 0;
                }else{
                    return (int)ans;
                }
            }
        if(x>0){
                if(ans>pos){
                    return 0;
                }else{
                    return (int)ans;
                }
            }
        return 0;
            
    }
}