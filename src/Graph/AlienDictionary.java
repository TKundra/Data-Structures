package Graph;
import java.util.LinkedList;
import java.util.Stack;

class Graph {
    int vertices;
    LinkedList<Integer>[] adjacent;
    Graph(int vertices){
        this.vertices = vertices;
        adjacent = new LinkedList[vertices];
        for (int i=0; i<vertices; i++)
            adjacent[i] = new LinkedList<>();
    }

    // directed graph
    void addEdge(int source, int destination){
        adjacent[source].add(destination);
    }

    // topological sort utility
    void topologicalSortUtil(int v, boolean[] visited, Stack<Integer> stack){
        // recursive for all adjacents
        visited[v] = true;
        for (int neighbour : adjacent[v]){
            if (!visited[neighbour])
                topologicalSortUtil(neighbour, visited, stack);
        }
        // store result when recursion out
        stack.push(v);
    }
    void topologicalSort(){
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[vertices];
        for (int i=0; i<vertices; i++)
            visited[i] = false;
        for (int u=0; u<vertices; u++) {
            if (!visited[u])
                topologicalSortUtil(u,visited,stack);
        }
        // print topological sort of graph
        while (!stack.isEmpty())
            System.out.print((char)('a'+stack.pop())+" ");
    }
}

public class AlienDictionary {

    /*  this function finds and the prints order of character from a sorted array
        of words.
        if alpha is 7, then words[] should contain words having only
        'a', 'b', 'c', 'd', 'e', 'f', 'g'
        if alpha is 3 then
        'a', 'b', 'c'
    */
    void printOrder(String[] words, int alpha){
        // create graph with alpha edges
        Graph graph = new Graph(alpha);
        for (int i=0; i<words.length-1; i++){
            // take current two words and find first mismatching character
            String word1 = words[i];
            String word2 = words[i+1];
            for (int j=0; j<Math.min(word1.length(), word2.length()); j++){
                // if we find a mismatching character, then add an edge from
                // character of word1 to word2
                if (word1.charAt(j) != word2.charAt(j)){
                    graph.addEdge(word1.charAt(j)-'a', word2.charAt(j)-'a');
                    break;
                }
            }
        }
        // find topological sort
        graph.topologicalSort();
    }

    public static void main(String[] args){
        AlienDictionary alienDictionary = new AlienDictionary();
        String[] words = {"baa", "abcd", "abca", "cab", "cad"};
        alienDictionary.printOrder(words, 4);
    }

}
