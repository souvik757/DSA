import java.util.* ;

public class celebel_tech {
    public static void main(String[] args) {
        int[] num = new int[]{1,2,3,3,-12,9,0,4,12,5,10,1} ;
        int[] numForPivot = new int[]{4,5,9,10,12,0,-1,1,2,3} ;
        System.out.println("Array for pivot : "+Arrays.toString(numForPivot));
        System.out.println("1 . Pivot element -> "+
                new problem_solution().pivot(numForPivot));
        System.out.println("Array : "+Arrays.toString(num));
        System.out.println("2.0 . Second Lowest -> "+
                new problem_solution().SecondLowest(num));
        System.out.println("2.1 . Second Highest -> "+
                new problem_solution().SecondHighest(num));
        System.out.print("3 . Sum of largest common factor of ");
        int x = new Scanner(System.in).nextInt() ;
        System.out.print(" and ");
        int y = new Scanner(System.in).nextInt() ;
        System.out.println(" = "+
                new problem_solution().sum_LCF(x,y));
        System.out.println("4 . Occurrences in \n"+ Arrays.toString(num)+" :"+
                new problem_solution().occurrences(num));
    }
}
class problem_solution{
    // 1 . Find the pivot element of the array given .
    public int pivot(int[] num){
        Arrays.sort(num) ;
        // number ->  4, 5, 9, 10, 12 , 0 , -1  ,1 , 2 , 3
        // index  ->  0  1  2   3   4   5    6   7   8   9
         int start = 0 ;
        int end = num.length - 1 ;
        while(start < end){
            int mid = start + (end-start)/2 ;
            if(num[mid] >= num[0])
                start = mid + 1;
            else
                end = mid ;
        }
        return num[end] ;
    }
    //2 . 0 Find the 2nd lowest element in the array.
    public int SecondLowest(int[] num){
        int k = 2 ;
        int n = k -1 ;
        Set<Integer> set = new TreeSet<>() ;
        for(int i : num)
            set.add(i) ; // a set adds elements in sorted ascending order .
        Iterator<Integer> iterator = set.iterator() ;
        while(n-->0)
            iterator.next();

        return iterator.next() ;
    }
    // 2 . 1 Find the 2nd highest element in the array.
    public int SecondHighest(int[] num){
        int k = 2 ;
        int n = (num.length-1-k-1) ;
        Set<Integer> set = new TreeSet<>() ;
        for(int i : num)
            set.add(i) ; // a set adds elements in sorted ascending order .
        Iterator<Integer> iterator = set.iterator() ;
        while(n-->0)
            iterator.next();

        return iterator.next() ;
    }
    //3 . Find the sum of the largest common factor.
    public int sum_LCF(int x , int y){
        int answer = 0 ;
        int gcd = GCD(x,y) ;
        for(int i = 1 ; i <= Math.sqrt(gcd) ; i++){
            if (gcd % i == 0) {
                if(gcd/i == i)
                    answer += i ;
                else
                    answer += (gcd/i)+i ;
            }
        }
        return answer ;
    }
    //4 . Count the occurrence of numbers in the array using a hashmap.
    public Map<Integer , Integer> occurrences(int[] num){
        // key - array element
        // value - occurrence
        Map<Integer , Integer> map = new HashMap<>() ;
        for(int i : num){
            if(map.containsKey(i))
                map.put(i , map.get(i)+1) ;
            else
                map.put(i , 1) ;
        }
        return map ;
    }
    // GCD
    public int GCD(int x , int y){
        return (x == 0) ? y : GCD(y%x , x) ;
    }
    // LCM
   // public int LCM(int x , int y){
   //
   // }
   // // HCF
   // public int HCF(int x , int y){
   //
   // }
    // Th_1 . How does a 'Hashmap' work ?
    /*

     */

}
