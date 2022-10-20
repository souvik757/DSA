import java.util.Scanner;

public class prime_factor {
    static void print_fact(int N)
    {
        if(N%2 != 0)
            return ;
        N = N/2;
        print_fact(N);
        System.out.print(N);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        print_fact(N);
    }
}
