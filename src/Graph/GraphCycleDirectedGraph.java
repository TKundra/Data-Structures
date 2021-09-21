package Graph;
import java.util.LinkedList;

public class GraphCycleDirectedGraph {
    /* List Representation */
    int vertices;
    LinkedList<Integer>[] adjacent;

    GraphCycleDirectedGraph(int vertices){
        this.vertices = vertices;
        adjacent = new LinkedList[vertices];
        for (int i=0; i<vertices; i++)
            adjacent[i] = new LinkedList<>();
    }

    void addEdge(int source, int destination){
        /* directed graph */
        adjacent[source].add(destination);
    }

    /*  if present in order, return true */
    boolean isCyclicUtil(int v, boolean[] visited, boolean[] order){
        visited[v] = true;
        order[v] = true;
        for (int neighbour : adjacent[v]) {
            if (!visited[neighbour]) {
                if (isCyclicUtil(neighbour, visited, order))
                    return true;
            }else if (order[neighbour])
                return true;
        }
        /*  when backtrack in dfs we making that node absent which was present in order */
        /* but not making visited false to preserve from cycle */
        order[v] = false;
        return false;
    }

    // return true if cycle present
    boolean isCyclic(){
        boolean[] visited = new boolean[vertices];
        boolean[] order = new boolean[vertices];
        // mark all vertices false
        for (int i=0; i<vertices; i++) {
            visited[i] = false;
            order[i] = false;
        }
        // call recursive helper function to detect cycle in different DFS trees
        for (int u=0; u<vertices; u++) {
            if (!visited[u])
                if (isCyclicUtil(u, visited, order))
                    return true;
        }
        return false;
    }

    public static void main(String[] args){
        GraphCycleDirectedGraph dfs = new GraphCycleDirectedGraph(4);
        dfs.addEdge(0,1);
        dfs.addEdge(0,2);
        dfs.addEdge(1,2);
        dfs.addEdge(2,0);
        dfs.addEdge(2,3);
        dfs.addEdge(3,3);
        if (dfs.isCyclic())
            System.out.println("yup");
        else
            System.out.println("not");
    }

}

