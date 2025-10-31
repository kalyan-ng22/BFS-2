// Time Complexity : O(n).
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Approach : I did BFS here with the help of queue. At each level I am checking if x and y are present under same parent then straighway we return false.
// And while parsing the current level I am checking if I came across x and y in that level. IF both are present in that level with different parent
// then we return true, if either one is present it's false.


class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null){
            return false;
        }
        queue.add(root);
        while(queue.size() > 0){
            int size = queue.size();
            boolean xFound = false;
            boolean yFound = false;
            for(int i=0;i<size;i++){

                TreeNode curr = queue.poll();
                if(curr.left != null && curr.right != null){
                    if((curr.left.val == x && curr.right.val == y) ||
                            (curr.left.val == y && curr.right.val == x)) { //belongs to same parent condition
                        return false;
                    }
                }
                if(curr.val == x){ //x exists at current level
                    xFound = true;
                }
                if(curr.val == y){ // y exists at current level
                    yFound = true;
                }
                if(curr.left != null){ //add to queue as per BFS
                    queue.add(curr.left);
                }
                if(curr.right != null){ // add to queue as per BFS
                    queue.add(curr.right);
                }

            }
            if(xFound && yFound){ //if x and y found at same level
                return true;
            }
            if(xFound || yFound){ // if either one of x,y is found
                return false;
            }
        }
        return false;
    }
}