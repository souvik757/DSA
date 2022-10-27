import java.util.LinkedList;

class MinStack {
    LinkedList<Integer> myList = new LinkedList<>() ;
    int min ;
    public MinStack() {
        min = Integer.MAX_VALUE ;
    }

    public void push(int val) {
        myList.addLast(val) ;
        min = Math.min(min , top()) ;
    }

    public void pop() {
        myList.removeLast() ;
    }

    public int top() {
        return myList.get(myList.size()-1);
    }

    public int getMin() {
        return this.min ;
    }
    public void show()
    {
        System.out.println(myList);
    }
}


class Stack
{
    int[] num ;
    int top ;
    int size ;
    int min ;
    int max ;
    Stack(int size) // Constructor of Stack class :
    {
        top = -1 ;
        this.size = size ;
        num = new int[this.size] ;
        min = Integer.MAX_VALUE ;
        max = Integer.MIN_VALUE ;
    }
    public void push(int val)
    {
        /*
        condition for Stack overflow:
        if -> top > this.size
        else -> top++ ;
         */
        if(top > this.size)
            return ;
        else
        {
            top = top + 1 ;
            num[top] = val ;
            min = Math.min(min , val) ;
            max = Math.max(max , val) ;
        }
    }

    public void pop()
    {
        if(top == -1)
            return ;
        else
            top = top - 1 ;
    }

    public int peek()
    {
        if(top == -1)
            return -1 ;
        else
            return num[top] ;
    }
    public void show()
    {
        if(top == -1)
            return ;
        else
        {
            System.out.print("[");
            for(int i = 0 ; i <= this.top ; i++)
                System.out.print(num[i]+",");
            System.out.print("]\n");
        }
    }
}

public class Implementation {
    public static void main(String[] args) {
        Stack myStack = new Stack(8) ;
        myStack.push(-2);
        myStack.push(0);
        myStack.push(-3);
        myStack.show() ;
        System.out.println(myStack.min);
        myStack.pop();
        System.out.println(myStack.min);

        MinStack stack2 = new MinStack() ;
        stack2.push(-2);
        stack2.push(0);
        stack2.push(-3);
        stack2.show();
        System.out.println(stack2.min);
        stack2.pop();
        System.out.println(stack2.min);
    }
}
