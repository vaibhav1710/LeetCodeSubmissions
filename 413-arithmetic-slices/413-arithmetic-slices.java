class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        if(nums.length<3){
            return 0;
        }
        ArrayList<Integer> al = new ArrayList<>();
        int diff[] = new int[nums.length-1];
        for(int i=1;i<nums.length;i++){
            diff[i-1] = nums[i] - nums[i-1];
        }
        
        int count=2;
        int tar = diff[0];
        for(int i=1;i<diff.length;i++){
           
            if(tar==diff[i]){
                count++;
            }else{
                if(count>=3){
                    al.add(count);
                }
                tar = diff[i];
                count=2;
            }
                         
             if(i==diff.length-1){
                 if(count>2){
                     al.add(count);
                 }
             }            
        }
    
                         
          int ans = 0;
             for(int i=0;i<al.size();i++){
                 int c = al.get(i);
                 if(c==3){
                     ans++;
                 }else{
                     c = c - 2;
                     ans += ((c)*(c+1)) / 2 ;
                 }
             }   
            return ans;             
}
}