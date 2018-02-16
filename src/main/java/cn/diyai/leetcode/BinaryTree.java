package cn.diyai.leetcode;

import java.util.LinkedList;

import static java.lang.System.out;

public class BinaryTree {
    /**
     * 递归实现 获取二叉树深度
     *
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {//如果只有根节点，则返回1
            return 1;
        } else if (root.left != null && root.right == null) {//若左子树为空，则返回右子树的最小深度+1
            return minDepth(root.left) + 1;
        } else if (root.left == null && root.right != null) {// 若右子树为空，则返回左子树的最小深度+1
            return minDepth(root.right) + 1;
        } else {
            return Math.min(minDepth(root.left), minDepth(root.right)) + 1; // 左右子树都不为空时，取较小值
        }

    }

    /**
     * //采用广度优先搜索，或者层序遍历，找到的第一个叶节点的深度即是最浅。
     *
     * @param root
     * @return
     */
    public int minDepth1(TreeNode root) {

        if (root == null) return 0;
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        int level = 0;
        while (!queue.isEmpty()) {
            int levelLen = queue.size();
            level++;
            for (int i = 0; i < levelLen; i++) {
                TreeNode node = queue.removeFirst();
                if (node.left == null && node.right == null) return level;
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }
        return level;
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        TreeNode rootNode = new TreeNode(1);
        TreeNode leftNode = new TreeNode(2);
        TreeNode rightNode = new TreeNode(3);
        rootNode.left = leftNode;
        rootNode.right = rightNode;
        rightNode.left = new TreeNode(4);
        System.out.println(String.format("%s %s", "最小深度为", binaryTree.minDepth(rootNode)));
        System.out.println(String.format("%s %s", "最小深度为", binaryTree.minDepth1(rootNode)));

    }

}
