import java.util.* ;
public class _80_RemoveDuplicates_II {
    public static void main(String[] args) {
        SOLVE80 object = new SOLVE80() ;
        System.out.println(object.removeDuplicates(new int[]{1,1,1,2,2,3}));
        System.out.println(object.removeDuplicatesOptimized(new int[]{1,1,1,2,2,3}));
        System.out.println(object.RemoveDuplicates(new int[]{1,1,1,2,2,3}));
    }
}
class SOLVE80{
    // * -- Map solution -- approach 1
    public int removeDuplicates(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int val : nums) {
            map.put(val, map.getOrDefault(val, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 2) {
                map.put(entry.getKey(), 2);
            }
        }

        int index = 0;
        int total = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            for (int i = index; i < index + entry.getValue(); i++) {
                nums[i] = entry.getKey();
            }
            index += entry.getValue();
            total += entry.getValue();
        }
        System.out.println(Arrays.toString(nums));
        return total;
    }
    public int removeDuplicatesOptimized(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        for (int val : nums) {
            map.put(val, map.getOrDefault(val, 0) + 1);
            if (map.get(val) <= 2) {
                result.add(val);
            }
        }
        for (int i = 0; i < result.size(); i++) {
            nums[i] = result.get(i);
        }
        return result.size();
    }
    // * -- optimized solution O(n) & constant space --
    public int RemoveDuplicates(int[] nums){
        int count = 0 ;
        int index = 1 ;
        for (int i = 1 ; i < nums.length ; i ++){
            if(nums[i] == nums[i-1])
                count++ ;
            else
                count = 0 ;
            if(count <= 1) {
                nums[index] = nums[i];
                index++ ;
            }
        }

        return index ;
    }
}