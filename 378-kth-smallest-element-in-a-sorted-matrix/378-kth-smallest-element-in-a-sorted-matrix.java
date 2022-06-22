class Solution {
    public int kthSmallest(int[][] matrix, int k) {
      PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                q.add(matrix[i][j]);
            }
        }
        int val = -1;
        while(k-->0){
            val = q.remove();
        }
        return val;
    }
}