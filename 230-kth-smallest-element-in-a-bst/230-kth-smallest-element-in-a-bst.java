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
    public int kthSmallest(TreeNode root, int k) {
      
            ArrayList<Integer> al1 = inorderTrans(root , new ArrayList<Integer>());
        return al1.get(k-1);
       
       
    }
    
    public ArrayList<Integer> inorderTrans(TreeNode root ,ArrayList<Integer> al){
        if(root==null){
            return al;
            
        }
        
        inorderTrans(root.left ,al);
        al.add(root.val);
        inorderTrans(root.right ,al);
        return al;
        
    }
}