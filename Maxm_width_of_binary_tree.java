import java.util.*;

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        Queue<AnnotatedNode> queue = new LinkedList<>();
        queue.offer(new AnnotatedNode(root, 0, 0));
        int maxWidth = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            int leftmost = 0;
            int rightmost = 0;
            
            for (int i = 0; i < size; i++) {
                AnnotatedNode current = queue.poll();
                if (i == 0) {
                    leftmost = current.position;
                }
                if (i == size - 1) {
                    rightmost = current.position;
                }
                
                if (current.node.left != null) {
                    queue.offer(new AnnotatedNode(current.node.left, current.depth + 1, current.position * 2));
                }
                if (current.node.right != null) {
                    queue.offer(new AnnotatedNode(current.node.right, current.depth + 1, current.position * 2 + 1));
                }
            }
            
            maxWidth = Math.max(maxWidth, rightmost - leftmost + 1);
        }
        
        return maxWidth;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class AnnotatedNode {
    TreeNode node;
    int depth;
    int position;
    
    AnnotatedNode(TreeNode n, int d, int p) {
        node = n;
        depth = d;
        position = p;
    }
}
