import java.util.Scanner;
import java.util.Stack ;
public class remove_mid_element {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in) ;
        Stack<Integer> my_stack = new Stack<>() ;
        int choice ;
        do{
            choice = scan.nextInt() ;
            switch (choice) {
                case 1 -> {
                    int var = scan.nextInt();
                    my_stack.push(var);
                }
                case 2 -> my_stack.pop();
                case 3 -> System.out.println(my_stack);
                case 4 -> {
                    int bottom = 0 ;
                    del_mid(my_stack , my_stack.size() , bottom) ;
                }
            }
        }while (choice != -1) ;
    }
    public static void del_mid(Stack<Integer> my_stack , int n , int bottom)
    {
        if(bottom == n/2)
        {
            my_stack.pop() ;
            return ;
        }
        // store the top element of Stack :
        int number = my_stack.peek() ;
        // delete the top element of Stack :
        my_stack.pop() ;
        // call itself incrementing bottom by 1 :
        del_mid(my_stack , n , bottom+1) ;
        // at last push the stored top elements to Stack :
        my_stack.push(number) ;
    }
}