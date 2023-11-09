//Program #8 - BST Trees
//By: Kevin O'Connell

class TreeNode {
    //stores word at tree node
    String word;
    //left subtree reference
    TreeNode left;
    //right subtree reference
    TreeNode right;

    //constructor to create a TreeNode with given word
    public TreeNode(String word) {
        this.word = word;
        left = null;
        right = null;
    }
}
