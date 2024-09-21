/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
   long[] minl;
    long[] maxl;

    public int widthOfBinaryTree(TreeNode root) {
        int height = getHeight(root); // get the height of the tree
        minl = new long[height]; // initialize the array for minimum positions
        maxl = new long[height]; // initialize the array for maximum positions
        Arrays.fill(minl, Long.MAX_VALUE);
        Arrays.fill(maxl, Long.MIN_VALUE);
        dfs(root, 0, 0);
        long max = 0;

        for (int i = 0; i < height; i++) {
            max = Math.max(max, maxl[i] - minl[i] + 1);

        }
        return (int)max;
    }

    private void dfs(TreeNode node, int level, long pos) {
        if (node == null)
            return;

        if ( pos < minl[level]) // update the minimum position if needed
            minl[level] = pos;
        if ( pos > maxl[level]) // update the maximum position if needed
            maxl[level] = pos;
        dfs(node.left, level + 1, 2 * pos + 1);
        dfs(node.right, level + 1, 2 * pos + 2);
    }

    private int getHeight(TreeNode node) { // helper method to get the height of the tree
        if (node == null)
            return 0;
        return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
    }
}