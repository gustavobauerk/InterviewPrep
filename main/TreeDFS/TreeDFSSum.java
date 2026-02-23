package TreeDFS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TreeDFSSum {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private static List<List<Integer>> hasPath(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return Collections.emptyList();
        if (root.left == null && root.right == null && root.val == sum) {
            List<Integer> leaf = new ArrayList<>();
            leaf.add(root.val);
            res.add(leaf);
            return res;
        }
        List<List<Integer>> listLeft = hasPath(root.left, sum-root.val);
        if(!listLeft.isEmpty()) {
            listLeft.forEach(leaf -> leaf.add(0, root.val));
        }
        List<List<Integer>> listRight = hasPath(root.right, sum-root.val);
        if(!listRight.isEmpty()) {
            listRight.forEach(leaf -> leaf.add(0, root.val));
        }
        res.addAll(listLeft);
        res.addAll(listRight);
        return res;
    }

    private static int findSumOfPathNumbers(TreeNode root) {
        if(root == null) return 0;
        return helper(root, 0);
    }

    private static int helper(TreeNode root, int value) {
        if(root == null) return 0;
        value = (value*10) + root.val;
        if(root.left == null && root.right == null) {
            return value;
        }
        int helperLeft = helper(root.left, value);
        int helperRight = helper(root.right, value);
        return helperLeft + helperRight;
    }
    private static int globalMaximumSum= Integer.MIN_VALUE;

    private static int findMaximumPathSum(TreeNode root) {
        globalMaximumSum= Integer.MIN_VALUE;
        int sum = findMaximumPathSumHelper(root);
        return Math.max(sum, globalMaximumSum);
    }

    private static int findMaximumPathSumHelper(TreeNode root){
        if(root == null) return -1001;
        if(root.left == null && root.right == null) {
            return root.val;
        }
        int leftPath = findMaximumPathSumHelper(root.left);
        int rightPath = findMaximumPathSumHelper(root.right);
        globalMaximumSum = Math.max(globalMaximumSum, leftPath);
        globalMaximumSum = Math.max(globalMaximumSum, rightPath);
        globalMaximumSum = Math.max(globalMaximumSum, root.val);
        globalMaximumSum = Math.max(globalMaximumSum, leftPath + rightPath + root.val);

        return Math.max(Math.max(leftPath, rightPath) + root.val, root.val);
    }


    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(0);
        treeNode.right = new TreeNode(1);
        treeNode.left.left = new TreeNode(1);
        treeNode.right.left = new TreeNode(6);
        treeNode.right.right = new TreeNode(5);
//        System.out.println(hasPath(treeNode, 8));
//        System.out.println(findSumOfPathNumbers(treeNode));
        treeNode = new TreeNode(-1);
        treeNode.left = new TreeNode(-3);

        System.out.println(findMaximumPathSum(treeNode));
    }
}
