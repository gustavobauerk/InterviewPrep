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

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(12);
        treeNode.left = new TreeNode(7);
        treeNode.right = new TreeNode(1);
        treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(4);
        treeNode.right.left = new TreeNode(10);
        treeNode.right.right = new TreeNode(10);
        System.out.println(hasPath(treeNode, 23));
    }
}
