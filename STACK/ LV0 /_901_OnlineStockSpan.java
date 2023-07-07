import java.util.* ;
import java.util.Stack;

public class _901_OnlineStockSpan {
    public static void main(String[] args) {
//        StockSpanner_confused spanner ;
//        spanner = new StockSpanner_confused() ;
//        System.out.println(100+" -> "+spanner.next(100));
//        System.out.println(80+"  -> "+spanner.next(80));
//        System.out.println(60+"  -> "+spanner.next(60));
//        System.out.println(70+"  -> "+spanner.next(70));
//        System.out.println(60+"  -> "+spanner.next(60));
//        System.out.println(75+"  -> "+spanner.next(75));
//        System.out.println(85+"  -> "+spanner.next(85));
//        System.out.println();
//        spanner = new StockSpanner_confused() ;
//        System.out.println(60+"  -> "+spanner.next(29));
//        System.out.println(70+"  -> "+spanner.next(91));
//        System.out.println(60+"  -> "+spanner.next(62));
//        System.out.println(75+"  -> "+spanner.next(76));
//        System.out.println(85+"  -> "+spanner.next(51));
//        System.out.println();
//        StockSpanner object  ;
//        object = new StockSpanner() ;
//        System.out.println(100+" -> "+object.next(100));
//        System.out.println(80+"  -> "+object.next(80));
//        System.out.println(60+"  -> "+object.next(60));
//        System.out.println(70+"  -> "+object.next(70));
//        System.out.println(60+"  -> "+object.next(60));
//        System.out.println(75+"  -> "+object.next(75));
//        System.out.println(85+"  -> "+object.next(85));
//        System.out.println();
//        object = new StockSpanner() ;
//        System.out.println(60+"  -> "+object.next(29));
//        System.out.println(70+"  -> "+object.next(91));
//        System.out.println(60+"  -> "+object.next(62));
//        System.out.println(75+"  -> "+object.next(76));
//        System.out.println(85+"  -> "+object.next(51));
    }
}
class StockSpanner{
    private Stack<int[]> stack ;
    public StockSpanner(){
        stack = new Stack<>() ;
    }
    public int next(int price){
        int span = 1 ;
        while (!stack.isEmpty() && price>=stack.peek()[0]){
            span += stack.pop()[1] ;
        }
        stack.push(new int[]{price,span}) ;

        return span ;
    }
}
class StockSpanner_confused {
    private List<Integer> list ;
    private Map<Integer,Integer> countMap ;
    public StockSpanner_confused() {
        list = new ArrayList<>() ;
        countMap = new HashMap<>() ;
    }

    public int next(int price) {
        if (countMap.containsKey(price)) {
            list.add(price);
            return countMap.get(price);
        }
        list.add(price) ;
        fillCountMap(price);

        return countMap.get(price) ;
    }
    private void fillCountMap(int price){
        int count = 0 ;
        for (int val : list){
            if (val <= price)
                count ++ ;
        }
        countMap.put(price , count) ;
    }
}