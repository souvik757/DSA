public class possibleToSurvive {
    public static void main(String[] args) {
        solve_possibleToSurvive object = new solve_possibleToSurvive() ;
        System.out.println(object.minimumDays(10,16,2));
        System.out.println(object.minimumDays(11,34,6));
    }
}
/*
    S have to live for S days
    N max food per days
    M food per day to survive
 */
class solve_possibleToSurvive {
    public int minimumDays(int S,int N,int M){
        int sundayCount = S/7 ;
        int buyingDays = S - sundayCount ;
        int totalFood = S*M ;

        int answer = -1 ;
        if(totalFood % N == 0)
            answer = totalFood/buyingDays ;
        else
            answer = totalFood/buyingDays + 1 ;
        return (answer <= buyingDays) ? answer : -1 ;
    }
}