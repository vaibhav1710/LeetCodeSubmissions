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
    
  public int minCameraCover_helper(TreeNode root, int[] Cameras) {
    if(root == null) return 0;
    int leftSubtree = minCameraCover_helper(root.left, Cameras);
    int rightSubtree = minCameraCover_helper(root.right, Cameras);

    if(leftSubtree == -1 || rightSubtree == -1) {
        Cameras[0]++;
        return 1;
    }

    if(leftSubtree == 1 || rightSubtree == 1) return 0;

    return -1; 
} 

public int minCameraCover(TreeNode root) {
    int[] Cameras = new int[1];
    int answer = minCameraCover_helper(root, Cameras);
    if(answer == -1) Cameras[0]++;
    return Cameras[0];
}

}