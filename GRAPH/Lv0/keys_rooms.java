import java.util.*;

// Get some rest and solve this one :

public class keys_rooms {
    public static void main(String[] args) {
        solutionG14 object = new solutionG14() ;
        List<List<Integer>> answer = new ArrayList<>() ;
        System.out.print("Number of vertex's : ");
        int vertex = new Scanner(System.in).nextInt() ;
        for(int i = 0 ; i < vertex ; i++){
            List<Integer> _list_ = new ArrayList<>() ;
            System.out.print("Numbers Neighbour's of "+i+" ->");
            int len = new Scanner(System.in).nextInt() ;
            if(len != -1) {
                System.out.println();
                for (int j = 0; j < len; j++) {
                    System.out.print("Neighbours of "+i+" ->");
                    int val = new Scanner(System.in).nextInt();
                    _list_.add(val);
                    System.out.println();
                }
            }
            answer.add(new ArrayList<>(_list_)) ;
            System.out.println(answer);
        }
        System.out.println("Graph is "+object.canVisitAllRooms(answer)) ;
    }
}
class solutionG14{
    public String canVisitAllRooms(List<List<Integer>> rooms) {
        // build logic here ->
        boolean[] visited = new boolean[rooms.size()] ;

        _is_visited_(0,rooms,visited) ;
        for(int i = 0 ; i < rooms.size() ; i++){
            if(!visited[i])
                return " not connected !" ;
        }


        return " connected ." ;
    }

    private void _is_visited_(int i, List<List<Integer>> rooms, boolean[] visited) {
        visited[i] = true ;
        for(int neighbor : rooms.get(i)){
            if(!visited[neighbor])
                _is_visited_(neighbor , rooms , visited);
        }
    }
}
