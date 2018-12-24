package src;

/**
 * BST Properties:
 * - Left subtree of a node contains only nodes with keys lesser than it's key
 * - Right subtree of a node contains only nodes with keys greater than it's key
 * - The left and right subtree must also be binary search tree
 * - There are NO DUPLICATE nodes
 */
public class BSTUtility {

    public static class Node{
        int val;
        Node left;
        Node right;

        public Node(int val){
            this.val=val;
            left=null;
            right=null;
        }
    }

    public static void main(String[] args){
        Node root = new Node(10);
        root = insertNode(root, 5);
        root = insertNode(root, 15);
        root = insertNode(root, 3);
        root = insertNode(root, 7);
        root = insertNode(root, 13);
        root = insertNode(root, 12);
        root = insertNode(root, 1);
        root = insertNode(root, 17);
        printInorder(root);
        System.out.println();
        Node found = searchNode(root, 7);
        System.out.println("7 found: " + (found!=null));
        found = searchNode(root, 8);
        System.out.println("8 found: " + (found!=null));

        System.out.println(lowestCommonAncestor(root, 12, 13).val);
        System.out.println(lowestCommonAncestor(root, 12, 1).val);
        System.out.println(lowestCommonAncestor(root, 7, 17).val);
        System.out.println(lowestCommonAncestor(root, 7, 1).val);

        root = deleteNode(root, 12);
        printInorder(root);
        System.out.println();

        root = deleteNode(root, 1);
        printInorder(root);
        System.out.println();

        root = deleteNode(root, 15);
        printInorder(root);
        System.out.println();
    }

    private static void printInorder(Node root){
        if(root==null){
            return;
        }
        printInorder(root.left);
        System.out.print(root.val+" ");
        printInorder(root.right);
    }

    private static Node insertNode(Node root, int val){
        if(root==null){
            root= new Node(val);
            return root;
        }
        if(root.val > val){
            root.left = insertNode(root.left, val);
        }else if(root.val < val){
            root.right = insertNode(root.right, val);
        }
        return root;
    }

    private static Node searchNode(Node root, int val) {
        if (root == null) {
            return null;
        } else if (root.val == val) {
            return root;
        }

        if (val < root.val) {
            return searchNode(root.left, val);
        } else {
            return searchNode(root.right, val);
        }
    }

    private static Node deleteNode(Node root, int val){
        if(root==null){
            return root;
        }
        if(root.val > val){
            root.left = deleteNode(root.left, val);
        }else if(root.val < val){
            root.right = deleteNode(root.right, val);
        }else{
            if(root.left==null){
                return root.right;
            }else if(root.right==null){
                return root.left;
            }
            root.val = inorderSuccesor(root).val;
            root.right = deleteNode(root.right, root.val);
        }
        return root;
    }

    private static Node inorderSuccesor(Node root){
        if(root==null || root.right==null){
            return root;
        }
        root = root.right;
        while(root.left != null){
            root = root.left;
        }
        return root;
    }

    /**
     * Assumption: both val1 and val2 are present
     * @param root
     * @param val1
     * @param val2
     * @return
     */
    private static Node lowestCommonAncestor(Node root, int val1, int val2){
        if(root==null){
            return null;
        }
        if(root.val > val1 && root.val > val2){
            return lowestCommonAncestor(root.left, val1, val2);
        }
        if(root.val < val1 && root.val < val2){
            return lowestCommonAncestor(root.right, val1, val2);
        }
        return root;
    }
}
