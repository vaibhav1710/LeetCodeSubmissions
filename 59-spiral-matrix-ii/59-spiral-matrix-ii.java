class Solution {
    public int[][] generateMatrix(int n) {
        
        int rmin=0;
        int cmin=0;
        int cmax = n-1;
        int rmax=n-1;
        
        int count=0;
        
        int tnt = n*n;
        int g[][]=new int[n][n];
        
        while(count<tnt){
            
            //1st row
            for(int j=cmin;j<=cmax && count<tnt;j++){
                count++;
                g[rmin][j] = count;
            }
            rmin++;
            
            //last col
            for(int i = rmin ;i<=rmax && count<tnt;i++){
                count++;
                g[i][cmax] = count;
            }
            cmax--;
            
            
            //last row
            for(int j=cmax;j>=cmin && count<tnt;j--){
                count++;
                g[rmax][j] =count;
            }
            rmax--;
            
            //first col
            for(int i=rmax;i>=rmin && count<tnt;i--){
                count++;
                g[i][cmin] = count;
            }
            cmin++;
            
            
        }
        return g;
    }
}