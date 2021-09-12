package Graph;
import java.util.LinkedList;
import java.util.Stack;

/*  node that contains
    vertex and corresponding weight */
class AdjacentNode{
    int vertex;
    int weight;
    AdjacentNode(int v, int w){
        vertex = v;
        weight = w;
    }
    int getVertex(){ return vertex; }
    int getWeight(){ return weight; }
}

public class ShortestPathDAG {

    static final int INF = Integer.MAX_VALUE;

    /* normal graph */
    int vertices;
    LinkedList<AdjacentNode>[] adjacent;
    ShortestPathDAG(int vertices){
        this.vertices = vertices;
        adjacent = new LinkedList[vertices];
        for (int i=0; i<vertices; i++)
            adjacent[i] = new LinkedList<>();
    }

    /* add node */
    void addEdge(int u, int v, int w){
        AdjacentNode node = new AdjacentNode(v, w);
        adjacent[u].add(node);
    }

    /* topological sort */
    void topologicalSortUtil(int u, boolean[] visited, Stack<Integer> stack){
        visited[u] = true;
        for (AdjacentNode neighbour : adjacent[u]){
            if (!visited[neighbour.getVertex()])
                topologicalSortUtil(neighbour.getVertex(), visited, stack);
        }
        stack.push(u);
    }

    /* just to check sort */
    void topologicalSort(){
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[vertices];
        for (int i=0 ;i<vertices; i++)
            visited[i] = false;
        for (int i=0; i<vertices; i++) {
            if (!visited[i])
                topologicalSortUtil(i, visited, stack);
        }
        while (!stack.isEmpty())
            System.out.print(stack.pop()+" ");
    }

    /*  The function to find shortest paths from given vertex. It
	    uses recursive topologicalSortUtil() to get topological
        sorting of given graph. */
    void shortestPath(int source){
        boolean[] visited = new boolean[vertices];
        int[] distance = new int[vertices];
        Stack<Integer> stack = new Stack<>();

        /*  Call the recursive helper function to store Topological
            Sort starting from all vertices one by one */
        for (int i=0; i<vertices; i++){
            if (!visited[i])
                topologicalSortUtil(i, visited, stack);
        }

        /*  Mark all the vertices as not visited
            Initialize distances to all vertices as infinite and
            distance to source as 0 */
        for (int i=0; i<vertices; i++){
            visited[i] = false;
            distance[i] = INF;
        }
        distance[source] = 0;

        /* process vertices in topological order */
        while (!stack.isEmpty()){
            int u = stack.pop();
            if (distance[u] != INF){
                for (AdjacentNode neighbour : adjacent[u]){
                    if (neighbour.getWeight() + distance[u] < distance[neighbour.getVertex()])
                        distance[neighbour.getVertex()] = neighbour.getWeight() + distance[u];
                }
            }
        }

        /* print the calculated shortest distance */
        for (int i=0; i<vertices; i++) {
            if (distance[i] == INF)
                System.out.println("INF");
            else
                System.out.print(distance[i] + " ");
        }
    }

    public static void main(String[] args){
        ShortestPathDAG shortestPath = new ShortestPathDAG(6);
        shortestPath.addEdge(0,2,5);
        shortestPath.addEdge(0,5,7);
		shortestPath.addEdge(1,0,5);
		shortestPath.addEdge(1,4,2);
		shortestPath.addEdge(2,3,-2);
		shortestPath.addEdge(4,0,2);
		shortestPath.addEdge(4,5,4);
		shortestPath.addEdge(5,2,-1);
		shortestPath.addEdge(5,3,2);
		shortestPath.topologicalSort();
		System.out.println();
		shortestPath.shortestPath(4);
    }
}
