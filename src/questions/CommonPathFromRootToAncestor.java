package src.questions;

import java.util.ArrayList;

/**
 * Assumptions: both the node exist in the tree
 */
public class CommonPathFromRootToAncestor {

    public static ArrayList<Integer> printCommonPath(TreeNode root, int n1, int n2){
        TreeNode lca = LCA.findLCA(root, n1, n2);
        ArrayList<Integer> path = new ArrayList<>();
        getPath(root, path, lca.val);
        return path;
    }

    private static boolean getPath(TreeNode root, ArrayList<Integer> path, int lca){
        if(root == null){
            return false;
        }
        path.add(root.val);
        if(root.val == lca){
            return true;
        }
        if( getPath(root.left, path, lca) || getPath(root.right, path, lca)){
            return true;
        }
        path.remove(path.size()-1);
        return false;
    }

}
