public class MaximumWeightNode {
    public static void main(String[] args) {
        SOLVEJUSPAYOA2 object = new SOLVEJUSPAYOA2() ;
        int Vertex = 13 ;
        int[][] edges = new int[][]{
                {0  , 1} ,
                {1  , 2} ,
                {2  , 3} ,
                {5  , 2} ,
                {4  , 2} ,
                {6  , 3} ,
                {8  , 3} ,
                {9  , 8} ,
                {10 , 3} ,
                {11 , 8} ,
                {12 , 8} ,
                {13 , 8}
        } ;
//  *      int[][] edges = new int[N][2] ;
//  *      for (int i = 0 ; i < N ; i ++){
//  *          edges[i][0] = i ;
//  *          edges[i][1] = Edge[i] ;
//  *      }
        System.out.println(object.GetMaxWeightNode(Vertex , edges));
    }
}
class SOLVEJUSPAYOA2{
    public int GetMaxWeightNode(int Vertex, int[][] edges) {
        int maxWeight = Integer.MIN_VALUE;
        int maxWeightNode = -1;
        int[] weightSum = new int[edges.length + 1] ;

        for (int[] edge : edges) {
            weightSum[edge[1]] += edge[0];
            if (weightSum[edge[1]] > maxWeight ||
                    (weightSum[edge[1]] >= maxWeight &&
                            edge[1] > maxWeightNode)) {
                maxWeight = weightSum[edge[1]];
                maxWeightNode = edge[1];
            }
        }

        return maxWeightNode;
    }

}
