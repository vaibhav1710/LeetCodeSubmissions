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
    public TreeNode deleteNode(TreeNode root, int key) {
      root = delete(root,key);
        return root;
    }
    
    public TreeNode delete(TreeNode root , int key){
        
        if(root == null){
            return null;
        }
        
        if(root.val > key){
           root.left = delete(root.left , key);
        }
        else if(root.val < key){
           root.right = delete(root.right , key);
        }
        else{
            
            if(root.left==null){
                return root.right;
            }else if(root.right == null){
                return root.left;
            }else{
                TreeNode min = minValue(root.right);
                root.val = min.val;
               root.right = delete(root.right , min.val);
                return root;
            }   
        }
        return root;
        
    }
    
    public TreeNode minValue(TreeNode root){
        TreeNode min = root;
        if(root.left==null){
            return root;
        }else{
            min = root.left;
        }
        
        while(min.left!=null){
            min = min.left;
        }
        return min;
    }
    
}