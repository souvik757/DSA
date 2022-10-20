import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class remove_duplicate {
    static class node
    {
        int data ;
        node next ;
        node(int data){ this.data = data ; next = null ;}
    }
    static void show(node head)
    {
        node current = head ;
        while (current != null)
        {
            System.out.print(current.data+"->");
            current = current.next ;
        }
        System.out.println("~X~");
    }
    static void remove_dup_sorted(node head)// T.C : O(n) S.C : O(1)
    {
        if(head == null)
            return ;
        node current = head ;
        while (current.next != null)
        {
            if(current.data == current.next.data)
                current.next = current.next.next ;
            else
                current = current.next ;
        }
        System.out.println("Duplicate element removed successfully !") ;
    }

    static void remove_dup_unsorted_1(node head)//T.C : O(n2) O(1)
    {
        if(head == null)
            return ;
        node current = head ;
        while (current != null &&current.next != null)
        {
            node temp = current ;
            while (temp.next != null)
            {
                if(current.data == temp.next.data)
                {
                    temp.next = temp.next.next ;
                    System.gc();
                }
                else
                    temp = temp.next ;
            }
            current = current.next ;
        }
    }
    static void remove_dup_unsorted_2(node head) // T.C : O(n) S.C : O(1)
    {
        if(head == null)
            return ;
        node current = head ;
        node prev = null ;
        HashSet<Integer> hm = new HashSet<>() ;
        while (current != null)
        {
            if(hm.contains(current.data)) {
                prev.next = current.next ;
            }
            else
            {
                prev = current ;
            }
            hm.add(current.data) ;
            current = current.next ;
        }
    }

    public static void main(String[] args) {
        node head = new node(11) ;
          node n1 = new node(10) ;
          node n2 = new node(11) ;
          node n3 = new node(12) ;
          node n4 = new node(16) ;
          node n5 = new node(12) ;
        node tail = new node(16) ;
        head.next = n1 ;
          n1.next = n2 ;
          n2.next = n3 ;
          n3.next = n4 ;
          n4.next = n5 ;
          n5.next = tail ;
        tail.next = null ;
        show(head);
        remove_dup_unsorted_2(head);
        System.out.println();
        show(head);
    }
}
