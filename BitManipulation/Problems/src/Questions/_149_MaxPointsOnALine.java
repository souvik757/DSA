package Questions;

import java.util.HashMap;
import java.util.Map;

public class _149_MaxPointsOnALine {
    public int maxPoints(int[][] points) {
        int count = 0 ;
        if(points.length <= 2)
            return points.length ;
        else {
            for (int i = 0 ; i < points.length ; i ++){
                int max = 0 ;
                Map<Double,Integer> angleMap = new HashMap<>() ;
                for (int j = 0 ; j < points.length ; j ++){
                    if(i == j)
                        continue ;
                    double dy = (double) points[j][1] - points[i][1] ;
                    double dx = (double) points[j][0] - points[i][0] ;
                    double theta = Math.atan(dy/dx) ;
                    angleMap.put(theta , angleMap.getOrDefault(theta,0)+1) ;
                    max = Math.max(max , angleMap.getOrDefault(theta , 0)) ;
                }
                count = Math.max(count , max + 1) ;
            }
        }
        return count ;
    }
}
