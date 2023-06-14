public class _2511_EnemyFortsToCapture {
    public static void main(String[] args) {
        System.out.println(SOLVE_2511.captureForts(new int[]{1,0,0,-1,0,0,0,0,1}));
        System.out.println(SOLVE_2511.captureForts(new int[]{0,0,1,-1}));
        System.out.println(SOLVE_2511.captureForts(new int[]{0,-1}));
        System.out.println(SOLVE_2511.captureForts(new int[]{1,0}));
        System.out.println(SOLVE_2511.captureForts(new int[]{0,0}));
        System.out.println(SOLVE_2511.captureForts(new int[]{-1,0,0,-1,0,0,1,0,0,0,0,-1}));
    }
}
class SOLVE_2511{
    public static int captureForts(int[] forts) {
        int MaxLength = Integer.MIN_VALUE ;
        int i = GetOnePos(forts) ;
        if(i != -1) {
            int j = i + 1;
            while (j < forts.length) {
                if (forts[j] == -forts[i]) {
                    MaxLength = Math.max(MaxLength, j - i - 1);
                    i = j;
                }
                else if(forts[j] == forts[i])
                    i = j ;
                j++;
            }
        }
        return (MaxLength == Integer.MIN_VALUE) ? 0 : MaxLength ;
    }
    private static int GetOnePos(int[] forts){
        for (int i = 0 ; i < forts.length ; i ++){
            if(forts[i] == 1 || forts[i] == -1)
                return i ;
        }
        return -1 ;
    }
}
