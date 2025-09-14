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
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(postorder.length == 0){
            return null;
        }
        int n = postorder.length;
        HashMap<Integer, Integer> InMap = new HashMap<Integer, Integer>();

        for(int i = 0;i<inorder.length;i++){
            InMap.put(inorder[i], i);
        }

        return buildTreeUtil(inorder, 0, n-1, postorder, 0, n-1, InMap);
        
    }

    public TreeNode buildTreeUtil(int inorder[], int inStart, int inEnd, int postorder[], int postStart, int postEnd, HashMap<Integer, Integer> InMap){
        if(postStart > postEnd || inStart > inEnd){
            return null;
        }

        TreeNode root = new TreeNode(postorder[postEnd]);
        int inRoot = InMap.get(root.val);
        int nums = inRoot - inStart;

        root.left = buildTreeUtil(inorder, inStart, inRoot-1, postorder, postStart, postStart+nums-1, InMap );
        root.right = buildTreeUtil(inorder, inRoot+1, inEnd, postorder, postStart + nums, postEnd-1, InMap );

        return root;
    }
}