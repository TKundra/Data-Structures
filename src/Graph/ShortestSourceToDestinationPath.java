package Graph;

import java.util.LinkedList;
import java.util.Queue;
/*
    1. We start from the source cell and calls BFS procedure.
    2. We maintain a queue to store the coordinates of the matrix and initialize it with the source cell.
    3. We also maintain a Boolean array visited of same size as our input matrix and initialize all its
       elements to false.
        a. We LOOP till queue is not empty
        b. Dequeue front cell from the queue
        c. Return if the destination coordinates have reached.
        d. For each of its four adjacent cells, if the value is 1 and they are not visited yet, we
           enqueue it in the queue and also mark them as visited. */

public class ShortestSourceToDestinationPath {

    static int ROW = 9;
    static int COL = 10;

    // to store matrix cell coordinates
    static class Point {
        int x;
        int y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    // data structure for queue used in BFS
    static class Node {
        Point point; // coordinates of a cell
        int distance; // cell's distance of from the source
        public Node(Point pair, int distance) {
            this.point = pair;
            this.distance = distance;
        }
    };

    // is valid
    boolean isValid(int row, int col, int[][] graph, boolean[][] visited) {
        return (row >= 0) && (row < ROW) && (col >= 0) && (col < COL) && graph[row][col] == 1 && !visited[row][col];
    }

    /*  These arrays are used to get row and column
        numbers of 4 neighbours of a given cell */
    int[] rowNum = {-1, 0, 0, 1};
    int[] colNum = {0, -1, 1, 0};

    int find(int[][] graph, Point source, Point destination){
        // check source and destination cell of the matrix have value 1
        if (graph[source.x][source.y] != 1 || graph[destination.x][destination.y] != 1)
            return -1;
        boolean[][] visited = new boolean[ROW][COL];
        Queue<Node> queue = new LinkedList<>();
        Node node = new Node(source,0);
        // visited true and add staring point
        visited[source.x][source.y] = true;
        queue.add(node);

        while (!queue.isEmpty()){
            node = queue.remove();
            Point point = node.point;
            // If we have reached the destination cell
            if (point.x == destination.x && point.y == destination.y)
                return node.distance;
            // otherwise enqueue its adjacent cells
            for (int i=0; i<4; i++){
                int row = point.x + rowNum[i];
                int col = point.y + colNum[i];
                // if adjacent cell is valid, has path and not visited yet, enqueue it.
                if (isValid(row, col, graph, visited)){
                    visited[row][col] = true;
                    Node adjNode = new Node((new Point(row,col)), node.distance+1);
                    queue.add(adjNode);
                }
            }
        }
        // Return -1 if destination cannot be reached
        return -1;
    }

    public static void main(String[] args){
        int[][] graph = {
                { 1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
                { 1, 0, 1, 0, 1, 1, 1, 0, 1, 1 },
                { 1, 1, 1, 0, 1, 1, 0, 1, 0, 1 },
                { 0, 0, 0, 0, 1, 0, 0, 0, 0, 1 },
                { 1, 1, 1, 0, 1, 1, 1, 0, 1, 0 },
                { 1, 0, 1, 1, 1, 1, 0, 1, 0, 0 },
                { 1, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
                { 1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
                { 1, 1, 0, 0, 0, 0, 1, 0, 0, 1 }
        }; // source (0,0) destination (3,4)

        ShortestSourceToDestinationPath path = new ShortestSourceToDestinationPath();
        Point source = new Point(0,0);
        Point destination = new Point(3,4);
        int distance = path.find(graph, source, destination);
        if (distance == -1)
            System.out.println("Shortest Path doesn't exist");
        else
            System.out.println("Shortest Path is " + distance);
    }

}
