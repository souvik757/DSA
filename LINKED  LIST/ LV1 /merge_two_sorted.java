public class merge_two_sorted {
    static class node
    {
        int data ;
        node next ;
        node(int data){this.data = data ; next = null ;}
    }

    static void show(node head)
    {
        node current = head ;
        if(head == null)
            return ;
        while (current != null)
        {
            System.out.print(current.data+"->");
            current = current.next ;
        }
    }
    static node solve(node Head1 , node Head2)
    {
        if(Head1.next == null)
        {
            Head1.next = Head2 ;
            return Head1 ;
        }
        // nodes of first list :
        node current1 = Head1 ;
        node next1 = current1.next ;
        // nodes of second list :
        node current2 = Head2 ;
        node next2 ;
        while (next1 != null && current2 != null)  // O(size of list1 + size of list 2 )
        {
            if((current2.data >= current1.data) && (current2.data<= next1.data))
            {
                current1.next = current2 ;//1.
                next2 = current2.next ;//2.
                current2.next = next1 ;//3.

                current1 = current2 ;
                current2 = next2 ;
            }
            else
            {
                current1 = next1 ;
                next1 = next1.next ;
                if(next1 == null)
                {
                    current1.next = current2 ;
                }
            }
        }
        return Head1 ;
    }

    static node merged_list(node Head1 , node Head2)
    {
        if (Head2 == null) // O( 1 )
            return Head1 ; // O( 1 )
        if(Head1 == null)
           return Head2 ;
        if(Head1.data <= Head2.data)  // O( 1 )
            return solve(Head1 , Head2) ; // O( n + m )
        else                          // O( 1 )
            return solve(Head2 , Head1) ;  // O( n + m )
        //---> T.C : O(n+m) S.C : O(1) where , n = size of first list , m = size of second list .
    }

    public static void main(String[] args) {
        node head1 = new node(1) ;
        node n1 = new node(4) ;
        node tail1 = new node(5) ;
        head1.next = n1 ;
        n1.next = tail1 ;
        tail1.next = null ;
        System.out.print("LIST 1 : ");
        show(head1);
        node head2 = new node(2) ;
        node n2 = new node(3) ;
        node tail2 = new node(5) ;
        head2.next = n2 ;
        n2.next = tail2 ;
        tail2.next = null ;
        System.out.print("\nLIST 2 : ");
        show(head2);
        System.out.print("\nMerged List : ");
        show(merged_list(head1 , head2)) ;
    }
}
