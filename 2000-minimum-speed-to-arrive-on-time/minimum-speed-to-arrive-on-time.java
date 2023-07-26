class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        int l=1;
        int r = 10000000;
        int ans=-1;
        while(l<=r){
            int mid = (l+r)/2;
            if(check(mid,hour,dist)){
                ans = mid;
                r = mid-1;
            }else{
                l = mid+1;
            }
        }
       return ans;
    }
    public boolean check(int s, double h, int [] dist){
        double curr = 0.00;
        for(int i=0;i<dist.length-1;i++){
             curr += Math.ceil(dist[i]/1.0/s);
        }
        curr += (dist[dist.length-1]/1.00)/s;
        return curr<=h; 
    }
}