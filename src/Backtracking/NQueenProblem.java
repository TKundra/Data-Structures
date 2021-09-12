package Backtracking;

/*
    1. start in the leftmost column
    2. if all queens are placed return true
    3. try all rows in current column.
        do following for every tried row.
        a) if the queen can safely placed in the row mark
            this [row,col] as part of the solution and
            recursively check if placing queen here leads
            to a solution.
        b) if placing the queen in [row,col] leads to a
            solution then return true.
        c) if placing queen doesn't lead to a solution then
            unmark this [row, col] (Backtrack) and go to step (a)
            to try other rows.
    4. when all tried and nothing worked, return false.
    5. conditions
        - single queen in 1 row
        - single queen in 1 col
        - single queen in diagonal
*/

public class NQueenProblem {
    static int n;

    /*  3. to check whether the queen can be placed on board[row][col]
        to check whether the queen is already present at that place or not */
    static boolean isSafe(int[][] board, int row, int col){
        int i,j;
         /* row wise checking on left side
            where row is fixed and each
            col is being check {horizontally} */
        for (i=0; i<col; i++){
            if (board[row][i] == 1)
                return false;
        }
        /* check upper diagonal on left side
           diagonally top-left i.e { (2,1) with (1,0) } */
        i = row;
        j = col;
        while (i>=0 && j>=0){
            if (board[i][j]==1)
                return false;
            i--;
            j--;
        }
        /* check lower diagonal on left side
           diagonally bottom-left i.e { (2,1) with (1,2) } */
        i = row;
        j = col;
        while (i>=0 && j<n){
            if (board[i][j] == 1)
                return false;
            i--;
            j++;
        }
        return true;
    }

    /*  4. solve
        if one queen placed in column, then we jump to next column */
    static boolean solveNQUtil(int[][] board, int col){
        /* if all queens are placed, i.e all columns reached */
        if (col>=n)
            return true;
        /* consider this col and try to place queen in all rows */
        /* row (vertical) column (horizontal) */
        for (int i=0; i<n; i++){
            if (isSafe(board, i, col)){
                board[i][col] = 1;
                /* recur to place other queens */
                if (solveNQUtil(board, col+1))
                    return true;
                /* backtrack, when queen couldn't place */
                board[i][col] = 0;
            }
        }
        return false;
    }

    /*  2. solve */
    static void solveNQ(int[][] board){
        if (!solveNQUtil(board, 0)){
            System.out.println("solution doesn't exists");
            return;
        }
        printSolution(board);
    }

    /*  5. print solution */
    static void printSolution(int[][] board){
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        /*  1.create board */
        int[][] board = {
                {0,0,0,0},
                {0,0,0,0},
                {0,0,0,0},
                {0,0,0,0}
        };
        n = board.length;
        solveNQ(board);
    }
}
