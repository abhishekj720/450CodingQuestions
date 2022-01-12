//A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them. A node can only appear in the sequence at most once. Note that the path does not need to pass through the root.

//The path sum of a path is the sum of the node's values in the path.

//Given the root of a binary tree, return the maximum path sum of any non-empty path.


//My solution
class Solution {
    int m = -1000;
    
    public int path(TreeNode root)
    {
        if(root.left == null && root.right == null)
        {   
            
            return root.val;
        }
            
        int left =-100, right =-100;
        if(root.left != null)
        {
            left = path(root.left);
            
        }
        if(root.right != null)
        {
            right = path(root.right);
        }
            
        
        m = Math.max(m,Math.max(left+root.val+right,Math.max(left+root.val,Math.max(left,Math.max(right+root.val,right)))));
        m = Math.max(m,root.val);
        return Math.max(root.val,root.val + Math.max(left,right));    
    }
    
    public int maxPathSum(TreeNode root) {
        int c = path(root);
        return Math.max(c,m);
    }
}




//better solution
public class Solution {
    int maxValue;
    
    public int maxPathSum(TreeNode root) {
        maxValue = Integer.MIN_VALUE;
        maxPathDown(root);
        return maxValue;
    }
    
    private int maxPathDown(TreeNode node) {
        if (node == null) return 0;
        int left = Math.max(0, maxPathDown(node.left));
        int right = Math.max(0, maxPathDown(node.right));
        maxValue = Math.max(maxValue, left + right + node.val);
        return Math.max(left, right) + node.val;
    }
}
