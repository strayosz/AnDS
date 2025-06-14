package lab_03_HW_Recursion;

import java.util.List;
import java.util.ArrayList;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class NaryTreeNode {
    int val;
    List<NaryTreeNode> children;

    NaryTreeNode(int x) {
        val = x;
        children = new ArrayList<>();
    }
}

public class RecursionTasks {

    // Задача 1: Высота поддерева
    public static int calculateTreeHeight(TreeNode node) {
        if (node == null) {
            return -1;
        }
        int leftHeight = calculateTreeHeight(node.left);
        int rightHeight = calculateTreeHeight(node.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    // Задача 2: Сериализация бинарного дерева
    public static String serializeBinaryTree(TreeNode root) {
        if (root == null) {
            return "NULL";
        }
        String left = serializeBinaryTree(root.left);
        String right = serializeBinaryTree(root.right);
        return "(" + root.val + ", " + left + ", " + right + ")";
    }

    // Задача 3: Сериализация N-арного дерева
    public static String serializeNaryTree(NaryTreeNode root) {
        if (root == null) {
            return "NULL";
        }
        if (root.children.isEmpty()) {
            return "(" + root.val + ", NULL)";
        }

        StringBuilder childrenStr = new StringBuilder();
        for (NaryTreeNode child : root.children) {
            if (childrenStr.length() > 0) {
                childrenStr.append(", ");
            }
            childrenStr.append(serializeNaryTree(child));
        }
        return "(" + root.val + ", " + childrenStr.toString() + ")";
    }

    public static void main(String[] args) {
        // Тестирование задачи 1
        System.out.println("--- Задача 1: Высота поддерева ---");
        TreeNode tree1 = new TreeNode(1);
        tree1.left = new TreeNode(2);
        tree1.right = new TreeNode(3);
        tree1.left.left = new TreeNode(4);
        tree1.left.right = new TreeNode(5);

        System.out.println("Высота всего дерева: " + calculateTreeHeight(tree1));
        System.out.println("Высота поддерева с корнем 2: " + calculateTreeHeight(tree1.left));

        // Тестирование задачи 2
        System.out.println("\n--- Задача 2: Сериализация бинарного дерева ---");
        TreeNode tree2 = new TreeNode(1);
        tree2.left = new TreeNode(2);
        tree2.right = new TreeNode(3);
        tree2.left.left = new TreeNode(4);
        tree2.left.right = new TreeNode(5);
        tree2.right.right = new TreeNode(6);

        System.out.println("Сериализованное дерево:");
        System.out.println(serializeBinaryTree(tree2));

        // Тестирование задачи 3
        System.out.println("\n--- Задача 3: Сериализация N-арного дерева ---");
        NaryTreeNode naryTree = new NaryTreeNode(1);
        NaryTreeNode child1 = new NaryTreeNode(2);
        NaryTreeNode child2 = new NaryTreeNode(3);
        NaryTreeNode child3 = new NaryTreeNode(4);

        naryTree.children.add(child1);
        naryTree.children.add(child2);
        naryTree.children.add(child3);

        child2.children.add(new NaryTreeNode(5));
        child2.children.add(new NaryTreeNode(6));

        System.out.println("Сериализованное N-арное дерево:");
        System.out.println(serializeNaryTree(naryTree));
    }
}
