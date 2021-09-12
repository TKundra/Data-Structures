package Graph;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

// using Kosaraju's Algorithm
public class StronglyConnectedComponents {

    static class Graph{
        int vertices;
        LinkedList<Integer>[] adjacent;

        Graph(int v){
            vertices = v;
            adjacent = new LinkedList[vertices];
            for (int i=0; i<vertices; i++)
                adjacent[i] = new LinkedList<>();
        }

        // directed graph
        void addEdge(int source, int destination){
            adjacent[source].add(destination);
        }

        // dfs
        void dfsUtil(int v, boolean[] visited){
            visited[v] = true;
            System.out.print(v+" ");
            for (int neighbour : adjacent[v]){
                if (!visited[neighbour])
                    dfsUtil(neighbour, visited);
            }
        }

        // reverse graph
        Graph getTranspose(){
            Graph graph = new Graph(vertices);
            for (int i=0; i<vertices; i++){
                for (int v : adjacent[i])
                    graph.adjacent[v].add(i);
            }
            return graph;
        }

        // apply dfs on input graph and maintain stack of order
        void order(int v, boolean[] visited, Stack<Integer> stack){
            visited[v] = true;
            for (int neighbour : adjacent[v]){
                if (!visited[neighbour])
                    order(neighbour, visited, stack);
            }
            stack.push(v);
        }

        // print connected components by applying dfs on reverse graph
        void print(){
            Stack<Integer> stack = new Stack<>();
            boolean[] visited = new boolean[vertices];

            // mark all vertices not visited
            for (int i=0; i<vertices; i++)
                visited[i] = false;

            // fill vertices in stack according to their finishing time
            for (int u=0; u<vertices; u++) {
                if (!visited[u])
                    order(u, visited, stack);
            }

            // create reverse graph
            Graph graph = getTranspose();

            // mark all vertices not visited
            for (int i=0; i<vertices; i++)
                visited[i] = false;

            // now process all vertices in order defined by stack
            while (!stack.isEmpty()){
                int v = stack.pop();
                // print strongly connected components
                if (!visited[v]) {
                    graph.dfsUtil(v, visited);
                    System.out.println();
                }
            }

        }

    }

    public static void main(String[] args){
        Graph graph = new Graph(5);
        graph.addEdge(1,0);
        graph.addEdge(0,2);
        graph.addEdge(2,1);
        graph.addEdge(0,3);
        graph.addEdge(3,4);
        graph.print();
    }

}
