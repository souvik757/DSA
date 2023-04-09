import java.util.LinkedList;
import java.util.Queue;

public class nearest_exit {
    public static void main(String[] args) {
        solutionG12 object = new solutionG12() ;
        System.out.println("Nearest exit by : "+object.nearestExit(new char[][]{
                {'+' ,'+' , '.' , '+'} ,
                {'.' ,'.' , '.' , '+'} ,
                {'+' ,'+' , '+' , '.'}
        } , new int[]{1,2}));
        System.out.println("Nearest exit by : "+object.nearestExit(new char[][]{
                {'+' ,'+' , '+'} ,
                {'.' ,'.' , '.'} ,
                {'+' ,'+' , '+'}
        } , new int[]{1,0}));
        System.out.println("Nearest exit by : "+object.nearestExit(new char[][]{
                {'+' ,'.' , '+' , '+'} ,
                {'.' ,'+' , '.' , '+'} ,
                {'.' ,'.' , '.' , '+'} ,
                {'.' ,'+' , '+' , '+'}
        } , new int[]{1,2}));
    }
}
class solutionG12{
    public int nearestExit(char[][] maze, int[] entrance) {
        maze[entrance[0]][entrance[1]] = '+' ;
        boolean[][] visited = new boolean[maze.length][maze[0].length] ;
        Queue<pairs<Integer,Integer,Integer>> queue = new LinkedList<>() ;
        for(int i = 0 ; i < maze.length ; i++){
            for(int j = 0 ; j < maze[0].length ; j++){
                if (i == 0 || i == maze.length - 1 || j == 0 || j == maze[0].length - 1) {
                    if (!visited[i][j] && maze[i][j] == '.') {
                        visited[i][j] = true;
                        queue.add(new pairs<>(i, j, 0));
                    }
                }
            }
        }
        int NoOfNodes = -1 ;
        while (!queue.isEmpty()){
            int size = queue.size() ;
            while(size-->0){
                assert queue.peek() != null;
                int row = queue.peek().row ;
                int col = queue.peek().column ;
                int distance = queue.poll().distance ;
                int[] delRow = new int[]{-1,0,1,0} ;
                int[] delCol = new int[]{0,1,0,-1} ;
                for(int i = 0 ; i < 4 ; i++){
                    int R = row + delRow[i] ;
                    int C = col + delCol[i] ;
                    if(R>=0 && R< maze.length && C>=0 && C<maze[0].length){
                        if(!visited[R][C] && R==entrance[0] && C==entrance[1])
                            return distance+1 ;
                        else if(!visited[R][C] && maze[R][C] == '.'){
                            visited[R][C] = true ;
                            queue.add(new pairs<>(R,C,distance+1)) ;
                        }
                    }
                }
            }
        }

        return NoOfNodes ;
    }
}
