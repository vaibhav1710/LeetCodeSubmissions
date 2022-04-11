class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        
        ArrayList<Integer> al = new ArrayList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                al.add(grid[i][j]);
            }
        }
        
        int a[] = new int[grid.length*grid[0].length];
        int n  = a.length;
        for(int i=0;i<al.size();i++){
            int v = al.get(i);
            a[(i+k)%n] = v;
        }
        
        List<List<Integer>> al1 = new ArrayList<>();
        n = grid[0].length;
        
        int m = grid.length;
        int i=0;
        while(m-->0){
            al = new ArrayList<>();
            n = grid[0].length;
        while(n-->0){
            al.add(a[i]);
            i++;
        }
        al1.add(al);    
        }
           
        return al1;
    }
}