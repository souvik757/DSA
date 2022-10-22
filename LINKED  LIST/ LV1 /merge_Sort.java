public class merge_Sort {
    static class node
    {
        int data ;
        node next ;
        node(int data){ this.data = data ; next = null ; }
    }
    static void show(node head)
    {
        System.out.print("STATUS : ");
        node current = head ;
        if(head == null)
            return ;
        while (current != null)
        {
            System.out.print(current.data+"->");
            current = current.next ;
        }
        System.out.println();
    }
    static node getMid(node head)
    {
        node tortoise = head ;
        node hare = head.next ;
        while (hare != null && hare.next != null)
        {
            tortoise = tortoise.next ;
            hare = hare.next.next ;
        }
        return tortoise ;
    }
    static node merge(node n1 , node n2)
    {
        if(n2 == null)
            return n1 ;
        if(n1 == null)
            return n2 ;
        node temp = new node(-1) ;
        node ans = temp ;
        while (n1 != null && n2 != null)
        {
            if(n1.data < n2.data)
            {
                temp.next = n1 ;
                temp = n1 ;
                n1 = n1.next ;
            }
            else
            {
                temp.next = n2 ;
                temp = n2 ;
                n2 = n2.next ;
            }
        }
        while (n1 != null)
        {
            temp.next = n1 ;
            temp = n1 ;
            n1 = n1.next ;
        }
        while (n2 != null)
        {
            temp.next = n2 ;
            temp = n2 ;
            n2 = n2.next ;
        }
        System.out.println("Successfully divided ");
        show(ans.next);
        return ans.next ;
    }
    static node sorted(node head)
    {
        if(head == null || head.next == null)
            return head ;

        node Mid = getMid(head) ;

        node left = head ;
        node right = Mid.next ;
        Mid.next = null ;


        left = sorted(left) ;
        right = sorted(right) ;

        return merge(left ,right);
    }

    public static void main(String[] args) {
        node head = new node(20) ;
          node n1 = new node(31) ;
          node n2 = new node(12) ;
          node n3 = new node(113) ;
          node n4 = new node(14) ;
          node n5 = new node(15) ;
          node n6 = new node(16) ;
        node tail = new node(17) ;
        //link
        head.next = n1 ;
          n1.next = n2 ;
          n2.next = n3 ;
          n3.next = n4 ;
          n4.next = n5 ;
          n5.next = n6 ;
          n6.next = tail ;
        tail.next = null ;
        show(head);
        show(sorted(head));

    }
}
