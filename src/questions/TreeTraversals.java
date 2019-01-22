package src.questions;

import java.util.ArrayList;

public class TreeTraversals {

    public static ArrayList<Integer> inorder(TreeNode root){
        ArrayList<Integer> ans = new ArrayList<>();
        inorder(root, ans);
        return ans;
    }

    private static void inorder(TreeNode root, ArrayList<Integer> ans) {
        if(root==null)
            return;

        inorder(root.left, ans);
        ans.add(root.val);
        inorder(root.right, ans);
    }

}
