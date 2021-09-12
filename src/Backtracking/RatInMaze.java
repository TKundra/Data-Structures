package Backtracking;

	/*1. create solution matrix, initially filled with 0's.
	2. create a recursive function, which takes initial matrix,
	   output matrix and position of rat (i,j)
	3. if position is out of matrix or not valid, return.
	4. mark the position output[i][j] as 1 and check if the
	   current position is destination or not. If destination
	   is reached print output matrix and return.
	5. recursively call for position (i+1, j) and (i, j+1)
	6. un-mark position (i,j) i.e output[i][j] = 0.
	   time: O(2^(n^2)) and space: O(n^2) complexity
	   when you could not include yourself
	   if(i>=n || j>=0 || i<0 || j<0 || maze[i][j] == 0 || sol[i][j] == 1 */


public class RatInMaze {

    // size of maze
    static int n;

    /* 2. check if x,y is valid index for nxn */
    boolean isSafe(int[][] maze, int x, int y){
        return (x>=0 && x<n && y>=0 && y<n && maze[x][y] == 1);
    }

    /* 4. recursive utility function to solve maze problem */
    boolean solveMazeUtil(int[][] maze, int i, int j, int[][] solution){
         /* base case
            if (x,y) is goal return goal, final exit
            and here we have to check is 1 present or not
            bcz maybe when wwe reached the end there is no
            source to go */
        if (i == n-1 && j == n-1 && maze[i][j] == 1){
            solution[i][j] = 1;
            return true;
        }
        if (isSafe(maze,i,j)) {
            /* if visited block */
            if (solution[i][j] == 1)
                return false;
            /* else make marked */
            solution[i][j] = 1;
            /* if path is available return true else false */
            // down
            if (solveMazeUtil(maze, i + 1, j, solution))
                return true;
            // right
            if (solveMazeUtil(maze, i, j + 1, solution))
                return true;
            solution[i][j] = 0;
            return false;
        }
        /* if location is outside the maze */
        return false;
    }

    /*3. solve problem using backtracking. It mainly uses solveMazeUtil to
         solve. It returns false if no path is possible else return true,
		 and prints path in form of 1s and there maybe more than one solution.
         this function prints one of the feasible solution. */
    void solveMaze(int[][] maze){
         /* 4x4 solution matrix
		   0   0   0   0
		   0   0   0   0
		   0   0   0   0
		   when when rat traverses, 0 becomes 1
		   to tell that rat already traversed */
        int[][] solution = new int[n][n];
        if (!solveMazeUtil(maze, 0, 0, solution)){
            System.out.println("no solution exists");
            return;
        }
        printSolution(solution);
    }

    /* 5. print solution */
    void printSolution(int[][] solution){
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                System.out.print(solution[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        RatInMaze rat = new RatInMaze();
        /* 1. create maze */
        int[][] maze = {
                {1,0,1},
                {1,1,1},
                {0,0,0},
//                {1,0,0,0},
//                {1,1,1,1},
//                {0,1,0,0},
//                {1,1,1,1}
        };
        n = maze.length;
        rat.solveMaze(maze);
    }
}
