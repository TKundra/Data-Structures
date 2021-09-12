package Arrays;

public class SpiralViewMatrix {

    static void spiralOrder(int[][] matrix, int r, int c){
        int i, sr=0, sc=0;
        // sr - starting row index
        // r - ending row index
        // sc - starting column index
        // c - ending column index
        // i - iterator
        while (sr<r && sc<c){
            // print the first row from remaining rows
            for (i=sc; i<c; i++)
                System.out.print(matrix[sr][i] + " ");
            sr++;
            // print the last column from remaining columns
            for (i=sr; i<r; i++)
                System.out.print(matrix[i][c-1] + " ");
            c--;
            // print the last row from remaining rows
            if (sr<r){
                for (i=c-1; i>=sc; i--)
                    System.out.print(matrix[r-1][i] + " ");
                r--;
            }
            // print the first column from remaining columns
            if (sc<c){
                for (i=r-1; i>=sr; i--)
                    System.out.print(matrix[i][sc] + " ");
                sc++;
            }
        }
    }

    public static void main(String[] args){
        int[][] matrix = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12}
        };
        spiralOrder(matrix, matrix.length, matrix[0].length);
    }
}
