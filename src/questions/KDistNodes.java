package src.questions;

import java.util.ArrayList;

public class KDistNodes {

    public static ArrayList<Integer> findNodesAtKDist(TreeNode root, int src, int k){
        ArrayList<Integer>  ans = new ArrayList<>();
        TreeNode node = findNode(root, src);
        findNodesAtKDist(root, node, k, ans);
        return ans;
    }

    private static int findNodesAtKDist(TreeNode root, TreeNode src, int k, ArrayList<Integer> ans){
        if(root==null){
            return -1;
        }
        if(root==src){
            findNodesAtKDistDown(src, k, ans);
            return 0;
        }

        int dl = findNodesAtKDist(root.left, src, k, ans);
        if(dl != -1){
            if(dl+1==k){
                ans.add(root.val);
            }else{
                findNodesAtKDistDown(root.right,k-dl-2, ans);
            }
            return dl+1;
        }
        int dr = findNodesAtKDist(root.right, src, k, ans);
        if(dr != -1){
            if(dr+1==k){
                ans.add(root.val);
            }else{
                findNodesAtKDistDown(root.left, k-dr-2, ans);
            }
            return dr+1;
        }
        return -1;
    }

    private static TreeNode findNode(TreeNode root, int src) {
        if(root==null){
            return null;
        }
        if(root.val == src){
            return root;
        }
        TreeNode node = null;
        if(root.left !=null){
            node = findNode(root.left, src);
        }
        if(root.right!=null && node == null){
            node = findNode(root.right, src);
        }
        return node;
    }

    private static void findNodesAtKDistDown(TreeNode node, int k, ArrayList<Integer> ans){
        if(node==null){
            return;
        }
        if(k==0){
            ans.add(node.val);
            return;
        }
        findNodesAtKDistDown(node.left, k-1, ans);
        findNodesAtKDistDown(node.right, k-1, ans);
    }

}
