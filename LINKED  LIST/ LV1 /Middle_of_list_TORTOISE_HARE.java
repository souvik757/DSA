import java.util.Scanner;

public class Middle_of_list_TORTOISE_HARE {
    //----------------------------------------------------------------------------------------------
    //NODE FOR THE LIST :
    static class NODE
    {
        int data ;
        NODE next ;
        NODE(int data){ this.data = data ; next = null ; }
    }
    //HEAD OF THE LIST :
    public static NODE HEAD = null ;
    //TAIL OF THE LIST :
    public static NODE TAIL = null ;
    //----------------------------------------------------------------------------------------------
    //create :
    static void insert_at_head(int val)
    {
        NODE current = HEAD ;
        NODE temp = new NODE(val) ;
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
    //********************************************************************************
    static NODE GET_MID(NODE HEAD)
    {
        //            :::   FLOYD'S  TORTOISE and HARE  THEORY :::
        //EDGE CASE'S :
        if(HEAD == null)           // if list is empty
            return null;
        if(HEAD.next == null)      // if only 1 element
            return  HEAD ;
        if(HEAD.next.next == null) // if only 2 elements
            return HEAD.next ;
        //GENERIC CASE'S :
        //SLOW TORTOISE ->
        NODE TORTOISE = HEAD ;
        //FAST HARE ->
        NODE HARE = HEAD.next ;

        while (HARE != null && HARE.next != null)
        {
            HARE = HARE.next.next ;
            TORTOISE = TORTOISE.next ;
        }

        return TORTOISE ; // TORTOISE IS IMPORTANT :
    }
    //----------------------------------------------------------------------------------------------
    //LENGTH :
    static int size(NODE HEAD)
    {
        NODE current = HEAD ;
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
    static void show_list(NODE HEAD)
    {
        System.out.println("current status : ") ;
        NODE current = HEAD ;
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
    //-------------------------------------------------------------------------------
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ;
        int T = sc.nextInt();
        while (T-->0)
        {
            System.out.print(" ENTER NUMBER OF INSERTION : ");
            int n = sc.nextInt() ;
            System.out.println(" ENTER DATA'S : [press -1 to ESC]");
            while (n-->0)
            {
                int value = sc.nextInt() ;
                if(value == -1)
                {
                    show_list(HEAD);
                    System.out.println("Mid-element : "+GET_MID(HEAD).data);
                    System.exit(0);
                }
                insert_at_head(value);
                show_list(HEAD);
                System.out.println("Mid-element : "+GET_MID(HEAD).data);
            }
        }
        sc.close();

    }
}