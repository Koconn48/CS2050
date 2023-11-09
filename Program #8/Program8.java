//Program #8 - BST Trees
//By: Kevin O'Connell

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Program8 {
    public static void main(String[] args) {
        try {
            //open the input file for reading
            BufferedReader reader = new BufferedReader(new FileReader("dracula.txt"));

            //create a binary search tree to store words
            BST bst = new BST();

            String line;
            //read the file line by line
            while ((line = reader.readLine()) != null) {
                //split the line into words using space and punctuation as delimiters
                String[] words = line.split("\\s+|\\p{Punct}");
                for (String word : words) {
                    //process words that consist only of alphabetic characters
                    if (word.matches("^[a-zA-Z]+$")) {
                        //convert the word to lowercase and insert it into the BST
                        bst.insert(word.toLowerCase());
                    }
                }
            }

            reader.close();

            //open the output file for writing analysis.txt
            BufferedWriter writer = new BufferedWriter(new FileWriter("analysis.txt"));

            //count actual number of nodes in the BST
            int actualNodes = bst.countNodes(bst.getRoot());

            // calculate height of the BST
            int height = bst.height(bst.getRoot());

            // calculate maximum possible number of nodes in a BST of this height
            int maxNodes = (int) (Math.pow(2, height) - 1);

            //write the number of nodes to the analysis file
            writer.write("Number of Nodes: " + actualNodes + "\n");

            //compare the actual number of nodes with the maximum possible
            if (actualNodes == maxNodes) {
                writer.write("Tree Height: " + height + " (matches the max possible nodes)\n");
            } else {
                writer.write("Tree Height: " + height + " (does not match max possible nodes)\n");
            }

            writer.close();
        } catch (IOException e) {
            //handle IOException
            e.printStackTrace();
        }
    }
}
