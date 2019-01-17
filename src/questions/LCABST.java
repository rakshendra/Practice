package src.questions;

public class LCABST {

     public static int lcaBST(TreeNode root, int key1, int key2){
         if(root==null){
             return -1;
         }
         if(root.val > key1 && root.val > key2){
             return lcaBST(root.left, key1, key2);
         }else if(root.val < key1 && root.val < key2){
             return lcaBST(root.right, key1, key2);
         }
         return root.val;
     }
}
