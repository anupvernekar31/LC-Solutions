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

    // =========================================
    //  BRUTE FORCE
    // =========================================


    // public int countNodes(TreeNode root) {
    //     int c[] = new int[1];
    //     util(root, c);
    //     return c[0];
    // }

    // void util(TreeNode root, int[] c){
    //     if(root == null){
    //         return;
    //     }
    //     c[0]++;
    //     util(root.left, c);
    //     util(root.right, c);
        
    // }
    public int getLeftHeight(TreeNode root){
        int count = 0;
        while(root.left!=null){
            count++;
            root=root.left;
        }
        return count;
    }
    
    public int getRightHeight(TreeNode root){
        int count = 0;
        while(root.right!=null){
            count++;
            root=root.right;
        }
        return count;
    }
        
    public int countNodes(TreeNode root) {
        if(root == null){
            return 0;
            
        }
        
        int left = getLeftHeight(root);
        int right = getRightHeight(root);
        if(left == right){
            return (2<<left) -1;
        } else {
            return 1+ countNodes(root.left)+ countNodes(root.right);
        }
    }


}