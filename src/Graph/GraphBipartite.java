package Graph;
import java.util.LinkedList;
import java.util.Queue;

public class GraphBipartite {

    int vertices;
    LinkedList<Integer>[] adjacent;
    GraphBipartite(int vertices){
        this.vertices = vertices;
        adjacent = new LinkedList[vertices];
        for (int i=0; i<vertices; i++)
            adjacent[i] = new LinkedList<>();
    }

    // undirected graph
    void addEdge(int source, int destination){
        adjacent[source].add(destination);
        adjacent[destination].add(source);
    }

    boolean isBipartite(int v){
        boolean[] visited = new boolean[vertices];
        int[] level = new int[vertices];
        Queue<Integer> queue = new LinkedList<>();
        // mark visited, make initial level 0, add in queue
        visited[v] = true;
        queue.add(v);
        level[v] = 0;
        // bfs
        while (!queue.isEmpty()){
            v = queue.remove();
            for (int neighbour : adjacent[v]){
                if (!visited[neighbour]){
                    visited[neighbour] = true;
                    // set level one more than level of parent
                    level[neighbour] = level[v]+1;
                    queue.add(neighbour);
                }
                // if vertex visited and level are same,
                // then graph contain odd cycle, not bipartite
                else if (level[neighbour] == level[v])
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        GraphBipartite graphBipartite = new GraphBipartite(5);
        graphBipartite.addEdge(0,1);
        graphBipartite.addEdge(0,2);
        graphBipartite.addEdge(1,3);
        graphBipartite.addEdge(2,4);
        graphBipartite.addEdge(3,2);
        graphBipartite.addEdge(1,4);
        if (graphBipartite.isBipartite(0))
            System.out.println("yes");
        else
            System.out.println("no");
    }

}
