class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        

        int l=0;
        int r = (matrix.length*matrix[0].length)-1;
        int f=0;
        while(l<=r){
            int mid = (l+r)/2;
        if(matrix[mid/matrix[0].length][mid % matrix[0].length]>target){
                r = mid-1;  
        }else if(matrix[mid / matrix[0].length][mid % matrix[0].length]<target){
                l = mid+1;
        }else{
                return true;
        }

        }
        return false;
       // return matrix[f/matrix[0].length][f%matrix.length]==target;
    }
}