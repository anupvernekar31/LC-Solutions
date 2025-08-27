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
    public List<List<Integer>> levelOrder(TreeNode root) {

        if(root == null)
            return new ArrayList<>();

        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        
        q.add(root);
        
        while(!q.isEmpty()){
            List<Integer> aa = new ArrayList<Integer>();
            int si = q.size();
            
            for(int i=0;i<si;i++) {
                TreeNode head = q.poll();
                aa.add(head.val);
            
                if(head.left!= null) {
                    q.add(head.left);
                }
                if(head.right!=null) {
                    q.add(head.right);
                }
            }
            ans.add(aa);
        }
        return ans;
        
    }
}