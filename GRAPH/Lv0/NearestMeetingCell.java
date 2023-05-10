public class NearestMeetingCell {
    public static void main(String[] args) {
        SOLVEJUSPAYOA3 object = new SOLVEJUSPAYOA3() ;
        int Vertex = 12 ;
        int[][] edges = new int[][]{
                {0  , 1} ,
                {1  , 2} ,
                {2  , 3} ,
                {3  , 9} ,
                {4  , 2} ,
                {5  , 2} ,
                {6  , 3} ,
                {7  , 3} ,
                {8  , 7} ,
                {9  , 10} ,
                {10 , 11} ,
                {11 , 8} ,
        } ;
        System.out.println(object.GetNearestMeetingCell(0,8,Vertex ,edges));
    }
}
class SOLVEJUSPAYOA3{
    private int NMC = -1 ;
    private int[] adjList ;
    private void MakeAdjList(int Vertex , int[][] edges){
        adjList = new int[Vertex] ;
        for (int i = 0 ; i < Vertex ; i ++)
            adjList[i] = -1 ;
        for (int[] val : edges)
            adjList[val[0]] = val[1] ;

    }
    public int GetNearestMeetingCell(int src1 , int src2 , int Vertex , int[][] edges){
        MakeAdjList(Vertex , edges);
        if(adjList[src2] == -1)
            return src2 ;
        if(adjList[src1] == -1)
            return src1 ;
        if(adjList[src1] == -1 && adjList[src2] == -1)
            return NMC ;
        boolean[] visited = new boolean[Vertex] ;
        UpdateNMC(src1 , src2 , visited) ;
        return NMC ;
    }
    private void UpdateNMC(int src1 , int src2 , boolean[] visited){
        visited[src1] = true ;
        visited[src2] = true ;

        int neighbor1 = adjList[src1] ;
        int neighbor2 = adjList[src2] ;

        // lose ends :::
        if(neighbor1 == -1)
            neighbor1 = src1 ;
        if(neighbor2 == -1)
            neighbor2 = src2 ;
        if(neighbor1 == -1 && neighbor2 == -1){
            if(neighbor1 == neighbor2)
                NMC = neighbor1;
            else
                NMC = -1 ;
            return ;
        }


        if(visited[neighbor1] || visited[neighbor2]){
            if(visited[neighbor1])
                NMC = neighbor1 ;
            else
                NMC = neighbor2 ;
            return ;
        }
        else {
            UpdateNMC(neighbor1, neighbor2, visited);
        }
    }
}
