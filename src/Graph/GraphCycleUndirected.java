package Graph;
import java.util.LinkedList;

public class GraphCycleUndirected {
    /* List Representation */
    int vertices;
    LinkedList<Integer>[] adjacent;

    GraphCycleUndirected(int vertices){
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

    /*  function uses visited[] and parent to detect cycle 
        in sub-graph reachable from vertex v */
    boolean isCyclicUtil(int v, boolean[] visited, int parent){
        visited[v] = true;
        for (int neighbour : adjacent[v]) {
            if (!visited[neighbour]) {
                if (isCyclicUtil(neighbour, visited, v))
                    return true;
            }
            // if adjacent is visited and not parent of current vertex v, there is cycle
            else if (neighbour != parent) {
                return true;
            }
        }
        return false;
    }

    // return true if cycle present
    boolean isCyclic(){
        boolean[] visited = new boolean[vertices];
        // mark all vertices false
        for (int i=0; i<vertices; i++)
            visited[i] = false;
        // call recursive helper function to detect cycle in different DFS trees
        for (int u=0; u<vertices; u++) {
            if (!visited[u]) {
                if (isCyclicUtil(u, visited, -1))
                    return true;
            }
        }
        return false;
    }
    
    public static void main(String[] args){
        GraphCycleUndirected dfs = new GraphCycleUndirected(4);
        dfs.addEdge(0,1);
        dfs.addEdge(1,2);
        dfs.addEdge(2,3);
        dfs.addEdge(1,3);
        if (dfs.isCyclic())
            System.out.println("yup");
        else
            System.out.println("not");
    }
    
}
