package Graph;

public class FloodFill {
    int ROW;
    int COL;
    FloodFill(int ROW, int COL){
        this.ROW = ROW;
        this.COL = COL;
    }

    // is safe to fill
    boolean isSafe(int row, int col, int[][] screen, int prevColor){
        return (row>=0 && row<ROW && col>=0 && col<COL && screen[row][col] == prevColor);
    }

    // for top, right, bottom, left
    int[] rowNumber = {1, -1, 0 , 0};
    int[] colNumber = {0, 0, 1 , -1};

    // using DFS
    void floodFillUtil(int[][] screen, int x, int y, int target, int prevColor){
        for (int k=0; k<4; k++){
            if (isSafe(x+rowNumber[k], y+colNumber[k], screen, prevColor)){
                screen[x+rowNumber[k]][y+colNumber[k]] = target;
                floodFillUtil(screen, x+rowNumber[k], y+colNumber[k], target, prevColor);
            }
        }
    }

    public static void main(String[] args){
        int[][] screen = {
                {1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 0, 0},
                {1, 0, 0, 1, 1, 0, 1, 2},
                {1, 2, 2, 2, 2, 0, 1, 0},
                {1, 1, 1, 2, 2, 0, 1, 0},
                {1, 1, 1, 2, 2, 2, 2, 0},
                {1, 1, 1, 1, 1, 2, 1, 1},
                {1, 1, 1, 1, 1, 2, 2, 1},
        };
        FloodFill floodFill = new FloodFill(screen.length, screen[0].length);
        int x=4, y=4;
        int prevColor = screen[x][y];
        floodFill.floodFillUtil(screen,x,y,3,prevColor);

        System.out.println("result");
        for (int[] array : screen) {
            for (int j = 0; j < screen[0].length; j++) {
                System.out.print(array[j] + " ");
            }
            System.out.println();
        }

    }
}
