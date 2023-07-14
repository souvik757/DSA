import java.util.Arrays;

public class moveNegativeToFirst {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(
                Solution_.separate(new int[]{-16,9,-25,8,44,20,20,-12,11,-44,-32,7,41,13,7,27,-49,-19,-43,6})
        ));
        System.out.println(Arrays.toString(
                Solution_.separate(new int[]{-23,48,-13,31,-12,6,-42,23,14,33,-33,-21,0,25,-39,-31})
        ));
    }
}
class Solution_{
    public static int[] separate(int[] a) {
        int s = 0 ;
        int e = a.length-1 ;
        while (s <= e){
            if (a[s] >= 0 && a[e] >= 0){// all +VE
                e -- ;                // keep checking from right side if there is any -vE available
            }
            else{
                if (a[s] < 0 && a[e] < 0){// all -VE
                    s ++ ;                // try to bring the right -VE to starting end
                }
                else{                    // any one -VE
                    if(a[s] >= 0) {       // if right pointer -VE then swap
                        int temp = a[s] ;
                        a[s] = a[e] ;
                        a[e] = temp ;
                    }                    // shrunk window
                    s ++ ;
                    e -- ;
                }
            }
        }

        return a ;
    }
}
/*
5
20
-16 9 -25 8 44 20 20 -12 11 -44 -32 7 41 13 7 27 -49 -19 -43 6
16
-23 48 -13 31 -12 6 -42 23 14 33 -33 -21 0 25 -39 -31
3
30 26 -15
6
-40 43 25 28 -27 -18
8
13 -33 -25 45 -16 -43 -17 37

 */