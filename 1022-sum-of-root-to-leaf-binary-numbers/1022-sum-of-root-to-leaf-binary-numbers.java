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
    public int sumRootToLeaf(TreeNode root) {
       
        int ans = dfs(root,0);
         return ans;
    }
    
    public static int dfs(TreeNode root , int val){
        if(root==null) return 0;
        
      val = val*2 + root.val;
        
     return (root.left==null && root.right==null)? val : dfs(root.left,val)+dfs(root.right,val) ;
        
    }
    
}

