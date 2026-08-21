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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res= new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root != null){
            q.add(root);
        }
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                TreeNode removal = q.remove();
                if(i == size - 1)
                res.add(removal.val);
                if(removal.left != null)
                q.add(removal.left);
                if(removal.right != null)
                q.add(removal.right);
            }
        }
        return res;  
    }
}