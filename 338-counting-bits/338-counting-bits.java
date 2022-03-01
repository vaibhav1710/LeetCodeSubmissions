class Solution {
    public int[] countBits(int n) {
        int a[] = new int[n+1];
        
        for(int i=0;i<n+1;i++){
         
            for(int j=0;j<=18;j++){
                if((i&(1<<j))>0){
                    a[i]++;
                }
            }
            
        }
  return a;
      
}
}