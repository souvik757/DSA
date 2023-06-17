package HEAP;

import java.util.* ;
// dynamic heap that allows insertion and deletion with sorted order
public class GenericHeap {
    private int size ;
    private List<Integer> list ;
    public GenericHeap() {
        size = -1 ;
        list = new ArrayList<>() ;
    }
    public void Add(int num){
        if(list.contains(num))
            return ;
        size = size + 1 ;
        int index = size ;
        list.add(index , num);
        while (index >= 0){
            int parent = index/2 ;
            if(list.get(parent) > list.get(index)){
                swap(parent , index);
                index = parent ;
            }
            else
                return ;
        }
    }
    public int Pop(){
        int deleted = 0;
        if(!list.isEmpty()) {
            int last = list.get(size) ;
            deleted = list.get(0);
            list.remove(0) ;
            list.add(0, last);
            list.remove(size) ;
            list.add(size, 0);
            size--;

            int index = 0;

            while (index <= size) {
                int left = 2 * index + 1;
                int right = 2 * index + 2;

                int smallest = index;
                if (left <= size && list.get(smallest) > list.get(left))
                    smallest = left;
                if (right <= size && list.get(smallest) > list.get(right))
                    smallest = right;
                if (smallest != index) {
                    swap(smallest, index);
                    index = smallest;
                } else
                    return -1;
            }
        }
        delete() ;
        return deleted ;
    }
    // delete each 0 element
    // show heap
    // swap function
    private void delete(){
        for (int i = 0 ; i < list.size() ; i ++)
        {
            if(list.get(i) == 0)
                list.remove(i) ;
        }
    }
    public void GetHeap(){
        if(list.isEmpty())
            return ;
        System.out.println(list.toString());
    }
    protected final void swap(int x ,int y){
        int a = list.get(x) ;
        int b = list.get(y) ;

        list.remove(x) ;
        list.add(x , b);

        list.remove(y) ;
        list.add(y , a);
    }
}
