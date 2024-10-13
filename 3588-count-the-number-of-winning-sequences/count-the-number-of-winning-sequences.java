class Solution {
      private static final int MOD = 1_000_000_007;

    // Creature codes for easier comparison
    private static final int FIRE = 0;
    private static final int WATER = 1;
    private static final int EARTH = 2;

    private String s;  // Alice's sequence
    private int n;      // Number of rounds

    // DP array to store results: dp[i][prevBob][bobPoints + n]
    private int[][][] dp;

    public int countWinningSequences(String s) {
        this.s = s;
        this.n = s.length();
        // Initialize the DP array with -1 (meaning not computed yet)
        dp = new int[n][3][2 * n + 5];
        for (int[][] matrix : dp) {
            for (int[] row : matrix) {
                Arrays.fill(row, -1);
            }
        }
        // Start the recursion from round 0 with no previous Bob creature (-1) and 0 points
        return dfs(0, -1, n);
    }

    // Recursive function to explore all possible sequences for Bob.
    private int dfs(int i, int prevBob, int bobPoints) {
        // Base case: If we reach the end of all rounds, return 1 if bobPoints > 0, else 0
        if (i == n) {
            return bobPoints > n ? 1 : 0;
        }

        

        // If the result is already computed, return it
        if (prevBob != -1 && dp[i][prevBob][bobPoints] != -1) {
            return dp[i][prevBob][bobPoints];
        }

        int result = 0;
        int aliceCreature = getCreatureCode(s.charAt(i));  // Get Alice's creature for this round

        // Explore all 3 possible creatures Bob can summon, ensuring it's not the same as the previous one
        for (int bobCreature = 0; bobCreature < 3; bobCreature++) {
            if (bobCreature == prevBob) continue;  // Skip if same as the previous round

            // Calculate new points for Bob based on the outcome
            int newBobPoints = bobPoints;
            if (winsAgainst(bobCreature, aliceCreature)) {
                newBobPoints++;  // Bob wins
            } else if (winsAgainst(aliceCreature, bobCreature)) {
                newBobPoints--;  // Bob loses
            }
            // If it's a draw, newBobPoints stays the same

            // Recurse to the next round
            result = (result + dfs(i + 1, bobCreature, newBobPoints)) % MOD;
        }

        // Store the result in the DP array (if prevBob is -1, we skip storing)
        if (prevBob != -1) {
            dp[i][prevBob][bobPoints] = result;
        }
        return result;
    }

    // Helper function to map character to creature code
    private int getCreatureCode(char c) {
        return switch (c) {
            case 'F' -> FIRE;
            case 'W' -> WATER;
            case 'E' -> EARTH;
            default -> -1;
        };
    }

    // Helper function to determine if creature1 beats creature2
    private boolean winsAgainst(int creature1, int creature2) {
        return (creature1 == FIRE && creature2 == EARTH) ||
               (creature1 == WATER && creature2 == FIRE) ||
               (creature1 == EARTH && creature2 == WATER);
    }

}