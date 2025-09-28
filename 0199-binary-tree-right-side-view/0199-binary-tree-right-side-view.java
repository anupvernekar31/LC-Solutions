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

    // ========================================
    // RECURSIVE SOLUTION
    // ========================================
    public void printRight(TreeNode current,int  level, List<Integer> ans){
        if(current == null) {
            return;
        }
        if(level == ans.size()) {
            ans.add(current.val);
        }
        
        printRight(current.right, level+1, ans);
        printRight(current.left, level+1, ans);
        
    }
    
    public List<Integer> rightSideView(TreeNode root) {
        
        List<Integer>  ans = new ArrayList<Integer>();
        printRight(root, 0, ans);
        return ans;
        
    }

    // ========================================
    // ITERATIVE SOLUTION
    // ========================================
    // public List<Integer> rightSideView(TreeNode root) {
    //     List<Integer>  ans = new ArrayList<Integer>();
    //     if(root == null){
    //         return ans;
    //     }
    //     Queue<TreeNode> q = new LinkedList<>();
    //     q.add(root);
        

    //     while(!q.isEmpty()){
    //         int n = q.size();

    //         for(int i=1;i<=n;i++){
    //             TreeNode curr = q.poll();
    //             if(i==1)
    //                 ans.add(curr.val);

    //             if(curr.right!= null){
    //                 q.add(curr.right);
    //             }
    //             if(curr.left!=null){
    //                 q.add(curr.left);
    //             }
    //         }
    //     }
    //     return ans;
    // }
}