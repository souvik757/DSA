import java.util.* ;
public class ShortestPathInDirectedGraph {
    public static void main(String[] args) {
        ShortestDirected object = new ShortestDirected() ;
        Scanner sc = new Scanner(System.in) ;
        int N = sc.nextInt() ;
        List<List<Integer>> linkedWebpages = new ArrayList<>();
        int[][] edges = new int[N][2] ;
        for (int i = 0; i < N; i++) {
            List<Integer> links = new ArrayList<>();
            while (sc.hasNextInt()) {
                int linkedWebpage = sc.nextInt();
                links.add(linkedWebpage);
            }

            linkedWebpages.add(links);
        }
        int index = 0 ;
        for (int i = 0; i < N; i++) {
            for (int linkedWebpage : linkedWebpages.get(i)) {
                edges[index][0] = index ;
                edges[index][1] = linkedWebpage - 1 ;
            }
            index++ ;
        }
        int src = sc.nextInt() ;
        int dest = sc.nextInt() ;
        System.out.println(object.shortestPath(N , src , dest ,edges));
        sc.close() ;
    }
}

class ShortestDirected {
    private LinkedList<Integer>[] AdjList;

    private void MakeAdjList(int Vertex, int[][] edges) {
        AdjList = new LinkedList[Vertex];
        for (int i = 0; i < Vertex; i++)
            AdjList[i] = new LinkedList<>();
        for (int[] val : edges) {
            AdjList[val[0]].add(val[1]);
        }
    }

    public int shortestPath(int Vertex, int src, int destination, int[][] edges) {
        List<Integer> list = new ArrayList<>();
        MakeAdjList(Vertex, edges);
        boolean[] visited = new boolean[Vertex];
        int[] parent = new int[Vertex];
        Arrays.fill(parent, -1);
        Queue<Integer> queue = new LinkedList();
        queue.add(src); // Start from the source vertex
        visited[src] = true;
        parent[src] = -1;

        while (!queue.isEmpty()) {
            int front = queue.remove();
            for (int neighbor : AdjList[front]) {
                if (visited[neighbor] || neighbor == front)
                    continue;
                visited[neighbor] = true;
                parent[neighbor] = front;
                queue.add(neighbor);
            }
        }

        // Check if there is a path from src to destination
        if (!visited[destination]) {
            return -1 ; // No path found
        }

        int ancestor = destination;
        while (ancestor != -1) {
            list.add(ancestor);
            ancestor = parent[ancestor];
        }

        Collections.reverse(list); // Reverse the list to get the correct order
        return list.size() - 1;
    }
}
// 5

// 2 4
//
// 1
//
// 1 5
//
// 2 3
//
// 5
//
// 2 3