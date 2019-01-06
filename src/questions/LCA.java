package src.questions;

public class LCA {

    public static TreeNode findLCA(TreeNode root, int key1, int key2){
        if(root==null){
            return null;
        }
        if(root.val==key1 || root.val==key2){
            return root;
        }
        TreeNode left = findLCA(root.left, key1, key2);
        TreeNode right = findLCA(root.right, key1, key2);
        if(left != null && right != null){
            return root;
        }
        return left == null ? right:left;
    }
}
