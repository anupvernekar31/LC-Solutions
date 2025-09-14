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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0){
            return null;
        }
        int n = preorder.length;
        HashMap<Integer, Integer> InMap = new HashMap<Integer, Integer>();

        for(int i = 0;i<inorder.length;i++){
            InMap.put(inorder[i], i);
        }

        return buildTreeUtil(inorder, 0, n-1, preorder, 0, n-1, InMap);
        
    }

    public TreeNode buildTreeUtil(int inorder[], int inStart, int inEnd, int preorder[], int preStart, int preEnd, HashMap<Integer, Integer> InMap){
        if(preStart > preEnd || inStart > inEnd){
            return null;
        }

        TreeNode root = new TreeNode(preorder[preStart]);
        int inRoot = InMap.get(root.val);
        int nums = inRoot - inStart;

        root.left = buildTreeUtil(inorder, inStart, inRoot-1, preorder, preStart+1, preStart+nums, InMap );
        root.right = buildTreeUtil(inorder, inRoot+1, inEnd, preorder, preStart + nums+1, preEnd, InMap );

        return root;
    }
}