package Graph;
import java.util.LinkedList;
import java.util.Queue;

public class SnakeLadder {

    static class Vertex {
        int cell; // vertex number
        int moves; // distance of this vertex from source
    }

    int getMinimumDiceThrows(int[] board, int n){

        boolean[] visited = new boolean[n];
        Queue<Vertex> queue = new LinkedList<>();

        Vertex vertex = new Vertex();
        vertex.cell = 0;
        vertex.moves = 0;

        // mark node visited and enqueue it
        visited[0] = true;
        queue.add(vertex);

        // do BFS
        while (!queue.isEmpty()){
            vertex = queue.remove();
            int v = vertex.cell;

            // if front vertex is destination
            if (v == n-1)
                break;

            // otherwise dequeue the front vertex and enqueue
            // its adjacent vertices (or cell number reachable through dice)
            for (int j=v+1; j<=(v+6) && j<n; j++){
                // if visited or not
                if (!visited[j]){

                    // otherwise calculate distance and mark visited
                    Vertex current = new Vertex();
                    current.moves = vertex.moves + 1;
                    visited[j] = true;

                    // check if there is snake or ladder at j
                    // then tail of snake or top of ladder become
                    // the adjacent of j
                    if (board[j] != -1) {
                        current.cell = board[j];
                    } else {
                        current.cell = j;
                    }
                    queue.add(current);

                }
            }
        }

        return vertex.moves;
    }

    public static void main(String[] args){
        int N = 36;
        int[] board = new int[N];
        // initialize board with -1
        for (int i=0; i<N; i++) {
            board[i] = -1;
        }
        // ladders
        board[2] = 15;
        board[14] = 35;
        // snakes
        board[17] = 13;
        SnakeLadder snakeLadder = new SnakeLadder();
        System.out.println(snakeLadder.getMinimumDiceThrows(board, N));
    }
}
