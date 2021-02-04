package com.test.javarnd;
/*
 * Copyright (c) 2021.
 * Author : Rahul Sharma
 */

import java.util.*;

/**
 * Assumptions
 * D: Down Move
 * U: Up Move
 * R: Right Move
 * L: Left Move
 * END_I : Destination point on X axis
 * END_J : Destination point on Y axis
 * possiblePaths: Has all the Possible combination of path to reach destination
 */
class MazeInShortestRun {
    // Set to store all the possible paths
    static Set<String> possiblePaths = new HashSet<>();
    static String path = "";
    static int END_I;
    static int END_J;

    /** Function returns true if the move taken is valid else  it will return false.
     * @param row
     * @param col
     * @param m
     * @param n
     * @param visited
     * @return
     */
    static boolean isSafe(int row, int col, int[][] m,
                          int n, boolean[][] visited) {
        return row != -1 && row != n && col != -1 &&
                col != n && !visited[row][col] &&
                m[row][col] != 0;
    }

    /**  Function to print all the possible
     * @param row
     * @param col
     * @param matrix
     * @param n
     * @param visited
     */
    static void printPathUtil(int row, int col, int[][] matrix,
                              int n, boolean[][] visited) {
        // This will check the initial point
        // (i.e. (0, 0)) to start the paths.

        if (row == -1 || row == n || col == -1 ||
                col == n || visited[row][col] ||
                matrix[row][col] == 0)
            return;

        // If reach the Destination coordinates (provided as input)
        // then store the path and return
        if (row == END_I && col == END_J) {
            possiblePaths.add(path);
            return;
        }
        // Mark the cell as visited
        visited[row][col] = true;
         /*
         Try for all the 4 directions (down, left, right, up) in the given order to get the
         paths in lexicographical order (alphabetical order)
         */

        // Check if downward move is valid
        if (isSafe(row + 1, col, matrix, n, visited)) {
            path += 'D';
            printPathUtil(row + 1, col, matrix, n,visited);
            path = path.substring(0, path.length() - 1);
        }
        // Check if the left move is valid
        if (isSafe(row, col - 1, matrix, n, visited)) {
            path += 'L';
            printPathUtil(row, col - 1, matrix, n, visited);
            path = path.substring(0, path.length() - 1);
        }
        // Check if the right move is valid
        if (isSafe(row, col + 1, matrix, n, visited)) {
            path += 'R';
            printPathUtil(row, col + 1, matrix, n, visited);
            path = path.substring(0, path.length() - 1);
        }
        // Check if the upper move is valid
        if (isSafe(row - 1, col, matrix, n, visited)) {
            path += 'U';
            printPathUtil(row - 1, col, matrix, n,visited);
            path = path.substring(0, path.length() - 1);
        }
        // Mark the cell as unvisited for other possible paths
        visited[row][col] = false;
    }

    /** Function to store and print all the valid paths
     * @param matrix
     * @param start_i
     * @param start_j
     */
    static void printPath(int[][] matrix, int start_i , int start_j) {
        int sizeOfMatrix = matrix.length;
        boolean[][] visited = new boolean[sizeOfMatrix][sizeOfMatrix];
        // Call the utility function to find the valid paths
        printPathUtil( start_i , start_j, matrix, sizeOfMatrix, visited);
    }

    /** Driver code and Printing Logic below this
     * Both "matricDummy" and "matrixFromQstn" the Matrix can be changed for testing purpose
     * @param args
     */
    public static void main(String[] args) {
        int[][] matrixDummy = {
                { 1, 0, 0, 0, 0 },
                { 1, 1, 1, 1, 1 },
                { 1, 1, 1, 0, 1 },
                { 0, 0, 0, 0, 1 },
                { 0, 0, 0, 0, 1 } };

        int[][] matrixFromQstn = {
                {1, 0, 0, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 0},
                {1, 0, 1, 1, 1, 1, 1},
                {1, 0, 1, 0, 1, 0, 1},
                {1, 0, 1, 0, 1, 0, 1},
                {1, 1, 1, 0, 1, 0, 1}
        };
        int start_i ;
        int start_j ;
        int end_i ;
        int end_j;
        Scanner scannerOption = new Scanner(System.in);

        System.out.println("Enter 1 in console. For Default USE CASE of Question Paper.");
        System.out.println("Enter 2 in console. For Multiple Path traversing example.");
        System.out.println("Enter 3 in console. For Custom STARTING and DESTINATION points in Question matrix.");
        int operation =scannerOption.nextInt();
        // This is default case
        if(operation==1){
            start_i =0;
            start_j =0;
            end_i=6;
            end_j=6;
            END_I = end_i;
            END_J = end_j;
            printPath(matrixFromQstn, start_i, start_j);
        }else if(operation==2){
            start_i =0;
            start_j =0;
            end_i=4;
            end_j=4;
            END_I = end_i;
            END_J = end_j;
            printPath(matrixDummy, start_i, start_j);
        }else{
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please Enter Starting X-Axis");
            start_i = scanner.nextInt();
            System.out.println("Please Enter Starting Y-Axis");
            start_j = scanner.nextInt();
            System.out.println("Please Enter Destination X-Axis");
            end_i = scanner.nextInt();
            System.out.println("Please Enter Destination Y-Axis");
            end_j = scanner.nextInt();
            END_I = end_i;
            END_J = end_j;
            printPath(matrixFromQstn, start_i, start_j);
        }


        if( !possiblePaths.isEmpty()) {
            printingDetailsLogic(start_i,start_j);
        }else
          System.out.println("Sorry There is now way to reach at Destination");
    }

    private static void printingDetailsLogic(int start_i, int start_j) {
        System.out.println("Do you want to print Path movement in Character form: 1 else 2");
        Scanner scannerOption = new Scanner(System.in);
        boolean flagPrintWords = scannerOption.nextInt() == 1;
        String shortestAmongAll="" ;
        System.out.println();
        System.out.println();
        int prevsPathLength=Integer.MAX_VALUE;
        for (String currentPath : possiblePaths) {
            if (prevsPathLength > currentPath.length()) {
                prevsPathLength = currentPath.length();
                shortestAmongAll = currentPath;
            }
            if (flagPrintWords) {
                System.out.println("Movement in Character: " + currentPath);
            }
            printPathFollowed(currentPath, false,start_i,start_j);
        }
        System.out.println();
        System.out.println();
        System.out.println("*********************FINAL SHORTEST PATH OF TRAVERSAL*******************");

        if (flagPrintWords) {

            System.out.println("*****************D: DOWN , R : RIGHT , L : LEFT , U : UPPER*************");
            System.out.println("Final path to reach destination is :" + shortestAmongAll);
        }
        printPathFollowed(shortestAmongAll,true,start_i,start_j);
    }

    private static void printPathFollowed(String pathFollowed,boolean flag,int start_i, int start_j) {
        char[] currentPathAction = pathFollowed.toCharArray();
        int coordination_i=start_i;
        int coordination_j=start_j;
        if(flag) System.out.print("Possible SHORTEST Path to reach at destination in coordinate form:");
        else System.out.print("Possible Path to reach at destination in coordinate form:");
        for (char c : currentPathAction) {
            if (c == 'D') {
                coordination_i += 1;
            } else if (c == 'U') {
                coordination_i -= 1;
            } else if (c == 'R') {
                coordination_j += 1;
            } else {
                coordination_j -= 1;
            }
            System.out.print("{" + coordination_i + "," + coordination_j + "}, ");
        }
        System.out.println();
    }
}