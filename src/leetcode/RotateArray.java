package src.leetcode;

public class RotateArray {

     public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
     }

     public static void main(String[] args){
     int[] arr = {-10, -3, 0, 5,9};
     sortedArrayToBST(arr);
     }

    public static TreeNode sortedArrayToBST(int[] nums) {
        int l=0;
        int r=nums.length-1;
        int mid = l+(r-l)/2;
        TreeNode root = new TreeNode(nums[mid]);
        sortedArrayToBST(nums, root.left, l, mid-1);
        sortedArrayToBST(nums, root.right, mid+1, r);
        return root;

    }

    public static void sortedArrayToBST(int[] nums, TreeNode root, int l, int r) {
        if(l > r){
            root = null;
            return;
        }


        int mid = l+(r-l)/2;
        root = new TreeNode(nums[mid]);
        sortedArrayToBST(nums, root.left, l, mid-1);
        sortedArrayToBST(nums, root.right, mid+1, r);

    }
}
