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
    public TreeNode pruneTree(TreeNode root) {
       boolean ans = solve(root);
        return ans==true?root:null;
    }
    public  boolean solve(TreeNode root){
         
        if(root==null){
            return false;
        }
        
         boolean left = solve(root.left);
         boolean right = solve(root.right);
         
        if(!left){
            root.left = null;
        }
        if(!right){
            root.right = null;
        }
        if(right || left){
            return true;
        }
        if(root.val==1){
            return true;
        }
        
        return false;
    }
}