public class pivot_index {
    public static void main(String[] args) {
        solutions result = new solutions() ;
        System.out.println(result._brute_force_(new int[]{1,2,3}));
        System.out.println(result._optimized_(new int[]{1,2,3}));
    }
}
class solutions{
    public int findSum(int[] arr , int start , int end){
        int result = 0 ;
        for(int i = start ; i <= end ; i++)
            result += arr[i] ;
        return  result ;
    }

    public int _brute_force_(int[] arr){
        int RightSum = 0 ;
        int LeftSum = 0 ;
        int answer = -1 ;
        for(int i = 0 ; i < arr.length ; i++){
            int start = arr.length - (arr.length - (i+1)) ;
            RightSum = findSum(arr , start , arr.length-1) ;
            LeftSum = findSum(arr , 0 , i-1) ;
            if(start == arr.length)
            {
                if(LeftSum == 0)
                    answer = i ;
            }
            if(i-1 == -1)
            {
                if(RightSum == 0)
                    answer = i ;
            }
            if(RightSum == LeftSum){
                answer = i ;
                break ;
            }
        }
        return  answer ;
    }
    public int _optimized_(int[] arr){
        int sum = findSum(arr , 0 , arr.length-1) ;
        int rest_sum = 0 ;
        int i = 0 ;
        while (i < arr.length){
            sum -= arr[i] ;
            if(sum == rest_sum)
                return i ;
            rest_sum += arr[i] ;
            i++ ;
        }
        return -1;
    }
}
