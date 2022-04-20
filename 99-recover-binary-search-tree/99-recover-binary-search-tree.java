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
    TreeNode pre;
    TreeNode first;
    TreeNode second;
    public void recoverTree(TreeNode root) {
        if(root==null){
            return;
        }
        pre = new TreeNode(Integer.MIN_VALUE);
        inorder(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
        
    }
    
    public void inorder(TreeNode root){
        if(root == null) return;
        
        inorder(root.left);
        
        if(first == null && pre.val>root.val){
            first = pre;
        }
        if(first!=null && pre.val>root.val){
            second = root;
        }
        pre = root;
        
        inorder(root.right);
        
    }
}