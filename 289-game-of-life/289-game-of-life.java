class Solution {
    public void gameOfLife(int[][] a) {
        
        int n = a.length;
        int m = a[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
             int count = live(i,j,a);
                if((a[i][j]&1)>0  && count>=2 && count<=3){
                    a[i][j]=3;
                }
                if((a[i][j]&1)==0 && count==3 ){
                    a[i][j]=2;
                }
                
            }
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                a[i][j] = (a[i][j]&2)>0 ? 1:0 ;
            }
        }
        
    }
    
    public int live(int i,int j,int a[][]){
        int n = a.length;
        int m = a[0].length;
        int count = 0;
        if(i>0){
            if(j>0){
                if((a[i-1][j-1]&1)>0){
                    count++;
                }
               
            }
            if(j<m-1){
                if((a[i-1][j+1]&1)>0){
                    count++;
                }
            }
            if((a[i-1][j]&1)>0){
                count++;
            } 
        }
        if(i<n-1){
             if(j>0){
                if((a[i+1][j-1]&1)>0){
                    count++;
                }
               
            }
            if(j<m-1){
                if((a[i+1][j+1]&1)>0){
                    count++;
                }
            }
            if((a[i+1][j]&1)>0){
                count++;
            }       
        }
        if(j<m-1){
            if((a[i][j+1]&1)>0){
                count++;
            }
        }
        if(j>0){
            if((a[i][j-1]&1)>0){
                count++;
            }
        }
        
        return count;
        
    }
}