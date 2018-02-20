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

    /**
     * Given a binary tree containing digits from0-9only, each root-to-leaf path could represent a number.
     * An example is the root-to-leaf path1->2->3which represents the number123.
     * Find the total sum of all root-to-leaf numbers.
     * For example,
     * 1
     * / \
     * 2   3
     * The root-to-leaf path1->2 represents the number 12.
     * The root-to-leaf path1->3 represents the number 13.
     * Return the sum = 12 + 13 =25.
     *
     * @param root
     * @return
     */
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int rootValue = root.val;

        if(root.left == null && root.right == null){
            return rootValue;
        }

        if (root.left == null && root.right != null) {
            return rootValue * 10 + root.right.val;
        }

        if (root.right == null && root.left != null) {
            return rootValue * 10 + root.left.val;
        }

        return (rootValue * 10 + root.right.val) + (rootValue * 10 + root.left.val);
    }


    int result;
    public int sumNumbers2(TreeNode root)
    {
        if(root == null) return 0;
        result = 0;
        getSum(root, 0);
        return result;
    }

    /**
     * 左边和
     * @param root
     * @param sum
     */
    public void getSum(TreeNode root, int sum)
    {
        sum = sum * 10 + root.val;
        // 没有子节点就直接返回
        if(root.left==null && root.right==null)
        {
            result = result + sum;
            return;
        }

        //有右节点
        if(root.left != null)
        {
            getSum(root.left, sum);
        }

        //有左节点
        if(root.right != null)
        {
            getSum(root.right, sum);
        }
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

        System.out.println(binaryTree.sumNumbers2(rootNode));

    }

}
