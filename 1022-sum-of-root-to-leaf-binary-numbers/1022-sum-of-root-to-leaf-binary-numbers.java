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

  // The best learning was to know the conversion from binary to decimal , by multiplying by 2 to
  // the parents value and adding the binary value of node.


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

