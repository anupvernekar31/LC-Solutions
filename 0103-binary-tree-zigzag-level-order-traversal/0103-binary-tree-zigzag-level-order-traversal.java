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
// class Solution {
//     public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
//         List<List<Integer>> res = new LinkedList<List<Integer>>();
//         spiralPrint(root, res);
//         return res;
//     }
//     public static void spiralPrint(TreeNode root,List<List<Integer>> res )
//     {
 
//         // Declare a deque
//         Deque<TreeNode> dq = new ArrayDeque<>();
//         if (root == null)
//             return;
 
//         // Insert the root of the tree into the deque
//         dq.offer(root);
 
//         // Create a  variable that will switch in each
//         // iteration
//         boolean reverse = false;
 
//         // Start iteration
//         while (!dq.isEmpty()) {
 
//             // Save the size of the deque here itself, as in
//             // further steps the size of deque will
//             // frequently change
//             int n = dq.size();
//             List<Integer> ans = new ArrayList<Integer>();
 
//             // If we are printing left to right
//             if (!reverse) {
 
//                 // Iterate from left to right
//                 while (n-- > 0) {
 
//                     // Insert the child from the back of the
//                     // deque Left child first
//                     if (dq.peekFirst().left != null)
//                         dq.offerLast(dq.peekFirst().left);
 
//                     if (dq.peekFirst().right != null)
//                         dq.offerLast(dq.peekFirst().right);
//                     ans.add(dq.peekFirst().val);
 
//                     // Print the current processed element
//                     System.out.print(dq.pollFirst().val
//                                      + "  ");
                    
//                 }
//                 // Switch reverse for next traversal
//                 reverse = !reverse;
//                 res.add(ans);
//             }
//             else {
 
//                 // If we are printing right to left
//                 // Iterate the deque in reverse order and
//                 // insert the children from the front
//                 while (n-- > 0) {
//                     // Insert the child in the front of the
//                     // deque Right child first
//                     if (dq.peekLast().right != null)
//                         dq.offerFirst(dq.peekLast().right);
 
//                     if (dq.peekLast().left != null)
//                         dq.offerFirst(dq.peekLast().left);
//                     ans.add(dq.peekLast().val);
//                     // Print the current processed element
//                     System.out.print(dq.pollLast().val
//                                      + "  ");
//                 }
//                 // Switch reverse for next traversal
//                 reverse = !reverse;
//                 res.add(ans);
//             }
//         }
//     }
// }

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
    if (root == null) {
        return result;
    }

    Queue<TreeNode> nodesQueue = new LinkedList<>();
    nodesQueue.add(root);
    boolean leftToRight = true;

    while (!nodesQueue.isEmpty()) {
        int size = nodesQueue.size();
        List<Integer> row = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            TreeNode node = nodesQueue.poll();

            if (leftToRight) {
                row.add(node.val);
            } else {
                row.add(0, node.val);
            }

            if (node.left != null) {
                nodesQueue.add(node.left);
            }
            if (node.right != null) {
                nodesQueue.add(node.right);
            }
        }

        leftToRight = !leftToRight;
        result.add(row);
    }

    return result;
    }
    
}