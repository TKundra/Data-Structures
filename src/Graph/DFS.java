package Graph;
import java.util.LinkedList;

public class DFS {

    /* List Representation */
    int vertices;
    LinkedList<Integer>[] adjacent;
    boolean[] visited;

    DFS(int vertices){
        this.vertices = vertices;
        adjacent = new LinkedList[vertices];
        visited = new boolean[vertices];
        /*
            0 -> 1 -> 2 -> 3
            1 -> 0 -> 2
            2 -> 0 -> 1
            3 -> 0
        */
        for (int i=0; i<vertices; i++)
            adjacent[i] = new LinkedList<>();
    }

    void addEdge(int source, int destination){
        /* undirected graph */
        adjacent[source].add(destination);
        adjacent[destination].add(source);
    }

    void dfsUtil(int source, boolean[] visited){
        visited[source] = true;
        System.out.print(source+" ");
        for (int neighbour : adjacent[source]){
            if (!visited[neighbour]) {
                dfsUtil(neighbour, visited);
            }
        }
    }

    void dfs(int source){
        boolean[] visited = new boolean[vertices];
        dfsUtil(source, visited);
    }

    public static void main(String[] args){
        DFS dfs = new DFS(5);
        dfs.addEdge(0,1);
        dfs.addEdge(1,2);
        dfs.addEdge(0,2);
        dfs.addEdge(2,4);
        dfs.addEdge(0,3);
        dfs.dfs(0);
    }
}
