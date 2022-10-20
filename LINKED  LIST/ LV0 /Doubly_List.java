public class Doubly_List {
//----------------------------------------------------------------------------------------
    static class node
    {
        /*
                                 --------------------
                                |      |      |      |
                         null<--|--prev| data |next--|-->null
                                |      |      |      |
                                 --------------------
         */
        int data ;
        node next ;
        node previous ;
        node(int data){ this.data = data ; next = null ; previous = null ; }
    }
    //HEAD OF LIST :
    public static node HEAD = null ;
    //TAIL OF LIST :
    public static node LAST = null ;

    //-----------------------------------------------------------------------------------
    static void insert_at_head(int val)
    {
        node temp = new node(val) ;
        if(HEAD == null)
        {
            HEAD = temp ;
            LAST = temp ;
        }
        else
        {
            temp.next = HEAD ;
            HEAD.previous = temp ;
            HEAD = temp ;
        }
    }
    //-----------------------------------------------------------------------------------
    static void insert_at_tail(int val)
    {
        node temp = new node(val);
        node current = LAST ;
        if(HEAD == null)
        {
            HEAD = temp ;
        }
        else
        {
            current.next = temp ;
            temp.previous = current ;
        }
        LAST = temp ;
    }
    //-----------------------------------------------------------------------------------
    static void insert_at_middle(int val)
    {
        node temp = new node(val) ;
        node current = HEAD ;
        int mid ;
        if(HEAD == null)
        {
            HEAD = temp ;
            LAST = temp ;
        }
        else
        {
            if(size()%2==0)
                mid = size()/2 ;
            else
                mid = size()/2 + 1 ;
            while (mid-->1)
            {
                current = current.next ;
            }
            temp.next = current.next ;
            current.next.previous = temp ;
            current.next = temp ;
            temp.previous = current ;
        }
    }
    //-----------------------------------------------------------------------------------
    static void insert_at_index(int index , int val)
    {
        node temp = new node(val) ;
        node current = HEAD ;
        if(HEAD == null || index == 1)
        {
            insert_at_head(val);
            return ;
        }
        if(index == size())
        {
            insert_at_tail(val);
            return ;
        }
        index-- ;
        while (index-->1)
        {
            current = current.next ;
        }
        temp.next = current.next ;
        current.next.previous = temp ;
        current.next = temp ;
        temp.previous = current ;
    }
    //-----------------------------------------------------------------------------------
    static void delete_head()
    {
        if(HEAD == null)
            System.out.println("N/A");
        else
        {
            HEAD = HEAD.next ;
            HEAD.previous = null ;
            System.out.println("head successfully deleted !");
        }
    }
    //-----------------------------------------------------------------------------------
    static void delete_tail()
    {
        node current = HEAD ;
        if(HEAD == null)
            System.out.println("N/A");
        else
        {
            while (current.next.next != null)
            {
                current = current.next ;
            }
            current.next = null ;
            LAST = current ;
            System.out.println("tail successfully deleted !");
        }
    }
    //----------------------------------------------------------------------------------
    static void delete_middle()
    {
        node current = HEAD ;
        node prev = null ;
        int mid ;
        if(HEAD == null)
            System.out.println("N/A");
        else
        {
            if(size()%2==0)
                mid = size()/2 ;
            else
                mid = size()/2 + 1 ;
            while (mid-->1)
            {
                prev = current ;
                current = current.next ;
            }
            prev.next = current.next ;
            current.next.previous = prev ;
            System.out.println("mid-element successfully deleted !");
        }
    }
    //-----------------------------------------------------------------------------------
    static void delete_at_index(int index)
    {
        int pos = index ;
        node current = HEAD ;
        node prev = null ;
        if(HEAD == null)
            System.out.println("N/A");
        else if (index == 1)
        {
            delete_head();
            return ;
        }
        else if(index == size())
        {
            delete_tail();
            return ;
        }
        else
        {
           while (index-->1)
           {
               prev = current ;
               current = current.next ;
           }
           prev.next = current.next ;
           current.next.previous = prev;
        }
        System.out.println("element at "+pos+" successfully deleted !");
    }
    //-----------------------------------------------------------------------------------
    static int size()
    {
        node current = HEAD ;
        int length = 0 ;
        if(HEAD == null)
            return  0 ;
        else
        {
            while (current != null)
            {
                current = current.next ;
                length++ ;
            }
        }
        return length ;
    }
    //-----------------------------------------------------------------------------------
    static void show_list_from_head()
    {
        node current = HEAD ;
        System.out.println("Current from head : ");
        if(HEAD == null)
            System.out.println("N/A");
        else
        {
            while (current != null)
            {
                System.out.print(current.data+"<->");
                current = current.next ;
            }
        }
        System.out.println("size("+size()+")");
    }
    //-----------------------------------------------------------------------------------
    static void show_list_from_tail()
    {
        node current = LAST ;
        System.out.println("Current from tail : ");
        if(HEAD == null)
            System.out.println("N/A");
        else
        {
            while (current != null)
            {
                System.out.print(current.data+"<->");
                current = current.previous ;
            }
        }
        System.out.println("size("+size()+")");
    }
    //-----------------------------------------------------------------------------------
    public static void main(String[] args) {
        insert_at_head(10) ;
        insert_at_head(20) ;
        insert_at_head(30) ;
        insert_at_head(40) ;
        insert_at_tail(9) ;
        insert_at_tail(8) ;
        insert_at_middle(56) ;
        insert_at_index(3 , 456) ;
        show_list_from_head() ;

        delete_head() ;
        show_list_from_head() ;

        delete_middle() ;
        show_list_from_head() ;

        delete_tail() ;
        show_list_from_head() ;

        delete_at_index(3) ;
        show_list_from_head() ;

        show_list_from_tail() ;
    }
}
