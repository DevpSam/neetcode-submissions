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
    int index;
    HashMap<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        
        int start = 0;
        int end = inorder.length - 1;
        
        for(int i = 0; i<=end ;i++){
            map.put(inorder[i], i);
        }
        index = postorder.length - 1;
        return helper(inorder, postorder, start, end);
    }
    private TreeNode helper(int[] inorder, int[] postorder, int start, int end){
        if(start>end){
            return null;
        }
        int rootVal = postorder[index--];
        TreeNode nn = new TreeNode(rootVal);
        int mid = map.get(rootVal);

        nn.right = helper(inorder, postorder, mid + 1, end);
        nn.left = helper(inorder, postorder, start, mid-1);

        return nn;
    }
}