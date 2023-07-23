import java.util.* ;
public class _380_DesignSet {
    public static void main(String[] args) {
        RandomizedSet set = new RandomizedSet() ;
    }
}
class RandomizedSet {
    private Set<Integer> set;

    public RandomizedSet() {
        set = new HashSet<>();
    }

    public boolean insert(int val) {
        if (set.contains(val))
            return false;
        else {
            set.add(val);
            return true;
        }
    }

    public boolean remove(int val) {
        if (set.contains(val)) {
            set.remove(val);
            return true;
        }
        return false;
    }

    public int getRandom() {
        List<Integer> list = new ArrayList<>(set) ;
        int answer;
        int index = (int)(Math.random() * set.size()) ;
        answer = list.get(index) ;
        return answer;
    }
}
