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
    

    private void inorder(TreeNode node, int k, int[] res, int[] counter) {
        if (node == null) return;

        
        inorder(node.left, k, res, counter);

        counter[0]++;

        if (counter[0] == k) {
             res[0] = node.val;
            return ;
        }

        inorder(node.right, k ,res, counter);
    }
    public int kthSmallest(TreeNode root, int k) {
        int res[] = new int[]{Integer.MAX_VALUE};
        int counter[] = new int[]{0};
        inorder(root, k, res, counter);
        return res[0];
        
    }
}