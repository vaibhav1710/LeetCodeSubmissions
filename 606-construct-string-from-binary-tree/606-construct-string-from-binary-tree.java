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
    StringBuilder sb = new StringBuilder();
    public String tree2str(TreeNode root) {
        solve(root);
        String ans = sb.toString();
        return ans.toString();
    }
    public void solve(TreeNode root){
      
        sb.append(root.val);
        if(root.left==null && root.right==null){
            //sb.append(root.val);
            return;
        }else if(root.left==null && root.right!=null){
            sb.append("()");
            sb.append("(");
            solve(root.right);
            sb.append(")");
        }else if(root.left!=null && root.right==null){
            sb.append("(");
            solve(root.left);
            sb.append(")");
        }else{
            sb.append("(");
            solve(root.left);
            sb.append(")");
             sb.append("(");
            solve(root.right);
            sb.append(")");
        }
        
        return;
    }
}