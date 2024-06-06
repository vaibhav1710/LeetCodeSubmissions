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
    
    class Pair{
     int dia;
     int ht;
    }
    
    public int diameterOfBinaryTree(TreeNode root) {
        if(root.left==null && root.right==null) return 0;
        
        Pair ans = solve(root);
        return ans.dia;
        
        
    }
     
    public Pair solve(TreeNode root){
        if(root==null){
            Pair bp=new Pair();
            bp.dia = 0;
            bp.ht = -1;
            return bp;
        }
        
        Pair lf = solve(root.left);
        Pair rf = solve(root.right);
        
        Pair mp = new Pair();
        
        mp.dia = Math.max(lf.dia,Math.max( rf.dia, lf.ht + rf.ht + 2));
        mp.ht = Math.max(lf.ht,rf.ht)+1;
        return mp;
    }
    
}