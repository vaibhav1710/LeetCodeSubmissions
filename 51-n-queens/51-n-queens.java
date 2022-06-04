class Solution {
    List<List<String>> al;
    public List<List<String>> solveNQueens(int n) {
       
        char[][] c = new char[n][n];
         this.al = new ArrayList<>(); 
        solve(c,n,0);
         
        return al;
    }
    
    public void solve(char [][] c, int n, int r){
        
        if(r>=n){
           
        List<String> ll = new ArrayList();
        for(int i=0;i<n;i++){
            StringBuilder sb = new StringBuilder();
            for(int j=0;j<n;j++){
                if(c[i][j]=='Q'){
                    sb.append("Q");
                }else{
                    sb.append(".");
                }
            }
            ll.add(sb.toString());
        }
        al.add(ll);       
            return;
        }
        
        
        for(int i=0;i<n;i++){
            
            if(issafe(r,i,c)){
                c[r][i] = 'Q';
                
                solve(c,n,r+1);
                
                c[r][i] = '.';
                
            }
            
            
        }
        
        return;
    }
    
    public boolean issafe(int r,int col,char [][] c){
        
        int n = c.length;
        // left daigonal
        
        int i = r-1;
        int j = col-1;
        
        while(i>=0 && j>=0){
            if(c[i][j]=='Q'){
                return false;
            }
            i--;
            j--;
        }
        
        
        
        
        // right daigonal
        
        i = r-1;
        j = col+1;
        
        while(i>=0 && j<n){
            if(c[i][j]=='Q'){
            return false;    
            }
            i--;
             j++;
        }
        
        
        // up
        
        i = r-1;
        j = col;
        
        while(i>=0){
            if(c[i][j] == 'Q'){
                return false;
            }
            i--;
        }
        
        
        // same l
        
        i = r;
        j = 0;
        
        while(j<n){
            if(c[i][j] == 'Q' && j!=col){
                return false;
            }
            j++;
        }
        
        return true;
    }
    
}