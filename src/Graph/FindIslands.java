package Graph;

public class FindIslands {

    int row, column;
    FindIslands(int row, int column){
        this.row = row;
        this.column = column;
    }

    /* check safe area */
    private boolean isSafe(int[][] island, int i, int j, boolean[][] visited){
        return (i>=0 && j>=0 && i<row && j<column && island[i][j]==1 && !visited[i][j]);
    }

    /* dfs in 8 directions */
    void dfs(int[][] island, int i, int j, boolean[][] visited){
        /* create 8 neighbours */
        int[] rowNumber = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] colNumber = {-1, 0, 1, -1, 1, -1, 0, 1};
        // mark cell visited
        visited[i][j] = true;
        for (int k=0; k<8; k++)
            if (isSafe(island, i+rowNumber[k], j+colNumber[k], visited))
                dfs(island, i + rowNumber[k], j + colNumber[k], visited);
    }

    /* count islands */
    void countIslands(int[][] island){
        boolean[][] visited = new boolean[row][column];
        int count = 0;
        for (int i=0; i<row; i++){
            for (int j=0; j<column; j++){
                if (island[i][j] == 1 && !visited[i][j]) {
                    dfs(island, i, j, visited);
                    count++;
                }
            }
        }
        System.out.println("total number of islands: " + count);
    }

    public static void main(String[] args){
        int[][] matrix = {
                {1,1,1,0},
                {0,1,0,0},
                {0,0,0,1},
                {1,0,1,1}
        };
        FindIslands island = new FindIslands(matrix.length, matrix[0].length);
        island.countIslands(matrix);
    }

}
