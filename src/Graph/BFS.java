package Graph;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {

    /* List Representation */
    int vertices;
    LinkedList<Integer>[] adjacent;

    BFS(int vertices){
        this.vertices = vertices;
        adjacent = new LinkedList[vertices];
        for (int i=0; i<vertices; i++)
            adjacent[i] = new LinkedList<>();
    }

    void addEdge(int source, int destination){
        /* undirected graph */
        adjacent[source].add(destination);
        adjacent[destination].add(source);
    }

    void bfs(int source){
        /* maintains array for visited nodes */
        boolean[] visited = new boolean[vertices];
        Queue<Integer> queue = new LinkedList<>();
        /* mark first element visited */
        visited[source] = true;
        queue.add(source);
        while (!queue.isEmpty()){
            source = queue.poll();
            System.out.print(source+" ");
            /*  get all adjacent vertices of dequeued vertex
			    if a adjacent has not been visited, then mark
			    it visited and enqueued it */
            for (int neighbour : adjacent[source]){
                if (!visited[neighbour]){
                    visited[neighbour] = true;
                    queue.add(neighbour);
                }
            }
        }
    }

    public static void main(String[] args){
        BFS bfs = new BFS(5);
        bfs.addEdge(0,1);
        bfs.addEdge(1,2);
        bfs.addEdge(0,2);
        bfs.addEdge(2,4);
        bfs.addEdge(0,3);
        bfs.bfs(0);
    }
}
