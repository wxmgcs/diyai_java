package cn.diyai.leetcode;

import java.util.LinkedList;

import static java.lang.System.out;

public class BinaryTree {
    /**
     * 递归实现 获取二叉树深度
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {

        if(root == null) return 0;
        if(root.left == null && root.right == null) return 1;
        else if(root.left != null && root.right == null) return minDepth(root.left) + 1;
        else if(root.left == null && root.right != null) return minDepth(root.right) + 1;
        else  return Math.min(minDepth(root.left), minDepth(root.right)) + 1;

    }


    public int minDepth1(TreeNode root) {

        if(root == null) return 0;
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int level = 0;
        while(!queue.isEmpty()) {
            int levelLen = queue.size();
            level ++;
            for (int i = 0; i < levelLen; i++) {
                TreeNode node = queue.removeFirst();
                if(node.left == null && node.right == null) return level;
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
        }
        return level;
    }

    public static void main(String[] args){

        BinaryTree binaryTree = new BinaryTree();
        TreeNode rootNode = new  TreeNode(1);
        TreeNode leftNode = new TreeNode(2);
        TreeNode rightNode = new TreeNode(3);
        rootNode.left = leftNode;
        rootNode.right = rightNode;
        System.out.println(binaryTree.minDepth(rootNode));

    }

}
