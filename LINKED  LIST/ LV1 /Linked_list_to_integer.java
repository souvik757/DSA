public class Linked_list_to_integer {
    public class Node{
        int data ;
        Node next ;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public Node() {
            next = null ;
        }
    }
    public int getDecimalValue(Node head) {
        String number = "";
        if(head == null)
            return -1 ;
        if(head.data == 0 && head.next == null)
            return 0 ;
        if(head.data == 1 && head.next == null)
            return 1 ;
        Node temp = head ;
        while(temp.next != null){
            number += String.valueOf(temp.data) ;
            temp = temp.next ;
        }
        // return Integer.parseInt(number , 2) ;// an overloaded method of parseInt that returns (int)"number" base 2 ;
        char[] binary = number.toCharArray() ;
        int decimal = 0 ;
        for(int i = binary.length - 1 ; i >= 0 ; i--){
            decimal += Math.pow(2 , binary.length - i - 1) ;
        }
        return decimal ;

    }
}
