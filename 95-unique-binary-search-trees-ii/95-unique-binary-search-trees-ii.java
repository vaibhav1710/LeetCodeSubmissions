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
    public List<TreeNode> generateTrees(int n) {
      
       return makeTree(1,n);
    }
    
    public List<TreeNode> makeTree(int l,int r){
        
         List <TreeNode> al = new ArrayList<TreeNode>();
        
         if(l>r) {
         al.add(null);
             return al;
         }
  
        if(l==r){
        al.add(new TreeNode(l));
            return al;
        }
        
        for(int i=l;i<=r;i++){
            
             List<TreeNode> left = makeTree(l,i-1);
              List<TreeNode> right = makeTree(i+1,r);
            
            for(TreeNode lnode:left){
                for(TreeNode rnode:right){
                    TreeNode root = new TreeNode(i);
                    root.left = lnode;
                    root.right = rnode;
                    al.add(root);
                }
            }
            
        }
        
    
        return al;
    }  
}