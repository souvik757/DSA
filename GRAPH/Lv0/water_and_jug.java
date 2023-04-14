import java.util.* ;
public class water_and_jug {
    public static void main(String[] args) {
        solutionG24 object = new solutionG24() ;
        System.out.println(object.canMeasureWater(3,5,4)) ;
        System.out.println(object.canMeasureWater(2,6,5)) ;
        System.out.println(object.canMeasureWater(1,2,3)) ;
    }
}
class solutionG24{
    public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        int A = jug1Capacity   ;
        int B = jug2Capacity   ;
        int C = targetCapacity ;
        if(A + B == C)
            return true ;
        if(A+B < C || (A%2==0 && B%2==0 && C%2 != 0))
            return false ;


        return CanMeasurable(A,B,C) ;
    }

    private boolean CanMeasurable(int A, int B, int C) {
        Set<String> visited = new HashSet<>() ;
        Queue<int[]> queue = new LinkedList<>() ;
        queue.add(new int[]{0,0}) ;

        while (queue.size() > 0){
            int[] front = queue.remove() ;
            int a = front[0] ;
            int b = front[1] ;
            if(a + b == C || a == C || b == C)  // condition fulfilled !
                return true ;
            visited.add(a+","+b) ;

            if(!visited.contains(0+","+b))
                queue.add(new int[]{0,b}) ; // 1. Empty jug1
            if(!visited.contains(a+","+0))
                queue.add(new int[]{a,0}) ; // 2. Empty jug2
            if(!visited.contains(A+","+b))
                queue.add(new int[]{A,b}) ; // 3. Full  jug1
            if(!visited.contains(a+","+B))
                queue.add(new int[]{a,B}) ; // 4. Full  jug2
            if(!visited.contains(a-Math.min(a,B-b)+","+b+Math.min(a,B-b)))
                queue.add(new int[]{a-Math.min(a,B-b) , b+Math.min(a,B-b)}) ; // 5. pour from A -> B
            if(!visited.contains(a+Math.min(b,A-a)+","+(b-Math.min(b,A-a))))
                queue.add(new int[]{a+Math.min(b,A-a) , b-Math.min(b,A-a)}) ; // 6. pour from B -> A
        }


        return false;
    }
}
