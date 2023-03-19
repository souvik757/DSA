import java.util.*;

public class sort_by_number_of_1_bit {
    public static void main(String[] args) {
        sort_by_number_of_1_bit result = new sort_by_number_of_1_bit() ;
        System.out.println(result._get_1_bits(7));
        System.out.println(Arrays.toString(result.sortByBits(new int[]{1024,512,256,128,64,32,16,8,4,2,1}))) ;
        System.out.println(Arrays.toString(result.sortByBits(new int[]{0,1,2,3,4,5,6,7,8}))) ;
        System.out.println(Arrays.toString(result.sortByBits(new int[]{2,3,5,7,11,13,17,19}))) ;
    }
    public int[] sortByBits(int[] arr) {
        HashMap<Integer , Integer> map = new HashMap<>() ;
        for(int i = 0 ; i < arr.length ; i++)
            map.put(arr[i] , _get_1_bits(arr[i])) ;
        map = sortByValue(map) ;
        _set_keys_(map , arr);
        return arr ;
    }
    public void _set_keys_(HashMap<Integer , Integer> map , int[] arr){
        int index = 0 ;
        for(Map.Entry<Integer , Integer> entry : map.entrySet()){
            arr[index] = entry.getKey() ;
            index++ ;
        }
        System.out.println(Arrays.toString(arr));
        System.out.println(map);
        int lastSameKey = 0 ;
        int i = 0 ;
        int start = 0 ;
        while (i < arr.length){
            if((!Objects.equals(map.get(arr[i]), map.get(start))) || (i == arr.length-1)){
                Arrays.sort(arr , start , i);
                start = i ;
            }
            i++ ;
        }
    }

    public int _get_1_bits(int x){
        if(x == 0)
            return 0 ;
        String binary = "" ;
        while(x > 0){
            binary += x%2 ;
            x = x/2 ;
        }
        char[] BIN = binary.toCharArray() ;
        int count = 0 ;
        for(int i = 0 ; i < BIN.length ; i++){
            if(BIN[i] == '1')
                count++ ;
        }
        return count ;
    }
    public HashMap<Integer, Integer> sortByValue(HashMap<Integer, Integer> hm)
    {
        // Create a list from elements of HashMap
        List<Map.Entry<Integer, Integer> > list =
                new LinkedList<Map.Entry<Integer, Integer> >(hm.entrySet());

        // Sort the list
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer> >() {
            public int compare(Map.Entry<Integer, Integer> o1,
                               Map.Entry<Integer, Integer> o2)
            {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });

        // put data from sorted list to hashmap
        HashMap<Integer, Integer> temp = new LinkedHashMap<Integer, Integer>();
        for (Map.Entry<Integer, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }

}
