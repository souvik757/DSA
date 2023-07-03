import java.util.Scanner;

public class _25_Reverse_in_k_groups {
    //-----------------------------------------------------------------------------------------------------------------
    //NODE FOR THE LIST :
    static class NODE
    {
        int data ;
        NODE next ;
        NODE(int data){ this.data = data ; next = null ; }
    }
    //HEAD OF THE LIST :
    public static NODE HEAD = null ;
    //------------------------------------------------------------------------------------------------------------------
    //create :
    static void insert_at_head(int val)
    {
        NODE current = HEAD ;
        NODE temp = new NODE(val) ;
        if (HEAD != null) {
            temp.next = current;
        }
        HEAD = temp ;
        System.out.println(val+" successfully added ! ");
    }

    //*****************************************************************************************************************
    static NODE kReverse(NODE HEAD , int k)
    {
        if(HEAD == null)
            return null ;
        NODE current = HEAD ;
        NODE prev = null ;
        NODE forward = null ;
        int c = 0 ;
        while ( current != null && c<k )
        {
            forward = current.next ;
            current.next = prev ;
            prev = current ;
            current = forward ;
            c++ ;
        }
        if(forward != null) {
//            HEAD.next = forward ;
            HEAD.next = kReverse(forward , k) ;
        }
        return prev ;
    }

    //------------------------------------------------------------------------------------------------------------------
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
    //-----------------------------------------------------------------------------------------------------------------
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
    //-----------------------------------------------------------------------------------------------------------------
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ;
        int T = sc.nextInt();
        while (T-->0)
        {
            System.out.print("ENTER VALUE OF K : ");
            int k = sc.nextInt() ;
            System.out.print("\nENTER NUMBER OF INSERTION : ");
            int n = sc.nextInt() ;
            System.out.print("\nENTER DATA'S : [press -1 to ESC]");
            while (n-->0)
            {
                int value = sc.nextInt() ;
                if(value == -1)
                {
                    show_list(HEAD);
                    System.exit(0);
                }
                insert_at_head(value);
                show_list(HEAD);
            }
            HEAD = kReverse(HEAD , k) ;
            System.out.println("AFTER "+k+" REVERSAL OPERATION :") ;
            show_list(HEAD) ;
        }
        sc.close() ;
    }
}