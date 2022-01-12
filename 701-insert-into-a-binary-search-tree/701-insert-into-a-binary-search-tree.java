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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root==null){
            TreeNode r = new TreeNode(val,null,null);
            return r;
        }
        
        
        TreeNode x = root ;
        TreeNode par = root;
        boolean f = false;
        
        while(x!=null){
            
        if(x.val > val){
              par = x;
               x = x.left;
            f = false;
        }else{
             par = x;
            x = x.right;
            f = true;
        }
            
        }
        
        
        TreeNode node = new TreeNode(val,null,null);
        if(f){
            par.right = node;
        }else{
            par.left = node;
        }
        
        return root;
        
            
        
        
        
    }
}