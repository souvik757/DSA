import java.util.Scanner;

class SingleNode {
    int data ;
    SingleNode next ;
    public SingleNode(){
        this.next = null ;
    }
    public SingleNode(int data){
        this.data = data ;
        this.next = null ;
    }
}
class SingularList {

    public int size(int len , SingleNode head){
        return (head == null) ? len : size(len+1, head.next) ;
    }

    public SingleNode getMiddle(SingleNode head){
        if (head == null)
            return null ;
        SingleNode hare = head ;
        SingleNode tortoise = head ;
        while(hare.next != null && hare.next.next != null){
            tortoise = tortoise.next ;
            hare = hare.next.next ;
        }
        return tortoise ;
    }

    public void show(SingleNode head){
        if (head == null)
            return ;
        System.out.print("-> "+head.data);
        show(head.next);
    }
    //  INSERTION
    private SingleNode GetNode(int index , SingleNode head){
        if (head == null)
            return head ;
        if (index == 0)
            return head ;
        return GetNode(index--, head.next) ;
    }

    public SingleNode InsertAtHead(SingleNode head , int val ) {
        SingleNode temp = new SingleNode(val) ;
        SingleNode curNode = head ;
        if (head == null)
            head = temp ;
        else {
            temp.next = curNode ;
            head = temp ;
        }
        System.out.println(val+" inserted !");

        return head ;
    }

    public SingleNode InsertAtTail(SingleNode head , int val){
        SingleNode temp = new SingleNode(val) ;
        SingleNode cuNode = head ;
        if (head == null)
            head = temp ;
        else {
            while(cuNode.next != null)
                cuNode = cuNode.next ;
            cuNode.next = temp ;
        }
        System.out.println(val+" inserted !");

        return head ;
    }

    public SingleNode InsertAtMiddle(SingleNode head , int val) {
        if (head == null)
            return head;
        SingleNode mid = getMiddle(head) ;
        SingleNode temp = new SingleNode(val) ;
        SingleNode currNode = head ;
        while(currNode.next != mid)
            currNode = currNode.next ;
        currNode.next = temp ;
        System.out.println(val+" inserted !");

        return head ;
    }

    public SingleNode InsertAt(int index , int val , SingleNode head){
        if (head == null)
            return head;
        SingleNode Node = GetNode(index, head) ;
        SingleNode curNode = head ;
        while(curNode.next != Node)
            curNode = curNode.next ;
        curNode.next = Node ;
        System.out.println(val+" inserted !");

        return head ;
    }
    // DELETION
    public SingleNode DeleteHead(SingleNode head){
        if (head == null)
            return head ;
        SingleNode curNode = head ;
        if (curNode.next != null){
            curNode = curNode.next ;
            head = curNode ;
        }
        else
            head = null ;

        return head ;
    }
    public SingleNode DeleteTail(SingleNode head){
        if (head == null)
            return head ;
        SingleNode cuNode = head ;
        if (cuNode.next == null){
            cuNode = null ;
            head = cuNode ;
        }
        else {
            while(cuNode.next != null)
                cuNode = cuNode.next ;
            cuNode.next = null ;
        }
        return head ;
    }
    public SingleNode DeleteMid(SingleNode head){
        if (head == null) return head;
        SingleNode MID = getMiddle(head) ;
        SingleNode cuNode = head ;
        while (cuNode.next != MID){
            cuNode = cuNode.next ;
        }
        cuNode.next = cuNode.next.next ;

        return head ;
    }
    public SingleNode Delete(int index , SingleNode head) {
        if (head == null)
            return head;
        SingleNode Node = GetNode(index, head) ;
        SingleNode curNode = head ;
        while (curNode.next != Node)
            curNode = curNode.next ;
        curNode.next = curNode.next.next ;

        return head ;
    }
    public SingleNode Kill(SingleNode head){
        if (head == null)
            return head;
        head.next = null ;
        return DeleteHead(head);
    }
}
public class SinglyList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SingleNode head = new SingleNode(-1) ;
        SingularList object = new SingularList() ;
        int val;
        int index;
        int ch;

        System.out.println(" /***********************************/ ");
        System.out.println("1.  Insert at Head   ->");
        System.out.println("2.  Insert at Tail   ->");
        System.out.println("3.  Insert at middle ->");
        System.out.println("4.  Insert at index  ->");
        System.out.println("5.  Delete  Head     ->");
        System.out.println("6.  Delete  Tail     ->");
        System.out.println("7.  Delete  middle   ->");
        System.out.println("8.  Delete  index    ->");
        System.out.println("9.  SHOW    ->");
        System.out.println("10. KILL    ->");
        System.out.println("-1. ESC");
        System.out.println(" /***********************************/ ");
        do {
            ch = sc.nextInt();
            switch (ch) {
                case 1 -> {
                    System.out.println("Enter value : ");
                    val = sc.nextInt();
                    head = object.InsertAtHead(head, val);
                }
                case 2 -> {
                    System.out.println("Enter value : ");
                    val = sc.nextInt();
                    head = object.InsertAtTail(head, val);
                }
                case 3 -> {
                    System.out.println("Enter value : ");
                    val = sc.nextInt();
                    head = object.InsertAtMiddle(head, val);
                }
                case 4 -> {
                    System.out.println("Enter value : ");
                    val = sc.nextInt();
                    System.out.println("Enter index : ");
                    index = sc.nextInt();
                    head = object.InsertAt(index, val, head);
                }
                case 5 -> head = object.DeleteHead(head);
                case 6 -> head = object.DeleteTail(head);
                case 7 -> head = object.DeleteMid(head);
                case 8 -> {
                    System.out.println("Enter index : ");
                    index = sc.nextInt();
                    head = object.Delete(index, head);
                }
                case 9 ->  object.show(head);
                case 10 -> head = object.Kill(head);
                case -1 -> System.exit(0);
            }
        } while (ch != 0);
    }
}