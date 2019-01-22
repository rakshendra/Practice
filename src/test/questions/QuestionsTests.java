package src.test.questions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test ;
import src.questions.*;
import src.questions.GraphTraversals.Graph;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class QuestionsTests {

    @Test
    void testZigZagTraversal(){
        TreeNode root = getTree();
        ZigZagTraversal.printZigZagTraversal(root);
    }

    @Test
    void testPowerSet(){
        List<String> set = new ArrayList<>();
        set.add("a");
        set.add("b");
        set.add("c");
        List<List<String>> ans = PowerSet.powerSet(set);
        for(int i=0; i< ans.size(); i++){
            System.out.print("List "+(i+1)+": { ");
            List<String> temp = ans.get(i);
            for(int j=0; j<temp.size(); j++){
                System.out.print(temp.get(j)+",");
            }
            System.out.println("}");
        }
    }

    @Test
    void testDutchNationalFlag(){
        int[] arr = {2,1,0,0,0,1,1,2,2,0,0,0,1};
        int[] ans = {0,0,0,0,0,0,1,1,1,1,2,2,2};
        DutchFlagProblem.sort0s1s2s(arr);
        Assertions.assertArrayEquals(arr, ans);
    }

    @Test
    void testCODIO(){
        CombinationsOfDigitsInOrder.findOrderedCombinations("1234");
    }

    @Test
    void testLCA(){
        TreeNode root = getTree();

        TreeNode node = LCA.findLCA(root, 4, 6);
        Assertions.assertEquals(node.val, 1);

        node = LCA.findLCA(root, 8, 6);
        Assertions.assertEquals(node.val, 3);

        node = LCA.findLCA(root, 8, 3);
        Assertions.assertEquals(node.val, 3);
    }

    @Test
    void testCommonPath(){
        TreeNode root = getTree();
        ArrayList<Integer> path;
        path = CommonPathFromRootToAncestor.printCommonPath(root, 6,8);
        Assertions.assertArrayEquals(path.toArray(new Integer[0]), new Integer[]{1,3});

        path = CommonPathFromRootToAncestor.printCommonPath(root, 7,8);
        Assertions.assertArrayEquals(path.toArray(new Integer[0]), new Integer[]{1,3,7});

        path = CommonPathFromRootToAncestor.printCommonPath(root, 4,5);
        Assertions.assertArrayEquals(path.toArray(new Integer[0]), new Integer[]{1,2});

        path = CommonPathFromRootToAncestor.printCommonPath(root, 4,6);
        Assertions.assertArrayEquals(path.toArray(new Integer[0]), new Integer[]{1});
    }

    @Test
    void testBFSTraversal(){
        Graph graph = getGraph();
        GraphTraversals.printBFS(graph, 0);
        System.out.println();
        GraphTraversals.printBFS(graph, 1);
        System.out.println();
        GraphTraversals.printBFS(graph, 2);
        System.out.println();
        GraphTraversals.printBFS(graph, 3);
        System.out.println();
        GraphTraversals.printBFS(graph, 4);
        System.out.println();
        GraphTraversals.printBFS(graph, 5);
    }

    @Test
    void testDFSTraversal(){
        Graph graph = getGraph();
        GraphTraversals.printDFS(graph, 0);
        System.out.println();
        GraphTraversals.printDFS(graph, 1);
        System.out.println();
        GraphTraversals.printDFS(graph, 2);
        System.out.println();
        GraphTraversals.printDFS(graph, 3);
        System.out.println();
        GraphTraversals.printDFS(graph, 4);
        System.out.println();
        GraphTraversals.printDFS(graph, 5);
    }

    @Test
    void testKadanesAlgo(){
        int[] arr = {-2, -3, 4,-1,-2,1,5,-3};
        Assertions.assertEquals(KadanesAlgo.maxSumSubArray(arr), 7);
    }

    @Test
    void testKDistNodes(){
        TreeNode root = getTree();
        Integer[] exp = {2,8};
        ArrayList<Integer> nodesAtKDist = KDistNodes.findNodesAtKDist(root, 6, 3);
        Collections.sort(nodesAtKDist);
        Integer[] actual = nodesAtKDist.toArray(new Integer[0]);
        Assertions.assertArrayEquals(exp, actual);
    }

    @Test
    void testLCABST(){
        TreeNode root = getBST();
        Assertions.assertEquals(1, LCABST.lcaBST(root, 1,2));
        Assertions.assertEquals(3, LCABST.lcaBST(root, 4,2));
        Assertions.assertEquals(5, LCABST.lcaBST(root, 4,6));
    }

    @Test
    void testSecondLargest(){
        int[] arr1 = {2,2,2,2,2,2,2};
        int[] arr2 = {2,2,3,3,1,1,4,5,3,6};
        int[] arr3 = {1,2,3,4,5,6,7};

        Assertions.assertEquals(Integer.MIN_VALUE, SecondLargest.secondLargest(arr1));
        Assertions.assertEquals(5, SecondLargest.secondLargest(arr2));
        Assertions.assertEquals(6, SecondLargest.secondLargest(arr3));
    }

    @Test
    void testBSTToGST(){
        TreeNode root = getBST();
        BSTToGreaterSumTree.bstToGST(root);
        ArrayList<Integer> ans = TreeTraversals.inorder(root);

        Integer[] exp = {35,33,30,26,21,15,8,0};
        Integer[] ansArr = ans.toArray(new Integer[0]);
        Assertions.assertArrayEquals(exp, ansArr);
    }

    @Test
    void testRotatedSortedSearch(){
        int[] arr1 = {2,3,4,5,6,7,8,9,1};
        Assertions.assertEquals(-1, BinarySearchRotatedSorted.searchElement(arr1, 10));
        Assertions.assertEquals(1, BinarySearchRotatedSorted.searchElement(arr1, 3));
        Assertions.assertEquals(8, BinarySearchRotatedSorted.searchElement(arr1, 1));

        int[] arr2 = {6,7,8,9,1,2,3,4,5};
        Assertions.assertEquals(-1, BinarySearchRotatedSorted.searchElement(arr2, 10));
        Assertions.assertEquals(6, BinarySearchRotatedSorted.searchElement(arr2, 3));
        Assertions.assertEquals(1, BinarySearchRotatedSorted.searchElement(arr2, 7));

        int[] arr3 = {1,2,3,4,5,6,7,8,9};
        Assertions.assertEquals(-1, BinarySearchRotatedSorted.searchElement(arr3, 10));
        Assertions.assertEquals(2, BinarySearchRotatedSorted.searchElement(arr3, 3));
        Assertions.assertEquals(3, BinarySearchRotatedSorted.searchElement(arr3, 4));
    }

    @Test
    void testRemoveExtraSpaces(){
        String str1 = " Who the     hell is    this Guy.    ";
        String exp1 = "Who the hell is this Guy.            ";
        char[] str1Chars = str1.toCharArray();
        RemoveExtraSpaces.removeSpaces(str1Chars);
        Assertions.assertEquals(exp1, String.valueOf(str1Chars));

        String str2 = " Who the hell is this Guy.";
        String exp2 = "Who the hell is this Guy. ";
        char[] str2Chars = str2.toCharArray();
        RemoveExtraSpaces.removeSpaces(str2Chars);
        Assertions.assertEquals(exp2, String.valueOf(str2Chars));
    }

    private TreeNode getTree() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.right.right.left = new TreeNode(8);
        return root;
    }

    private TreeNode getBST() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(8);
        root.left.left.right = new TreeNode(2);
        return root;
    }

    private Graph getGraph(){
        Graph graph = new Graph(6);
        graph.addEdge(0,1);
        graph.addEdge(0,4);
        graph.addEdge(0,5);
        graph.addEdge(1,2);
        graph.addEdge(2,4);
        graph.addEdge(3,2);
        graph.addEdge(3,5);
        graph.addEdge(4,3);
        graph.addEdge(5,4);
        return graph;
    }
}
