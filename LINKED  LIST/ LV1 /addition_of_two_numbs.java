public class addition_of_two_numbs {
    static class node
    {
        int data ;
        node next ;
        node(int data){ this.data = data ; next = null ; }
        node(){  next = null ; }
    }

    static node reverse(node head)
    {
        node current = head ;
        node prev = null ;
        node next;
        if(head == null || head.next == null) {
            return head ;
        }
        else {
            while (current != null) {
                next = current.next;
                current.next = prev;
                prev = current;
                current = next;
            }
        }
        return prev ;
    }
    static void insertAtTail(node head , node tail , int val)
    {
        node temp = new node(val) ;
        node current = head ;
        if(head == null)
        {
            head = temp ;
        }
        else
        {
            while (current.next != null)
            {
                current = current.next ;
            }
            current.next = temp ;
        }
        tail = temp ;
    }
    static node addList(node head1 , node head2)
    {
        int carry = 0;
        node answer_head = new node();
        node answer_tail = new node();
        while (head1 != null || head2 != null || carry != 0)
        {
            int val1 = 0 ;
            if(head1 != null)
                val1 = head1.data ;
            int val2 = 0 ;
            if(head2 != null)
                val2 = head2.data ;
            int ans = val1 + val2 + carry ;
            carry = ans/10 ;
            int digit = ans%10 ;
            insertAtTail(answer_head ,answer_tail ,digit) ;
            if(head1 != null)
                head1 = head1.next ;
            if (head2 != null)
                head2 = head2.next ;
        }
        return answer_head.next ;
    }

    static void show(node head , int n)
    {
        System.out.print("NUMBER "+n+" : ");
        node current = head ;
        if(head == null)
            return ;
        while (current != null)
        {
            System.out.print(current.data+" ");
            current = current.next ;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // nodes of first list aka , number 1 ->
        node head1 = new node(2) ;
          node n1 = new node(3) ;
          node n2 = new node(2) ;
        node tail1 = new node(1) ;
        // linkage ->
        head1.next = n1   ;
        n1.next = n2      ;
        n2.next = tail1   ;
        tail1.next = null ;
        show(head1 , 1);
        // nodes of first list aka , number 2 ->
        node head2 = new node(9) ;
          node n_1 = new node(3) ;
          node n_2 = new node(1) ;
        node tail2 = new node(7) ;
        // linkage ->
        head2.next = n_1  ;
        n_1.next = n_2    ;
        n_2.next = tail2  ;
        tail2.next = null ;
        show(head2  , 2);
        System.out.print("ADDITION + --------\n");
        head1 = reverse(head1) ;
        head2 = reverse(head2) ;
        node answer = addList(head1 , head2) ;
        answer = reverse(answer) ;
        node temp = answer ;
        while (temp != null)
        {
            System.out.print(temp.data+" ");
            temp = temp.next ;
        }

        node head3 = new node(1) ;
        head3.next = null ;
        System.out.print("\n");
        show(head3 , 3);
        show(head1 , 1);
        System.out.print("ADDITION + --------\n");
        head1 = reverse(head1) ;
        node ans = addList(head1 , head3) ;
        ans = reverse(ans) ;
        node tempo = ans ;
        while (tempo != null)
        {
            System.out.print(tempo.data+" ");
            tempo = tempo.next ;
        }
    }
}