import java.util.HashSet;
import java.util.Map ;
import java.util.HashMap ;
import java.util.LinkedList ;
import java.util.Set ;
public class _1857_LargestColorValue {
    public static void main(String[] args) {
        SOLVE1857 object = new SOLVE1857() ;
        System.out.println(object.largestPathValue("abaca" ,
                new int[][]{
                        { 0 , 1 } ,
                        { 0 , 2 } ,
                        { 2 , 3 } ,
                        { 3 , 4 }
                }));
    }
}
class SOLVE1857{
    private int MaxCount ;
    private Map<Integer, int[]> FrequencyMap ;
    private LinkedList<Integer>[] adjList ;
    private void MakeAdjList(int Vertex , int[][] edges){
        MaxCount = 0 ;
        FrequencyMap = new HashMap<>() ;
        adjList = new LinkedList[Vertex] ;
        for (int i = 0 ; i < Vertex ; i ++)
            adjList[i] = new LinkedList<>() ;
        for (int[] val : edges)
            adjList[val[0]].add(val[1]) ;
    }
    public int largestPathValue(String colors, int[][] edges) {
        int Vertex = colors.length() ;
        MakeAdjList(Vertex , edges) ;
        for (int i = 0 ; i < Vertex ; i ++){
            if(toposortByDfs(i, new HashSet<>(), colors) == -1)
                return -1 ;
        }
        return MaxCount ;
    }
    private int toposortByDfs(int src , Set<Integer> visited , String colors){
        if(visited.contains(src))
            return -1 ;
        visited.add(src) ;
        int[] freq = new int[26] ;
        for (int neighbour : adjList[src]){
            if(!FrequencyMap.containsKey(neighbour))
                return toposortByDfs(neighbour, visited, colors) ;
            int[] NeighborFreq = FrequencyMap.get(neighbour) ;
            for (int i = 0 ; i < 26 ; i ++)
                freq[i] = Math.max(freq[i], NeighborFreq[i]) ;
        }
        freq[colors.charAt(src)-'a']++ ;
        for (int frequency : freq)
            MaxCount = Math.max(MaxCount , frequency) ;
        FrequencyMap.put(src , freq) ;
        // mark src as unvisited while returning :::
        visited.remove(src) ;
        return 0 ;
    }
}
