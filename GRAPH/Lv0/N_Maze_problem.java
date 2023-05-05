/*
Given a maze with N cells,
represented as integers from 0 to N-1, and an edge[] array,
where edge[i] represents the cell that can be reached from cell i in one step
(if edge[i] is -1, then cell i has no exit).
The maze can have multiple entry points, but only one exit point per cell.

The task is to find the nearest meeting cell, Cm, that can be reached from both C1 and C2,
where C1 and C2 are two cells in the maze.

Input:
The input consists of three lines:

    The first line contains an integer N, representing the number of cells in the maze.
    The second line contains N integers separated by spaces, representing the edge[] array.
    The third line contains two integers, C1 and C2, separated by a space, representing the starting cells.

Output:
The output should be a single integer, representing the nearest meeting cell, Cm.
If there is no meeting cell from the two given cells, the output should be -1.

Example:
Input:
5
1 2 3 4 -1
0 4

Output:
4

Explanation:
The maze has 5 cells, numbered from 0 to 4.
The edge[] array is [1, 2, 3, 4, -1],
which means that cell 0 can reach cell 1, cell 1 can reach cell 2,
and so on, until cell 4 which has no exit.
The starting cells are C1 = 0 and C2 = 4.
The nearest meeting cell, Cm, can be reached from both C1 and C2 is cell 4.
 */
public class N_Maze_problem {
}
