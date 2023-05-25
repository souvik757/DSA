public class sort_list_0_1 {
    public static void main(String[] args) {
        SOLVE_01LIST object = new SOLVE_01LIST() ;
        object.main() ;
    }
}
class SOLVE_01LIST{
    public void main() {
        node head = new node(1) ;
        node n1 = new node(0) ;
        node n2 = new node(1) ;
        node n3 = new node(2) ;
        node n4 = new node(0) ;
        node n5 = new node(1) ;
        node tail = new node(2) ;
        head.next = n1 ;
        n1.next = n2 ;
        n2.next = n3 ;
        n3.next = n4 ;
        n4.next = n5 ;
        n5.next = tail ;
        tail.next = null ;
        show_list(head);
        show_list(sort(head));
        show_list(sort_1(head));
    }
    private node sort(node head) // T.C : O(n) S.C : O(1)
    {
        if(head == null)
            return null;
        int ZeroCount = 0 ;
        int OneCount  = 0 ;
        int TwoCount  = 0 ;
        node current = head ;
        while (current != null)
        {
            if(current.data == 0)
                ZeroCount++ ;
            else if(current.data == 1)
                OneCount++ ;
            else
                TwoCount++ ;
            current = current.next ;
        }
        current = head ;
        while (current != null)
        {
            if (ZeroCount--> 0)
            {
                current.data = 0 ;
            }
            else if (OneCount--> 0)
            {
                current.data = 1 ;
            }
            else if (TwoCount--> 0)
            {
                current.data = 2 ;
            }
            current = current.next ;
        }
        System.out.println("SORTED");
        return head ;
    }
    private node sort_1(node head) // T.C : O(n) S.C : O(1)
    {
        if(head == null)
            return null ;
        node ZeroHead = new node(-1) ;
        node ZeroTail = ZeroHead ;
        node OneHead = new node(-1) ;
        node OneTail = OneHead ;
        node TwoHead = new node(-1) ;
        node TwoTail = TwoHead ;
        node current = head ;
        while( current != null)
        {
            int val = current.data ;
            if( val == 0 ) {
                ZeroTail.next = current ;
                ZeroTail = current ;
            } else if (val == 1) {
                OneTail.next = current ;
                OneTail = current ;
            } else if (val == 2) {
                TwoTail.next = current ;
                TwoTail = current ;
            }
            current = current.next ;
        }
        if(OneHead.next != null)
            ZeroTail.next = OneHead.next ;
        else
            ZeroTail.next = TwoHead.next ;
        OneTail.next = TwoHead.next ;
        TwoTail.next = null ;
        head = ZeroHead.next ;
        System.gc() ;
        return head ;
    }

    private void show_list(node head)
    {
        if(head == null)
            return ;
        node current = head ;
        while (current != null)
        {
            System.out.print(current.data+"->");
            current = current.next ;
        }
        System.out.println("NULL");
    }
}
class node
{
    int data ;
    node next ;
    node(int data){ this.data = data ; next = null ; }
}
