//**
//        * Definition for a binary tree node.
//        * public class TreeNode {
// *     int val;
// *     TreeNode left;
// *     TreeNode right;
// *     TreeNode() {}
// *     TreeNode(int val) { this.val = val; }
// *     TreeNode(int val, TreeNode left, TreeNode right) {
// *         this.val = val;
// *         this.left = left;
// *         this.right = right;
// *     }
// * }
// */
//class Solution {
//    public TreeNode invertTree(TreeNode root) {
//
//        if (root == null)
//            return null;
//
//        Queue<TreeNode> q = new LinkedList<>();
//        q.add(root);
//
//        while (!q.isEmpty()) {
//            TreeNode curr = q.poll();
//
//            TreeNode temp = curr.left;
//            curr.left = curr.right;
//            curr.right = temp;
//
//            if (curr.left != null)
//                q.add(curr.left);
//            if (curr.right != null)
//                q.add(curr.right);
//        }
//        return root;
//    }
//}

package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class InvertBinaryTree {
    public static void main(String[] args) {

        int[] root = {4, 2, 7, 1, 3, 6, 9};
        int[] root1 = {2,1,3};
        TreeNode treeNode = buildTree(root);
        TreeNode treeNode1 = buildTree(root1);

        InvertBinaryTree solution = new InvertBinaryTree();
        TreeNode invertedRoot = solution.invertTree(treeNode);
        TreeNode invertedRoot1 = solution.invertTree(treeNode1);

        printLevelOrder(invertedRoot);
        printLevelOrder(invertedRoot1);
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            TreeNode curr = q.poll();

            TreeNode temp = curr.left;
            curr.left = curr.right;
            curr.right = temp;

            if (curr.left != null) {
                q.add(curr.left);
            }

            if (curr.right != null) {
                q.add(curr.right);
            }
        }
        return root;
    }


    public static TreeNode buildTree(int[] arr) {
        if (arr == null || arr.length == 0) return null;

        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;
        while (i < arr.length) {
            TreeNode current = queue.poll();

            if (i < arr.length) {
                current.left = new TreeNode(arr[i++]);
                queue.offer(current.left);
            }

            if (i < arr.length) {
                current.right = new TreeNode(arr[i++]);
                queue.offer(current.right);
            }
        }
        return root;
    }

    public static void printLevelOrder(TreeNode root) {
        if (root == null) return;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            System.out.print(current.val + " ");

            if (current.left != null) queue.offer(current.left);
            if (current.right != null) queue.offer(current.right);
        }
        System.out.println();
    }
}
