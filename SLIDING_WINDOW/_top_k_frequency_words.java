import java.util.* ;

public class _top_k_frequency_words {
    public static void main(String[] args) {
        System.out.println(topKFrequent(new String[]{"i" ,"love" ,"gaming" , "i" , "love" , "anime"} , 2));
        System.out.println(topKWords(new String[]{"i" ,"love" ,"gaming" , "i" , "love" , "anime"} , 2));
    }
    public static List<String> topKFrequent(String[] words, int k) {
        TreeMap<String , Integer> _map_ = new TreeMap<>() ;
        for(String str : words)
            _map_.put(str , _map_.getOrDefault(str,0)+1) ;
        List<String> _list_ = new ArrayList<>(_map_.keySet()) ;
        _list_.sort((x,y)-> _map_.get(y)-_map_.get(x)) ;
        return _list_.subList(0 , k) ;
    }
    public static List<String> topKWords(String[] words , int k){
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder()) ;
        List<String> list = new ArrayList<>() ;
        TreeMap<String , Integer> _map_ = new TreeMap<>() ;
        for(String str : words)
            _map_.put(str , _map_.getOrDefault(str,0)+1) ;
        for(Map.Entry<String,Integer> entry : _map_.entrySet())
            queue.add(entry.getValue()) ;
        while (k-->0){
            int X = queue.poll() ;
            for(Map.Entry<String,Integer> entry : _map_.entrySet()){
                if(X == entry.getValue()){
                    list.add(entry.getKey()) ;
                    _map_.remove(entry.getKey()) ;
                    break ;
                }
            }
        }
        return list ;
    }
}


















