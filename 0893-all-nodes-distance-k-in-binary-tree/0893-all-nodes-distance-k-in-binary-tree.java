/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public void getParents(TreeNode root, HashMap<TreeNode, TreeNode> parents){
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            if(curr.left!=null){
                q.add(curr.left);
                parents.put(curr.left, curr);
            }
            if(curr.right!=null){
                q.add(curr.right);
                parents.put(curr.right, curr);
            }
        }
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

        HashMap<TreeNode, TreeNode> parents = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        HashMap<TreeNode, Boolean> visited = new HashMap<>();
        getParents(root, parents);
        q.add(target);
        visited.put(target, true);
        int curr_level =0;

        while(!q.isEmpty()){
            int size = q.size();
            if(curr_level == k){
                break;
            }
            curr_level++;

            for(int i=0;i<size;i++){
                TreeNode curr = q.poll();
                if(curr.left!=null && visited.get(curr.left) == null){
                    q.add(curr.left);
                    visited.put(curr.left, true);
                }
                if(curr.right!=null && visited.get(curr.right) == null){
                    q.add(curr.right);
                    visited.put(curr.right, true);
                }
                if(parents.get(curr)!=null && visited.get(parents.get(curr)) == null){
                    q.add(parents.get(curr));
                    visited.put(parents.get(curr), true);
                }
            }
        }

        List<Integer> ans = new ArrayList<>();

        while(!q.isEmpty()){
            TreeNode n = q.poll();
            ans.add(n.val);
        }

        return ans;
    }
}