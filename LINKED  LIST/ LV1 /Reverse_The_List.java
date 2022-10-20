public class Reverse_The_List {
    //----------------------------------------------------------------------------------------------
    //NODE FOR THE LIST :
    static class node
    {
        int data ;
        node next ;
        node(int data){ this.data = data ; next = null ; }
    }
    //HEAD OF THE LIST :
    public static node HEAD = null ;
    //TAIL OF THE LIST :
    public static node TAIL = null ;
    //----------------------------------------------------------------------------------------------
    //create :
    static void insert_at_head(int val)
    {
        node current = HEAD ;
        node temp = new node(val) ;
        if(HEAD == null)
        {
            HEAD = temp ;
            TAIL = temp ;
        }
        else
        {
            temp.next = current ;
            HEAD = temp ;
        }
        System.out.println(val+" successfully added ! ");
    }
    //***********************************************************************************************************
    //REVERSE THE LIST :
    //                        ITERATIVE APPROACH : USING TWO POINTER
    static node reverse_list()
    {
        node current = HEAD ;
        node prev = null ;
        node forward;
        //IF LIST IS EMPTY or LIST CONTAINS ONLY 1 ELEMENT THEN RETURN THE LIST AS IT IS :
        if(HEAD == null || HEAD.next == null)
            return HEAD;
        else
        {
            TAIL = current ;//CHANGE TAIL TO CURRENT HEAD :
            while (current != null)
            {
                //THIS ORDER OF LINK MODIFICATION IS CRUCIAL :
                forward = current.next ; // 1st step .
                current.next = prev ;    // 2nd step .
                prev = current ;         // 3rd step .
                current = forward ;      // 4th step .
            }
            HEAD = prev ;//FINALLY CHANGE HEAD TO CURRENT 'prev' or LAST NODE of PREVIOUS LIST :
            System.out.println("successfully reversed !");
        }
        return HEAD ;
    }
    //                         #OPTIMISTIC RECURSIVE APPROACH :
    static node reverse(node HEAD)
    {
        //BASE CASE :
        if(HEAD == null || HEAD.next == null)
        {
            return HEAD;
        }
        TAIL = HEAD ;//CHANGE TAIL TO CURRENT HEAD :
        node temp = reverse(HEAD.next); // REVERSE THE NODE AFTER HEAD :
        //UPDATE HEAD :
        HEAD.next.next = HEAD ;
        HEAD.next = null ; // POINT CURRENT HEAD TO null :

        return  temp ;
    }
    //**********************************************************************************************

    //----------------------------------------------------------------------------------------------
    //LENGTH :
    static int size(node HEAD)
    {
        node current = HEAD ;
        int length = 0 ;
        if(HEAD == null)
            return  0 ;
        else
        {
            while (current != null)
            {
                length++ ;
                current = current.next ;
            }
        }
        return length ;
    }
    //----------------------------------------------------------------------------------------------
    //DISPLAY LIST :
    static void show_list(node HEAD)
    {
        System.out.println("current status : ") ;
        node current = HEAD ;
        //CHECK IF LIST IS EMPTY :
        if(HEAD == null)
            System.out.println("N/A") ;
        else
        {
            while (current != null)
            {
                System.out.print(current.data+"->") ;
                current = current.next ;
            }
            System.out.println("size("+size(HEAD)+")") ;
        }
    }
    //----------------------------------------------------------------------------------------------
    public static void main(String[] args) {
        insert_at_head(12) ;
        insert_at_head(11) ;
        insert_at_head(10) ;
        insert_at_head(9) ;
        show_list(HEAD) ;

        //ITERATIVE :
        HEAD = reverse_list();
        show_list(HEAD);

        insert_at_head(13);

        //RECURSIVE :
        HEAD = reverse(HEAD) ;
        System.out.println("successfully reversed !") ;
        show_list(HEAD);

        insert_at_head(13) ;
        insert_at_head(14) ;
        show_list(HEAD) ;
    }
}
