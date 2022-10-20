import java.util.HashMap;
import java.util.Map;
/*
  1 . Loop detection :
        a.) using map : Time -> O(n) Space -> O(n)
        b.) using FCD : Floyd Cycle Detection : Time -> O(n) Space -> O(1)
  2 . Loop head finding :
        a.) FCD : Time -> O(n) Space -> O(1)
  3 . Loop deletion :
        a.) simple node traversing :  Time -> O(n) Space -> O(1)
 */
public class detect_loop {
    static class node
    {
        int data ;
        node next ;
        node(int data){ this.data = data ; next = null ; }
    }
    static node loop_section(node head)// Time : O(n) Space : O(1)
    {
        if(head == null)
            return null ;
        node tortoise = head ;
        node hare = head ;
        while(hare != null && hare.next != null)
        {
            hare = hare.next.next ;
            tortoise = tortoise.next ;
            if(hare == tortoise)
            {
                return hare ;
            }
        }
        return null ;
    }

    static node get_loop_head(node head)
    {
        if(head == null)
            return null;
        node intersect = loop_section(head) ;
        node tortoise = head ;
        while (tortoise != intersect)
        {
            tortoise = tortoise.next ;
            intersect = intersect.next ;
        }
        return tortoise ;
    }

    static boolean check(node head)// Time : O(n) Space : O(n)
    {
        node temp = head ;
        if(head == null)
            return false ;

        Map<node , Integer> hm = new HashMap<>() ;

        while (temp != null)
        {
            if(hm.containsKey(temp))
                return true ;
            else
            {
                hm.put(temp , 1) ;
                temp = temp.next ;
            }
        }
        return false ;
    }
    static void show_list( node head )
    {
        System.out.print("Current Status : ");
        //CHECK IF LIST IS EMPTY :
        node current = head ;
        if(head == null) {
            System.out.print("N/A");
        }
        else
        {
            while (current != null)
            {
                System.out.print(current.data+"->");
                current = current.next ;
            }
        }
    }

    public static void main(String[] args)
    {
        node head = new node(12) ;
        node n1 = new node(13) ;
        node n2 = new node(14) ;
        node n3 = new node(15) ;
        node n4 = new node(16) ;
        node n5 = new node(17) ;
        node n6 = new node(18) ;
        node n7 = new node(19) ;
        node n8 = new node(20) ;
        node tail = new node(21) ;
        head.next = n1 ;
        n1.next = n2 ;
        n2.next = n3 ;
        n3.next = n4 ;
        n4.next = n5 ;
        n5.next = n6 ;
        n6.next = n7 ;
        n7.next = n8 ;
        n8.next = tail ;
        tail.next = n4 ;

        if(check(head))
            System.out.println("T : has loop") ;
        else
            System.out.println("F : no loop") ;
        System.out.println("Loop head : "+ get_loop_head(head).data);

        node loopHEAD = get_loop_head(head) ;
        node current = loopHEAD ;
        while( current.next != loopHEAD )
            current = current.next ;
        current.next = null ;

        show_list(head);
    }

}
