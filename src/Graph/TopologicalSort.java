package Graph;
import java.util.LinkedList;
import java.util.Stack;

public class TopologicalSort {

    int vertices;
    LinkedList<Integer>[] adjacent;

    TopologicalSort(int vertices){
        this.vertices = vertices;
        adjacent = new LinkedList[vertices];
        for (int i=0; i<vertices; i++)
            adjacent[i] = new LinkedList<>();
    }

    void addEdge(int source, int destination){
        adjacent[source].add(destination);
    }

    void topologicalSortUtil(int u, boolean[] visited, Stack<Integer> stack){
        visited[u] = true;
        for (int neighbour : adjacent[u]){
            if (!visited[neighbour])
                topologicalSortUtil(neighbour, visited, stack);
        }
        stack.push(u);
    }

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

    public static void main(String[] args){
        TopologicalSort sort = new TopologicalSort(5);
        sort.addEdge(0,1);
        sort.addEdge(0,3);
        sort.addEdge(1,2);
        sort.addEdge(1,3);
        sort.addEdge(3,2);
        sort.addEdge(3,4);
        sort.topologicalSort();
    }

}
