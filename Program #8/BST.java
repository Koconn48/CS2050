//Program #8 - BST Trees
//By: Kevin O'Connell

import java.io.BufferedWriter;
import java.io.IOException;

class BST {
    private TreeNode root;

    public BST() {
        root = null;
    }

    //insert word into the bst
    public void insert(String word) {
        root = insertRec(root, word.toLowerCase());
    }

    //recursive helper method to insert a word into the bst
    private TreeNode insertRec(TreeNode root, String word) {
        if (root == null) {
            return new TreeNode(word);
        }

        int compare = word.compareTo(root.word);
        if (compare < 0) {
            root.left = insertRec(root.left, word); // Words less than the current node go to the left
        } else if (compare > 0) {
            root.right = insertRec(root.right, word); // Words greater than the current node go to the right
        }

        return root;
    }

    //retrieve root of the BST
    public TreeNode getRoot() {
        return root;
    }

    //perform a post-order traversal of the BST
    public void postOrderTraversal(TreeNode root, BufferedWriter writer) throws IOException {
        if (root != null) {
            postOrderTraversal(root.left, writer);
            postOrderTraversal(root.right, writer);
            writer.write(root.word + "\n");
        }
    }

    //count number of nodes in the BST
    public int countNodes(TreeNode root) {
        if (root == null)
            return 0;

        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    //compute height of the BST
    public int height(TreeNode root) {
        if (root == null)
            return 0;

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        return 1 + Math.max(leftHeight, rightHeight);
    }
}
