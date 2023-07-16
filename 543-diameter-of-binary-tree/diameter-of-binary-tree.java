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
         
        if(root==null){
            return 0;
        }
        
      //   int left = diameterOfBinaryTree(root.left);
     //   int right = diameterOfBinaryTree(root.right);
        
           //      int dia = Math.max(Math.max(left,right),height(root.left)+height(root.right)+2);  
      //  return dia;
        
        Pair res = dia2(root);
        return res.dia;
    }
    
 /*   public int h = -1;
    public int height(TreeNode root){
        if(root==null){
            return -1;
        }
        
        int left = height(root.left);
        int right = height(root.right);
        
           h = Math.max(left,right)+1;
        
        return h;
    }
 */   
    
    public Pair dia2(TreeNode root){
        if(root==null){
            Pair bp=new Pair();
            bp.dia = 0;
            bp.ht = -1;
            return bp;
        }
        
        Pair lf = dia2(root.left);
        Pair rf = dia2(root.right);
        
        Pair mp = new Pair();
        
        mp.dia = Math.max(lf.dia,Math.max( rf.dia, lf.ht + rf.ht + 2));
        mp.ht = Math.max(lf.ht,rf.ht)+1;
        
        return mp;
    }
}