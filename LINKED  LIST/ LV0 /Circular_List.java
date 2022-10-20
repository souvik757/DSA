import java.util.Scanner;

public class Circular_List {
    //---------------------------------------------------------------------------------
    //NODE FOR LIST :
    static class node
    {
        /*                             tail
                                    -----------
                                   |     |     |
                                   |data |next-|-->current
                                   |     |     |
                                    -----------
                                      current
         */
        int data ;
        node next ;
        node(int data){ this.data = data ; next = null ; }
    }
    //concept of head is invalid here,cause its arbitrary/unpredictable where it starts :
    //TAIL OF THE LIST :
    public static node TAIL = null ;

    //-----------------------------------------------------------------------------------
    //INSERTION :
    //To insert a node , we have to be provided with an element that already exists
    //in the list , just after the index position of that element we add the NEW NODE .
    //-----------------------------------------------------------------------------------
    static void insert(int val)
    {
        node temp = new node(val);
        //CHECK IF LIST IS ALREADY EMPTY :
        if(TAIL == null)
        {
            TAIL = temp ;
            TAIL.next = temp ;
        }
        temp.next = TAIL.next ;
        TAIL.next = temp ;
        TAIL = temp ;
        System.out.println(val+" successfully inserted !");
    }
    //-----------------------------------------------------------------------------------
    static void insert_at_middle(int val)
    {
        //insert at a certain index is same as this :
        //instead of mid there will be a given index :
        //and 1 condition : if index == 1 or size() -> use 'insert(val)'
        node current = TAIL ;
        node temp = new node(val) ;
        int mid ;
        if(TAIL == null)
        {
            insert(val);
        }
        else
        {
            if(size()%2 == 0)
                mid = size()/2 ;
            else
                mid = size()/2 + 1 ;
            //System.out.println(mid);
            do {
                current = current.next ;
            }while (mid-->1) ;
            //System.out.println(current.data);
            temp.next = current.next ;
            current.next = temp ;
            System.out.println(val+" successfully inserted at mid !");
        }
    }
    //-----------------------------------------------------------------------------------
    static void delete_tail()
    {
        node current = TAIL ;
        node prev;
        if(TAIL == null)
            System.out.println("N/A");
        else
        {
            do {
                prev = current ;
                current = current.next ;
            }while (current != TAIL) ;
            int value = current.data ;
            prev.next = current.next ;
            current.next = null ;
            TAIL = prev ;
            System.out.println(value+" successfully deleted !");
        }
    }
    //-----------------------------------------------------------------------------------
    static void delete_head()
    {
        if(TAIL == null)
            System.out.println("N/A");
        else
        {
            int value = TAIL.next.data ;
            TAIL.next = TAIL.next.next ;
            System.out.println(value+" successfully deleted !");
        }
    }
    //-----------------------------------------------------------------------------------
    static void delete_value(int val)
    {
        node current = TAIL ;
        node prev;
        if(TAIL == null)
            System.out.println("N/A");

        if(val == TAIL.data)
        {
            delete_tail();
        }
        else if(val == TAIL.next.data)
        {
            delete_head();
        }
        else
        {
            do {
                prev = current ;
                current = current.next ;
            }while (current.data != val) ;
            prev.next = current.next ;
            System.out.println(val+" successfully deleted !");
        }
    }
    //-----------------------------------------------------------------------------------
    //LENGTH :
    static int size()
    {
        node current = TAIL ;
        int length = 0 ;
        if(TAIL == null)
            return 0 ;
        else
        {
            do {
                length++ ;
                TAIL = TAIL.next ;
            }while (TAIL != current);
        }
        return length ;
    }
    //-----------------------------------------------------------------------------------
    //TRAVERSAL :
    static void show_list()
    {
        System.out.println("Current status : ");
        System.out.print("Starting from TAIL : ");
        node current = TAIL ;
        if(TAIL == null)
            System.out.println("N/A");
        else
        {
            System.out.print("<->");
            do {
                System.out.print(TAIL.data+" ");
                TAIL = TAIL.next ;
            }while (TAIL != current);
            System.out.print("<->");
            System.out.println("size("+size()+")");
            System.out.println("TAIL -> "+TAIL.data);
        }
    }
    //-----------------------------------------------------------------------------------
    public static void main(String[] args) {
        int val;
        Scanner sc = new Scanner(System.in);
        int ch;
        do {
            System.out.println(" /***********************************/ ");
            System.out.println("1. Insert            ->");
            System.out.println("2. Insert at middle  ->");
            System.out.println("3. Delete  **Head**  ->");
            System.out.println("4. Delete  **Tail**  ->");
            System.out.println("5. Delete  **value** ->");
            System.out.println("6.  **SHOW**    ->");
            System.out.println("-1. **ESC**");
            System.out.println(" /***********************************/ ");
            ch = sc.nextInt();
            switch (ch) {
                case 1 -> {
                    System.out.println("Enter value : ") ;
                    val = sc.nextInt() ;
                    insert(val) ;
                }
                case 2 -> {
                    System.out.println("Enter value : ") ;
                    val = sc.nextInt() ;
                    insert_at_middle(val);
                }
                case 3 -> delete_head() ;
                case 4 -> delete_tail() ;
                case 5 -> {
                    System.out.println("Enter value : ") ;
                    val = sc.nextInt() ;
                    delete_value(val);
                }
                case 6 -> show_list() ;
                case -1 -> System.exit(0);
            }
        } while (ch != 0);
    }
}
