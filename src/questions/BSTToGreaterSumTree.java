package src.questions;

public class BSTToGreaterSumTree {

    public static void bstToGST(TreeNode root){
        bstToGST(root, 0);
    }

    private static int bstToGST(TreeNode root, int sum) {
        if(root==null){
            return sum;
        }
        int currVal = root.val;
        root.val = bstToGST(root.right, sum);
        return bstToGST(root.left, root.val+currVal);
    }

}
