import java.util.Scanner;

public class Singly_List {
//---------------------------------------------------------------------------------------------------------------
    //NODE FOR LIST :
    static class node
    {
        /*
                                                -----------
                                               |     |     |
                                               |data |next-|-->null
                                               |     |     |
                                                -----------
         */
        int data ;
        node next ;
        node(int data){this.data = data ; next = null ;}
    }
//----------------------------------------------------------------------------------------------------------------
    //HEAD OF THE LIST :
    public static node head = null ;
    //TAIL OF THE LIST :
    public static node tail = null ;
//---------------------------------------------------------------------------------------------------------------
    static int size()
    {
        //CHECK IF LIST IS EMPTY :
        if(head == null)
            return 0 ;
        //TAKE A NODE POINTS TO HEAD :
        node current = head ;
        //TRAVERSE till LAST NODE , WHOSE NEXT PART IS null :
        int length = 0 ;
        while (current != null)
        {
            current = current.next ;
            length++ ;
        }
    return length ;
    }
//----------------------------------------------------------------------------------------------------------------
    static void insert_at_head(int val)
    {
        // MAKE ANOTHER NODE , WHICH CONTAINS THE 'val' :
        node temp = new node(val) ;
        // REFERENCE NODE OF HEAD :
        node current = head ;
        // CHECK IF LIST IS EMPTY :
        if( head == null )
        {
            head = temp ;
            tail = temp ;
        }
        else
        {
            temp.next = current ;
            head = temp ;
        }
        System.out.println(val+" successfully inserted !");
    }


//---------------------------------------------------------------------------------------
    static void insert_at_tail(int val)
    {
        //MAKE ANOTHER NODE , WHICH CONTAINS THE 'val' :
        node temp = new node(val) ;
        node current = head ;//THIS NODE POINTS TO HEAD :
        //CHECK IF LIST IS EMPTY :
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
        System.out.println(val+" successfully inserted !");
    }

//---------------------------------------------------------------------------------------
   static void insert_at_middle(int val)
   {
       node temp = new node(val);
       node current = head ;
       int mid;
       if(head == null)
           insert_at_head(val);
       else
       {
           if(size()%2 == 0)
               mid = size()/2 ;
           else
               mid = size()/2 + 1 ;
           while (mid-->1)//no conditional statement so no need to worry about the '--'
           {
               current = current.next ;
           }
           temp.next = current.next ;
           current.next = temp ;
       }
       System.out.println(val+" successfully inserted !");
   }


//---------------------------------------------------------------------------------------
    static void insert_at_index(int index, int val)
    {
        node temp = new node(val);
        node current = head ;
        if(head == null || index == 1)
        {
            insert_at_head(val);
            return ;
        }
        else if(index == size())
        {
            insert_at_tail(val);
            return ;
        }
        else
        {
            while (index-- > 1) {
                current = current.next;
            }
            temp.next = current.next;
            current.next = temp;
        }
        System.out.println(val+" successfully inserted !");
    }
//---------------------------------------------------------------------------------------
   static void delete_head()
   {
       int val = head.data ;
       head = head.next ;
       System.out.println(val+" successfully deleted !");
   }
//---------------------------------------------------------------------------------------
    static void delete_tail()
    {
        int val = tail.data ;
        node current = head ;
        if(head == null)
            System.out.println("N/A");
        else
        {
            while (current.next.next != null)
            {
                current = current.next ;
            }
            current.next = null ;
            tail = current ;
        }
        System.out.println(val+" successfully deleted !");
    }

//---------------------------------------------------------------------------------------
    static void delete_middle()
    {
        int val = 0 ;
        int mid ;
        node current = head ;
        if(head == null)
            System.out.println("N/A");
        else
        {
            if(size()%2 == 0)
                mid = size()/2 ;
            else
                mid = size()/2 + 1 ;
            mid-- ;//use if -  else->if - else to avoid index decrement
            while (mid-->1)
            {
                current = current.next ;
            }
            val = current.next.data ;
            current.next = current.next.next;
        }
        System.out.println(val+" successfully deleted !");
    }

//---------------------------------------------------------------------------------------
   static void delete_index(int index)
   {
       node current = head ;
       node previous = null ;
       if(head == null)
           System.out.println("N/A");
       else
       {
           if(index == 1)
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
               while (index-- > 0) {
                   previous = current;
                   current = current.next;
               }
               assert previous != null;
               previous.next = current.next;
           }
       }
       System.out.println(" successfully deleted !");
   }

//---------------------------------------------------------------------------------------
    //func needs to be rectified :
    static void kill()//TO DELETE THE ENTIRE LIST :
    {
        if(head == null)
            System.out.println("N/A");
        else
        {
            head.next = null ;
            tail = head;
            delete_head();
        }
        System.out.println(" List killed !");
    }

//---------------------------------------------------------------------------------------
   static void show_list()
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
       System.out.println("size("+size()+")");
       System.out.println(" head -> "+head.data);
       System.out.println(" tail -> "+tail.data);
   }


//---------------------------------------------------------------------------------------
    public static void main(String[] args) {
        int val;
        int index;
        Scanner sc = new Scanner(System.in);
        int ch;
        do {
            System.out.println(" /***********************************/ ");
            System.out.println("1. Insert at **Head**   ->");
            System.out.println("2. Insert at **Tail**   ->");
            System.out.println("3. Insert at **middle** ->");
            System.out.println("4. Insert at **index**  ->");
            System.out.println("5. Delete  **Head**     ->");
            System.out.println("6. Delete  **Tail**     ->");
            System.out.println("7. Delete  **middle**   ->");
            System.out.println("8. Delete  **index**    ->");
            System.out.println("9.  **SHOW**    ->");
            System.out.println("10. **KILL**    ->");
            System.out.println("-1. **ESC**");
            System.out.println(" /***********************************/ ");
            ch = sc.nextInt();
            switch (ch) {
                case 1 -> {
                    System.out.println("Enter value : ");
                    val = sc.nextInt();
                    insert_at_head(val);
                }
                case 2 -> {
                    System.out.println("Enter value : ");
                    val = sc.nextInt();
                    insert_at_tail(val);
                }
                case 3 -> {
                    System.out.println("Enter value : ");
                    val = sc.nextInt();
                    insert_at_middle(val);
                }
                case 4 -> {
                    System.out.println("Enter value : ");
                    val = sc.nextInt();
                    System.out.println("Enter index : ");
                    index = sc.nextInt();
                    insert_at_index(index, val);
                }
                case 5 -> delete_head();
                case 6 -> delete_tail();
                case 7 -> delete_middle();
                case 8 -> {
                    System.out.println("Enter index : ");
                    index = sc.nextInt();
                    delete_index(index);
                }
                case 9 -> show_list();
                case 10 -> kill();
                case -1 -> System.exit(0);
            }
        } while (ch != 0);
    }
}