// By: Kevin O'Connell
//Project Description: Program 6 - Sorting Arrays
import java.io.*;
import java.util.*;

public class Program6 {
    public static void main(String[] args) {
        //create 2 integer arrays of 20,000, one for bubble sort and one for selection sort.
        int[] bubbleSortArray = new int[20000];
        int[] selectionSortArray = new int[20000];
        ArrayList<Integer> integerArrayList = new ArrayList<>();

        try {
            //open NumbersInFile.txt, read each line into the two arrays and the ArrayList, then close the file.
            BufferedReader reader = new BufferedReader(new FileReader("NumbersInFile.txt"));
            String line;
            int index = 0;
            while ((line = reader.readLine()) != null) {
                int number = Integer.parseInt(line);
                bubbleSortArray[index] = number;
                selectionSortArray[index] = number;
                integerArrayList.add(number);
                index++;
            }
            reader.close();

            //time how long it takes to sort each array using nanoTime()
            //implement bubble sort
            long bubbleSortStartTime = System.nanoTime();
            bubbleSort(bubbleSortArray);
            long bubbleSortEndTime = System.nanoTime();
            long bubbleSortTime = bubbleSortEndTime - bubbleSortStartTime;
            //implement selection sort on the second array
            long selectionSortStartTime = System.nanoTime();
            selectionSort(selectionSortArray);
            long selectionSortEndTime = System.nanoTime();
            long selectionSortTime = selectionSortEndTime - selectionSortStartTime;
            //create two arrays of String, one for bubble, the other for selection, and then an ArrayList<String>
            String[] bubbleSortStringArray = new String[10000];
            String[] selectionSortStringArray = new String[10000];
            ArrayList<String> stringArrayList = new ArrayList<>();
            //read StringsInFile.txt
            reader = new BufferedReader(new FileReader("StringsInFile.txt"));
            index = 0;
            while ((line = reader.readLine()) != null) {
                bubbleSortStringArray[index] = line;
                selectionSortStringArray[index] = line;
                stringArrayList.add(line);
                index++;
            }
            reader.close();

            //time how long it takes to sort each of the 3 structures.
            //implement bubble sort for strings
            long bubbleSortStringStartTime = System.nanoTime();
            bubbleSort(bubbleSortStringArray);
            long bubbleSortStringEndTime = System.nanoTime();
            long bubbleSortStringTime = bubbleSortStringEndTime - bubbleSortStringStartTime;
            //implement selection sort for Strings
            long selectionSortStringStartTime = System.nanoTime();
            selectionSort(selectionSortStringArray);
            long selectionSortStringEndTime = System.nanoTime();
            long selectionSortStringTime = selectionSortStringEndTime - selectionSortStringStartTime;
            //Collection.sort for ArrayList of Strings
            long collectionSortStartTime = System.nanoTime();
            Collections.sort(stringArrayList);
            long collectionSortEndTime = System.nanoTime();
            long collectionSortTime = collectionSortEndTime - collectionSortStartTime;

            //write results to results.txt
            PrintWriter writer = new PrintWriter("results.txt");
            writer.println("Part 1: Sorting Arrays:");
            writer.println("Total number of Integers: 20000");
            writer.println("Bubble Sort Total Time: " + bubbleSortTime + " nanoseconds");
            writer.println("Selection Sort Total Time: " + selectionSortTime + " nanoseconds");
            writer.println();
            writer.println("Part 2: System Sort:");
            writer.println("Total number of Strings: 10000");
            writer.println("Bubble Sort Total Time for Strings: " + bubbleSortStringTime + " nanoseconds");
            writer.println("Selection Sort Total Time for Strings: " + selectionSortStringTime + " nanoseconds");
            writer.println("Collection Sort Total Time for Strings: " + collectionSortTime + " nanoseconds");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //bubble sort for integers
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int a = 0; a < n - 1; a++) {
            for (int b = 0; b < n - a - 1; b++) {
                if (arr[b] > arr[b + 1]) {
                    int temp = arr[b];
                    arr[b] = arr[b + 1];
                    arr[b + 1] = temp;
                }
            }
        }
    }

    //bubble sort for strings
    public static void bubbleSort(String[] arr) {
        int n = arr.length;
        for (int a = 0; a < n - 1; a++) {
            for (int b = 0; b < n - a - 1; b++) {
                if (arr[b].compareTo(arr[b + 1]) > 0) {
                    String temp = arr[b];
                    arr[b] = arr[b + 1];
                    arr[b + 1] = temp;
                }
            }
        }
    }

    //selection sort for integers
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int a = 0; a < n - 1; a++) {
            int minIndex = a;
            for (int b = a + 1; b < n; b++) {
                if (arr[b] < arr[minIndex]) {
                    minIndex = b;
                }
            }
            int temp = arr[a];
            arr[a] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    //selection sort for strings
    public static void selectionSort(String[] arr) {
        int n = arr.length;
        for (int a = 0; a < n - 1; a++) {
            int minIndex = a;
            for (int b = a + 1; b < n; b++) {
                if (arr[b].compareTo(arr[minIndex]) < 0) {
                    minIndex = b;
                }
            }
            String temp = arr[a];
            arr[a] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }
}
