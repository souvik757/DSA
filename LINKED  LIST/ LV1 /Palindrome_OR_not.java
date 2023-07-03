import java.util.Scanner;

public class Palindrome_OR_not {
    static class node
    {
        int data ;
        node next ;
        node(int data){ this.data = data ; next = null ; }
    }
    public static node HEAD = null ;
    public static node TAIL = null ;

    //-----------------------------------------------------------------------------------
    //ARRAY METHOD : APPROACH `1`
    static boolean check_if_palindrome(int[] numbs)
    {
        int count = -1 ;
        for( int i = 0 ; i < numbs.length ; i++ )
        {
            if(numbs[i] != numbs[numbs.length-1-i])
            {
                count++ ;
                break ;
            }
        }
        return count == -1;
    }

    static void copy(node HEAD , int[] numbs)
    {
        node current = HEAD ;
        if(HEAD == null)
            return ;
        int len = size(HEAD) ;
        for (int i = 0 ; i < len ; i++)
        {
            numbs[i] = current.data ;
            current = current.next ;
        }
    }
    //-----------------------------------------------------------------------------------



    //APPROACH 2 : :: TWO POINTER ::
    static boolean is_palindrome(node HEAD)
    {
        if(HEAD == null || HEAD.next == null)
            return true ;
        // 1 . Declare slow pointer which is actually a reference node of head :
        node slow = HEAD ;
        // 2 . Take a reference node next to middle :
        node temp = GET_MID(HEAD).next ;
        // 3 . reverse the list from that reference node and connect it with middle :
        GET_MID(HEAD).next = reversed(temp) ;
        // 4 . Declare fast pointer next to middle :
        node fast = GET_MID(HEAD).next ;
        // 5 . Comparison between data's of slow and fast node :
        while (fast != null)
        {
            if(slow.data != fast.data)
                return false ;
            slow = slow.next ;
            fast = fast.next ;
        }
        // 6 . revert changes made at step 3.
        temp = GET_MID(HEAD).next ;
        GET_MID(HEAD).next = reversed(temp) ;

        return true ;
    }



    //TO GET MIDDLE :
    static node GET_MID(node HEAD)
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
        node TORTOISE = HEAD ;
        //FAST HARE ->
        node HARE = HEAD.next ;

        while (HARE != null && HARE.next != null)
        {
            TORTOISE = TORTOISE.next ;
            HARE = HARE.next.next ;
        }

        return TORTOISE ; // TORTOISE IS IMPORTANT :
    }

    //TO REVERSE :
    static node reversed(node HEAD)
    {
        //BASE CASE :
        if(HEAD == null || HEAD.next == null)
        {
            return HEAD;
        }
        TAIL = HEAD ;//CHANGE TAIL TO CURRENT HEAD :
        node temp = reversed(HEAD.next); // REVERSE THE NODE AFTER HEAD :
        //UPDATE HEAD :
        HEAD.next.next = HEAD ;
        HEAD.next = null ; // POINT CURRENT HEAD TO null :
        return  temp ;
    }

    //********************************************************************************************************
    static void insert(int value)
    {
        node temp = new node(value) ;
        node current = HEAD ;
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
    }
    //--------------------------------------------------------------------------------------------
    //LENGTH OF THE LIST :

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

    //-------------------------------------------------------------------------------------------
    //DISPLAY :
    static void show_list(node HEAD)
    {
        node current = HEAD ;
        System.out.println("CURRENT STATUS : ");
        if(HEAD == null)
            System.out.println("N/A");
        else
        {
            while (current != null)
            {
                System.out.print(current.data+"->");
                current = current.next ;
            }
            System.out.println("size("+size(HEAD)+")");
        }
    }
    //--------------------------------------------------------------------------------------------------------

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ;
        System.out.print(" ENTER NUMBER OF INSERTION : ");
        int n = sc.nextInt() ;
        System.out.println(" ENTER DATA'S : [press -1 to ESC]");
        while (n-->0)
        {
            int value = sc.nextInt() ;
            if(value == -1)
            {
                show_list(HEAD);
                System.exit(0);
            }
            insert(value);
            show_list(HEAD);
        }
        System.out.println("head : "+HEAD.data);
        System.out.println("tail : "+TAIL.data);
        System.out.println("\n 1 . By Approach 1 \n 2 . By Approach 2 \n 3 . EXIT");
        int ch = sc.nextInt() ;
        switch (ch) {
            case 1 -> {
                //TEST CASE
                //BY APPROACH 1 :: ( ARRAY METHOD ) ::
                System.out.println();
                int[] numbs = new int[size(HEAD)];
                copy(HEAD, numbs);
                System.out.print("[");
                for (int i = 0; i < size(HEAD); i++)
                    System.out.print(numbs[i] + " ");
                System.out.print("]");
                System.out.println("->>PALINDROME?->>");
                if (check_if_palindrome(numbs))
                    System.out.print("//YES//");
                else
                    System.out.print("//NO//");
            }
            case 2 -> {
                //BY APPROACH 2 :: ( FLOYD's TORTOISE & HARE METHOD ) ::
                show_list(HEAD);
                System.out.println("->>PALINDROME?->>");
                if (is_palindrome(HEAD))
                    System.out.println("//YES//");
                else
                    System.out.println("//NO//");
            }
            case 3 -> System.exit(0);
        }

    }
}