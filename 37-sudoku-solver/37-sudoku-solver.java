class Solution {
    public void solveSudoku(char[][] board) {
        
        solve(board);
      
    }
    
    public boolean solve(char[][] board){
       
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                
           
              if(board[i][j]=='.'){  
                for(char l='1';l<='9';l++){
                if(isValid(i,j,l,board)){
                    board[i][j] = l;
                    if(solve(board)){
                        return true;
                    }
                    board[i][j] = '.';    
                }
            }
              
            
     return false;
        }
        }
        }
 
           
        return true;
    }
    
    
    public boolean isValid(int r,int c,char v,char[][] board){
        
        for(int i=0;i<board.length;i++){
            if(i!=r && board[i][c]==v){
                return false;
            }
        }
        for(int i=0;i<board.length;i++){
            if(i!=c && board[r][i]==v){
                return false;
            }
        }
        
        int sc = c/3;
        sc *= 3;
        int sr = r/3;
        sr *= 3;
        
        for(int i=sc;i<sc+3;i++){
            for(int j=sr;j<sr+3;j++){
                if(i!=c && j!=r && board[j][i]==v){
                    return false;
                }
            }
        }
        return true;
    }
    
}