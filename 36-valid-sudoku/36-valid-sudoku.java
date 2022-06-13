class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i=0;i<board.length;i++){
            HashSet<Integer> h  = new HashSet<>();
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]=='.'){
                    continue;
                }else{
                    if(h.contains(board[i][j]-'0')){
                        return false;
                    }else{
                        h.add(board[i][j]-'0');
                    }
                }
            }
        }
        
         for(int i=0;i<board[0].length;i++){
            HashSet<Integer> h  = new HashSet<>();
            for(int j=0;j<board.length;j++){
                if(board[j][i]=='.'){
                    continue;
                }else{
                    if(h.contains(board[j][i]-'0')){
                        return false;
                    }else{
                        h.add(board[j][i]-'0');
                    }
                }
            }
        
         }
        
         for (int i = 0; i < board.length; i+= 3) {
            for (int j = 0; j < board[0].length; j+= 3) {
                // call function to check subgrids.
                if (!validSubgrid(board, i, j))
                    return false;
            }
        }   
        return true;
    }
    
       public boolean validSubgrid(char[][] board, int row, int col) {
        HashSet<Character> mySet = new HashSet<>();
        for (int i = row; i < row + 3; i++) {
            for (int j = col; j < col + 3; j++) {
                if (board[i][j] == '.') continue;
                if (mySet.contains(board[i][j]))
                    return false;
                mySet.add(board[i][j]);
            }
        }
       return true;
    }
}