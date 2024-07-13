class Solution {
    class Pair{
        int p;
        boolean f;
        Pair(int p, boolean f){
            this.p=p;
            this.f=f;
        }
    }
    public int numberOfSubmatrices(char[][] grid) {
        
        Pair g[][] = new Pair[grid.length][grid[0].length];
        
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                g[i][j] = new Pair(0,false);
                if(i==0 && j==0){
                    g[i][j].p = grid[i][j]=='X'?1:0;
                    if(grid[i][j]=='Y') g[i][j].p = -1;
                    
                    if(grid[i][j]=='X') g[i][j].f = true;
                    
                }else if(i==0 || j==0){
                    
                    if(grid[i][j]=='X') {
                        g[i][j].p = 1;
                        g[i][j].f = true;
                    }
                    if(grid[i][j]=='Y'){
                        g[i][j].p = -1;
                    }
                    
                    
                    if(i==0){
                        g[i][j].p += g[i][j-1].p;
                        g[i][j].f |= g[i][j-1].f;   
                    }else{
                         g[i][j].p += g[i-1][j].p;
                        g[i][j].f |= g[i-1][j].f; 
                    }
                    
                }else{
                    
                    if(grid[i][j]=='X') {
                        g[i][j].p = 1;
                        g[i][j].f = true;
                    }
                    if(grid[i][j]=='Y'){
                        g[i][j].p = -1;
                    }
                    
                    g[i][j].p += g[i-1][j].p;
                    g[i][j].p += g[i][j-1].p;
                    g[i][j].p -= g[i-1][j-1].p;
                    
                    g[i][j].f |= g[i][j-1].f;
                    g[i][j].f |= g[i-1][j].f;                     
                    
                }
                
            }
        }
        int ans = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(g[i][j].p==0 && g[i][j].f==true){
                    ans++;
                }
            }
        }
        
        return ans;
    }
}