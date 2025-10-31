// Time Complexity : O(n).
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Approach : I did BFS here with the help of queue. The idea is to check size of the queue and size-1 node will be able to be viewed from the right side.


class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        //BFS logic with queue
        while(queue.size() != 0){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll(); //remove root
                if(curr.left != null){
                    queue.add(curr.left); // add corresponding left child
                }
                if(curr.right != null){
                    queue.add(curr.right); // add corresponding right child
                }
                if(i == size - 1){ // this will be the right side visible node
                    result.add(curr.val);
                }
            }
        }
        return result;
    }
}