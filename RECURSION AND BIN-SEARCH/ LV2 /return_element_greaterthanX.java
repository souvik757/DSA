/*
Native approach :
numbs = [ 0 , 3 , 4 , 4 , 0 , 3 ]
for( i = 0 -> 1000 )
    for( j = 0 -> numbs.length-1 )
        if(numbs[j] >= i)
           count++
if(count == i)
   return i
 */
class solution_native{
    public int special_X(int[] nums){
        for(int i = 0 ; i < 101 ; i++)
        {
            int c = 0;
            for(int j = 0 ; j < nums.length-1 ; j++)
            {
                if(nums[j] >= i)
                    c++;
            }
            if(c == i)
                return i;
        }
        return -1;
    }
}
/*
optimized approach (Bin-Search):

 */

public class return_element_greaterthanX {
    public static void main(String[] args) {
        int[] numbs = new int[]{0,3,4,3,0,4};
        solution_native ob = new solution_native();
        System.out.println(ob.special_X(numbs));
    }
}
