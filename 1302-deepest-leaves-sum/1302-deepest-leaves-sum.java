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
    public int deepestLeavesSum(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        int sum = 0;
        int ls = 0;
        
        while(q.size()>0){
            int s = q.size();
            while(s-->0){
              TreeNode pr = q.remove();
                sum += pr.val;
                if(pr.left!=null){
                    q.add(pr.left);
                }
                 if(pr.right!=null){
                    q.add(pr.right);
                }
            }
            ls = sum;
            sum = 0;      
        }
        return ls;
    }
}