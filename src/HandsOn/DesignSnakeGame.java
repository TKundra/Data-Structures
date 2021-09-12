package HandsOn;

/*
    snake can move in a given direction and when it eats the food,
    length of snake increases.
    when snake crosses itself, the game will over.
    food will be generated at a given interval.
*/

import java.util.LinkedList;

// enum for different cell types
enum CellType {
    EMPTY, FOOD, SNAKE_NODE
}

// to represent cell of display board
class Cell {
    private final int row, col;
    private CellType cellType;

    Cell(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public CellType getCellType(){ return cellType; }
    public void setCellType(CellType cellType){ this.cellType = cellType; }

    public int getRow(){ return row; }
    public int getCol(){ return col; }

}

// snake class which contain body and head
// we use LinkedList to store body bcz we can add cell in O(1)
// Grow method will be called when it eats the food.
class Snake {
    private LinkedList<Cell> snakePart = new LinkedList<>();
    private Cell head;

    public Snake(Cell initPos){
        head = initPos;
        snakePart.add(head);
        head.setCellType(CellType.SNAKE_NODE);
    }

    public void grow(){ snakePart.add(head); }

    public void move(Cell nextCell){
        System.out.println("snake is moving to "
                + nextCell.getRow() + " " + nextCell.getCol());
        Cell tail = snakePart.removeLast();
        tail.setCellType(CellType.EMPTY);
        head = nextCell;
        head.setCellType(CellType.SNAKE_NODE);
        snakePart.addFirst(head);
    }

    public boolean checkCrash(Cell nextCell){
        System.out.println("going to check for crash");
        for (Cell cell : snakePart){
            if (cell == nextCell)
                return true;
        }
        return false;
    }

    public LinkedList<Cell> getSnakePart(){ return snakePart; }
    public void setSnakePart(LinkedList<Cell> snakePart){ this.snakePart = snakePart; }

    public Cell getHead(){ return head; }
    public void setHead(){ this.head = head; }

}

class Board {

    final int ROW_COUNT, COL_COUNT;
    private Cell[][] cells;

    public Board(int rowCount, int columnCount) {
        ROW_COUNT = rowCount;
        COL_COUNT = columnCount;

        cells = new Cell[ROW_COUNT][COL_COUNT];
        for (int row = 0; row < ROW_COUNT; row++) {
            for (int column = 0; column < COL_COUNT; column++) {
                cells[row][column] = new Cell(row, column);
            }
        }
    }

    public Cell[][] getCells() { return cells; }
    public void setCells(Cell[][] cells) { this.cells = cells; }

    public void generateFood() {
        System.out.println("Going to generate food");
        int row, column;
        while(true){
            row = (int)(Math.random() * ROW_COUNT);
            column = (int)(Math.random() * COL_COUNT);
            if(cells[row][column].getCellType()!=CellType.SNAKE_NODE)
                break;
        }
        cells[row][column].setCellType(CellType.FOOD);
        System.out.println("Food is generated at: " + row + " " + column);
    }
}

class Game {
    public static final int DIRECTION_NONE = 0, DIRECTION_RIGHT = 1,
            DIRECTION_LEFT = -1, DIRECTION_UP = 2, DIRECTION_DOWN = -2;
    private Snake snake;
    private Board board;
    private int direction;
    private boolean gameOver;

    public Game(Snake snake, Board board) {
        this.snake = snake;
        this.board = board;
    }

    public Snake getSnake() { return snake; }
    public void setSnake(Snake snake) { this.snake = snake; }

    public Board getBoard() { return board; }
    public void setBoard(Board board) { this.board = board; }

    public boolean isGameOver() { return gameOver; }

    public void setGameOver(boolean gameOver) { this.gameOver = gameOver; }

    public int getDirection() { return direction; }
    public void setDirection(int direction) { this.direction = direction; }

    // We need to update the game at regular intervals,
    // and accept user input from the Keyboard.
    public void update() {
        System.out.println("Going to update the game");
        if (!gameOver) {
            if (direction != DIRECTION_NONE) {
                Cell nextCell = getNextCell(snake.getHead());

                if (snake.checkCrash(nextCell)) {
                    setDirection(DIRECTION_NONE);
                    gameOver = true;
                }
                else {
                    snake.move(nextCell);
                    if (nextCell.getCellType() == CellType.FOOD) {
                        snake.grow();
                        board.generateFood();
                    }
                }
            }
        }
    }

    private Cell getNextCell(Cell currentPosition) {
        System.out.println("Going to find next cell");
        int row = currentPosition.getRow();
        int col = currentPosition.getCol();

        if (direction == DIRECTION_RIGHT) {
            col++;
        }
        else if (direction == DIRECTION_LEFT) {
            col--;
        }
        else if (direction == DIRECTION_UP) {
            row--;
        }
        else if (direction == DIRECTION_DOWN) {
            row++;
        }

        Cell nextCell = board.getCells()[row][col];

        return nextCell;
    }

    public static void main(String[] args) {
        System.out.println("Going to start game");

        Cell initPos = new Cell(0, 0);
        Snake initSnake = new Snake(initPos);
        Board board = new Board(10, 10);
        Game newGame = new Game(initSnake, board);
        newGame.gameOver = false;
        newGame.direction = DIRECTION_RIGHT;

        // We need to update the game at regular intervals,
        // and accept user input from the Keyboard.

        // here I have just called the different methods
        // to show the functionality
        for (int i = 0; i < 5; i++) {
            if (i == 2)
                newGame.board.generateFood();
            newGame.update();
            if (i == 3)
                newGame.direction = DIRECTION_RIGHT;
            if (newGame.gameOver == true)
                break;
        }
    }
}
