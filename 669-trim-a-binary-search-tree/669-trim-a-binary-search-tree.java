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
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if(root == null){
            return null;
        }
         
       if(root.val < low){
           return trimBST(root.right , low, high);
       }
       if(root.val > high){
           return trimBST(root.left , low,high);
       }        
        
       root.left = trimBST(root.left , low,high);
       root.right = trimBST(root.right, low ,high);
        
        
        
        return root;
        
        
    }
    
    public TreeNode deleteRec(TreeNode root , int key){
        
        if(root.val > key){
            deleteRec(root.left,key);
        }
        else if(root.val < key){
            deleteRec(root.right , key);
        }else{
            
            if(root.right==null){
                return root.left;
            }else if(root.left==null){
                return root.right;
            }else{  
                root.val = minValue(root.right);
                root.right = deleteRec(root.right , root.val);
            }   
            
        }
        
        return root;
        
    }
    
    public int minValue(TreeNode root){
        
       int min = root.val;
        while(root.left!=null){
            min = root.left.val;
            root = root.left;
        }
        
        return min;
        
    }
}