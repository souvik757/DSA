import java.util.* ;
public class SOLVEDAY1 {
    // QUES. 202
    public boolean isHappy(int n) {
        // Set is a useful choice in here to store iterated or visited numbers formed by the conditions of the question .
        List<Integer> _set_ = new ArrayList<>() ;

        while (n != 1 && !_set_.contains(n)){ // Run Time depends on the number of iterations , so as Space .
            _set_.add(n) ;
            int sum = 0 ;
            while (n!=0){
                int digit = n % 10 ;
                sum += Math.pow(digit,2) ;
                n = n/10 ;
            }
            n = sum ;
        }
        // 2 potential outcomes are expected here .
        // 1 . It will lead to 1 , then it will stop , Why ?
        //   - After turning to 1 it cannot be any -VE number by the calculation so ,
        //     it has to be any +VE number , there are probabilities
        //     that it will turn to a number that had been already iterated ,
        //     in that case it will come out of the loop .  AND answer will be TRUE .
        //2 .  Or it might lead to a number which is already iterated ( without turning to 1 )
        //   - in that case it will also come out of the loop and eventually end up returning FALSE .

        return n == 1 ;
    }
    // QUES. 54
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> _list_ = new ArrayList<>() ;
        if(matrix == null || matrix.length == 0)
            return _list_ ;
        int RowStart = 0 ;
        int RowEnd   = matrix.length - 1 ;
        int ColStart = 0 ;
        int ColEnd   = matrix[0].length - 1 ;

        int direction = 0 ;
        while (RowStart <= RowEnd && ColStart <= ColEnd){
            switch (direction) {
                case 0 -> { // ----> RIGHT
                    for (int i = ColStart; i <= ColEnd; i++)
                        _list_.add(matrix[RowStart][i]);
                    RowStart++;
                }
                case 1 -> { // ----> DOWN
                    for (int i = RowStart; i <= RowEnd; i++)
                        _list_.add(matrix[i][ColEnd]);
                    ColEnd--;
                }
                case 2 -> { // ----> LEFT
                    for (int i = ColEnd; i >= ColStart; i--)
                        _list_.add(matrix[RowEnd][i]);
                    RowEnd--;
                }
                case 3 -> { // ----> UP
                    for (int i = RowEnd; i >= RowStart; i--)
                        _list_.add(matrix[i][ColStart]);
                    ColStart++;
                }
            }
            direction = (direction+1) % 4 ;
        }

        return _list_ ;
    }



    // QUES. 1706 *** VVI

    public int[] findBall(int[][] grid) {
        int[] ANSWER = new int[grid[0].length] ;
        for (int i = 0; i < grid[0].length; i++) {
            ANSWER[i] = CanGetOut(grid, 0, i) ;
        }
        return ANSWER ;
    }
    // dfs function --->
    private int CanGetOut(int[][] grid , int i ,int j){
        if ( i == grid.length )
            return j ;
        if ( (grid[i][j] == 1 && (j == grid[0].length - 1 || grid[i][j + 1] == -1)) ||
                 (grid[i][j] == -1 && (j == 0 || grid[i][j - 1] == 1)))
            return -1;


        if (grid[i][j] == 1)
            return CanGetOut(grid , i+1 , j+1) ;
        else
            return  CanGetOut(grid , i+1 , j-1) ;
    }
}
