class Solution {
    public int minPathCost(int[][] grid, int[][] moveCost) {
        int m = grid.length;
        int n = grid[0].length;
        int dp[][] = new int[m][n];
        for (int i = 0; i < dp.length; i++) {
			Arrays.fill(dp[i],Integer.MAX_VALUE );
		}
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {

				if(i==0) {
					dp[i][j] = grid[i][j];
				} else {
					for (int k = 0; k < n; k++) {
						dp[i][j]=Math.min(dp[i][j], dp[i-1][k]+moveCost[grid[i-1][k]][j] + grid[i][j]);
					}
				}
			}
		}
        
		Arrays.sort(dp[m-1]);
		return dp[m-1][0];
    }
}