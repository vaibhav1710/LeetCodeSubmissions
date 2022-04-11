class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
     
        List<List<Integer>> al = new ArrayList<>();
        for(int i=0;i<grid.length;i++){
            al.add(new ArrayList<>());
        }
        int n = grid.length;
        int m = grid[0].length;
        int tot = n*m;
        k = k%tot;
        // m --> np. of column because , we can get (i,j) of any 
        // index by using , i = id/m , j = id%m , even when 
        // no. of rows != no. of coloumns
        for(int i =0;i<tot;i++){
            int id = (i+tot-k)%tot;
            al.get(i/m).add(grid[id/m][id%m]);
        }
        
        return al;
    }
}