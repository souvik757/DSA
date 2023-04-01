import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DFS {
    public static void main(String[] args){
        List<solve.Pair> edges = new ArrayList<>() ;
        solve result = new solve() ;
        System.out.println("Enter number of vertex ->  "+"\nfollowed by number of edges -> ");
        int vertex = new Scanner(System.in).nextInt() ;
        int NumberOfEdges = new Scanner(System.in).nextInt() ;
        System.out.println("Starting vertex - >");
        int start = new Scanner(System.in).nextInt() ;
        for(int i = 0 ; i < NumberOfEdges ; i++){
            System.out.print("left vertex : ");
            int first = new Scanner(System.in).nextInt() ;
            System.out.print("right vertex : ");
            int end = new Scanner(System.in).nextInt() ;
            System.out.println("edge created - "+first+"------"+end);
            solve.Pair pair = new solve.Pair(first , end) ;
            edges.add(pair) ;
        }
        System.out.println("DFS traversal : "+result._get_traversal_DFS_(start , vertex , edges));
    }
}
