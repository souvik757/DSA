import java.util.*;

public class _864_ShortestPathToKeys {
    public static void main(String[] args) {
        SOLVE864 object = new SOLVE864() ;
        System.out.println(object.shortestPathAllKeys(new String[]
                {
                        "@.a..","###.#","b.A.B"
                })
        );
        System.out.println(object.shortestPathAllKeys(new String[]
                {
                        "@..aA","..B#.","....b"
                })
        );
        System.out.println(object.shortestPathAllKeys(new String[]
                {
                        "@Aa"
                })
        );
        System.out.println(object.shortestPathAllKeys(new String[]
                {
                        "@...a",".###A","b.BCc"
                })
        );
    }
}
class SOLVE864 {
    private int[] delrow = new int[]{-1,0,1, 0} ;
    private int[] delcol = new int[]{ 0,1,0,-1} ;
    private int MinLength ;
    private char[][] graph ;
    private void CreateGraph(String[] grid){
        int Row = grid.length ;
        int Col = grid[0].length() ;
        graph = new char[Row][Col] ;
        for (int i = 0 ; i < Row ; i ++){
            for (int j = 0 ; j < Col ; j ++){
                graph[i][j] = grid[i].toCharArray()[j] ;
            }
        }
    }
    public int shortestPathAllKeys(String[] grid) {
        MinLength = Integer.MAX_VALUE ;
        CreateGraph(grid) ;
        int row = graph.length ;
        int col = graph[0].length ;
        int KEYS = TotalKeys(grid) ;
//        System.out.println(KEYS);
        for (char[] c : graph)
            System.out.println(c);
        boolean[][] visited = new boolean[row][col] ;
        Queue<Pair<Integer,Integer>> queue = new LinkedList<>() ;
        Map<Character,Character> map = new HashMap<>() ;
        int ROW = -1 ;
        int COL = -1 ;
        for (int i = 0 ; i < row ; i ++){
            for (int j = 0 ; j < col ; j ++){
                if(graph[i][j] == '@'){
//                    System.out.println(i+" "+" "+j);
                     ROW = i ;
                     COL = j ;
                     break ;
                }
            }
        }
        return UpdateAndTraverse(ROW, COL, KEYS, visited, queue, map) ;
    }
    private int TotalKeys(String[] grid){
        int KeyCount = 0 ;
        for (String sch : grid){
            for(char ch : sch.toCharArray()){
                if(Character.isLowerCase(ch))
                    KeyCount++ ;
            }
        }
        return KeyCount ;
    }
    private int UpdateAndTraverse(int R , int C , int keys ,boolean[][] visited , Queue<Pair<Integer,Integer>> queue
    ,Map<Character,Character> map){
        int length = 0 ;
        int runningLength = Integer.MAX_VALUE ;
        int currentkeys = 0;
        queue.add(new Pair<>(R,C)) ;
        while (!queue.isEmpty()){
//            System.out.println("Inside queue "+"\n"+length);
            if(currentkeys == keys)
                return length ;
            int size = queue.size() ;

            for (int k = 0 ; k < size ; k++){
                Pair<Integer,Integer> front = queue.remove() ;
                int i = front.row ;
                int j = front.column ;
//                System.out.println("\n\n\nInside inner loop");
                for (int index = 0 ; index < 4 ; index++){
                    int nrow = i + delrow[index] ;
                    int ncol = j + delcol[index] ;

                    if(!NotValidGrid(nrow,ncol,visited)) {
                        if(graph[nrow][ncol] == '.'){
                            visited[nrow][ncol] = true ;
                            showadds(nrow,ncol);
                            queue.add(new Pair<>(nrow,ncol)) ;
                        }
                        if(Character.isUpperCase(graph[nrow][ncol])){
                            if(map.get(graph[nrow][ncol]) == null)
                                continue ;
                            if(map.get(graph[nrow][ncol])==Character.toLowerCase(graph[nrow][ncol])){
                                visited[nrow][ncol] = true ;
                                showadds(nrow,ncol);
                                queue.add(new Pair<>(nrow,ncol)) ;
                            }
                        }

                        if(Character.isLowerCase(graph[nrow][ncol])){
                            currentkeys++ ;
                            map.put(Character.toUpperCase(graph[nrow][ncol]) , graph[nrow][ncol]) ;
                            visited[nrow][ncol] = true ;
                            showadds(nrow,ncol);
                            queue.add(new Pair<>(nrow,ncol)) ;
                        }
                    }
                }
                runningLength = Math.min(runningLength , size) ;
                length += runningLength ;
            }

            System.out.println("updated length : "+length);
        }
        return -1 ;
    }
    private void showadds(int i , int j){
        System.out.println(i+" and "+j);
    }
    private boolean NotValidGrid(int i , int j , boolean[][] visited){
        return i < 0 || i >= graph.length || j < 0 || j >= graph[0].length ||
                visited[i][j] || graph[i][j]=='#'  ;
    }
}