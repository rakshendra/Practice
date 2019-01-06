package src.questions;

import java.util.Stack;

/**
 *              1
 *             / \
 *            2   3
 *           / \ / \
 *          4  56  7
 *   Answer should be: 1 23 7654
 */
public class ZigZagTraversal {
    public static void printZigZagTraversal(TreeNode root){
        Stack<TreeNode> st1 = new Stack<>();
        Stack<TreeNode> st2 = new Stack<>();

        if(root != null){
            st1.push(root);
        }

        boolean left = true;

        while(!st1.isEmpty() || !st2.isEmpty()){
            if(left && !st1.isEmpty()){
                TreeNode node = st1.pop();
                System.out.print(node.val+" ");
                if(node.right!=null){
                    st2.push(node.right);
                }
                if(node.left!=null){
                    st2.push(node.left);
                }
            }else{
                left = false;
                System.out.println();
            }

            if(!left && !st2.isEmpty()){
                TreeNode node = st2.pop();
                System.out.print(node.val+" ");
                if(node.left!=null){
                    st1.push(node.left);
                }
                if(node.right!=null){
                    st1.push(node.right);
                }
            }else{
                left = true;
                System.out.println();
            }
        }
    }
}
