public class Reverse_DLL {
    // NODE :
    static class node
    {
        int data ;
        node prev ;
        node next ;
        node(int data)
        {
            this.data = data ;
            prev = null ;
            next = null ;
        }
    }
    // head :
    public static node head = null ;
    // tail :
    public static node tail = null ;
    // create list :
    static void insert(int val)
    {
        node temp = new node(val) ;
        node current = head ;
        if(head == null)
        {
            head = temp ;
            tail = temp ;
        }
        else
        {
            temp.next = current ;
            current.prev = temp ;
            head = temp ;
        }
        System.out.println(val+" successfully inserted !");
    }
    // display :
    static void showList(node head)
    {
        System.out.print("CURRENT STATUS : null<-");
        int length = 0 ;
        node current = head ;
        if(head == null)
            System.out.println("N/A") ;
        else
        {
            while(current != null)
            {
                if(current.next == null)
                    System.out.print(current.data+"->");
                else
                    System.out.print(current.data+"<->");
                current = current.next ;
                length++ ;
            }
        }
        System.out.println("null :\n: size("+length+")");
    }
    // REVERSE :
    static node reverse(node head)
    {
        node current = head ;
        node back = null ;
        node after;
        if(head == null || head.next == null)
            return head;
        else
        {
            tail = current ;
            while (current != null)
            {
                after = current.next ;
                current.next = back ;
                current.prev = after ;
                back = current ;
                current = after ;
            }
        }
        System.out.println(" successfully reversed !! ") ;
        return back ;
    }
    // main() function :
    public static void main(String[] args) {
        insert(57) ;
        insert(56) ;
        insert(55) ;
        insert(54) ;
        insert(53) ;
        insert(52) ;
        showList(head) ;
        node temp = reverse(head) ;
        showList(temp) ;
    }
}