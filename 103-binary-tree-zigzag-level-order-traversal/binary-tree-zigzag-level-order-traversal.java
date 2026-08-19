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
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        if(root==null)  return res;
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        queue.add(root);
        int count=0;
        while(!queue.isEmpty()){
            List<Integer> tmp=new ArrayList<Integer>();
            int curSize=queue.size();
            for(int i=0;i<curSize;i++){
                if(queue.peek().left!=null) queue.add(queue.peek().left);
                if(queue.peek().right!=null) queue.add(queue.peek().right);
                if(count%2==0){
                    tmp.add(queue.poll().val);
                }else{
                    tmp.add(0, queue.poll().val);
                }
            }
            res.add(tmp);
            count++;
        }
        return res;
    }
    }