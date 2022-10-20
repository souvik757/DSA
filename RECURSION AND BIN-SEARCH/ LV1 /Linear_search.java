import java.util.Scanner;

public class Linear_search
{
    static int linear_search(int[] number, int S, int N, int key)
    {
        //base case:
        if(N == 0)
            return -1;

        //relation:
        if(number[S] == key)
            return S+1;
        else
            return linear_search(number,S+1,N-1,key);
    }



    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] number = new int[N];
        for(int i = 0 ; i < N ; i++)
        {
            number[i] = sc.nextInt();
        }
        int key = sc.nextInt();
        int answer = linear_search(number,0,N,key);
        System.out.println(key+" at : "+answer+" index .");
        if(answer == -1)
        {
            System.out.println("[ -1 means Key not found ]");
        }
        sc.close();
    }
}
