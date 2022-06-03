class NumMatrix {
 private int mymat[][];
    public NumMatrix(int[][] matrix) {
      mymat = matrix;
         for(int i = 0; i<mymat.length; i++){
            for(int j = 1; j<mymat[0].length; j++){
                matrix[i][j] = matrix[i][j-1]+matrix[i][j];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum=0;
        for(int i=row1;i<=row2;i++){
            if(col1>0){
                sum += mymat[i][col2]-mymat[i][col1-1];
            }else{
                sum += mymat[i][col2];
            }
        }
        return sum;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */