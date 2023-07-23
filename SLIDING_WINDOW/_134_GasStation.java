public class _134_GasStation {
    public static void main(String[] args) {
        solve_134 object = new solve_134() ;
        System.out.println(object.canCompleteCircuit(new int[]{1,2,3,4,5} , new int[]{3,4,5,1,2}));
    }
}
class solve_134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int index = 0 ;
        int total = 0 ;
        int available = 0 ;
        int N = gas.length ;
        for (int i = 0 ; i < N ; i ++){
            total += gas[i] - cost[i] ;
            available += gas[i] - cost[i] ;
            if(available < 0) {
                available = 0;
                index = i + 1;
            }
        }
        if(total < 0)
            return -1 ;
        return index ;
    }
}