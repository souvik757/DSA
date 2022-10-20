import java.util.Scanner;
class gcdLcm
{
    double X, Y;
    gcdLcm(double X, double Y)
    {
        this.X = X;
        this.Y = Y;
    }
    static double gcd(double a, double b)
    {
        //base case:
        if(b == 0)
            return a;
        //relation:
        return gcd(b,a%b);
    }
    static double lcm(double a, double b)
    {
        //base case:
        if(a == 0 || b == 0)
            return 0;
        //relation:
        return Math.abs((a*b)/gcd(a,b));
    }
    void get_gcd()
    {
        System.out.println("GCD : "+gcd(this.X,this.Y));
    }
    void get_lcm()
    {
        System.out.println("LCM : "+lcm(this.X,this.Y));
    }

}
public class GCD_LCM
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-->0)
        {
            int X = sc.nextInt();
            int Y = sc.nextInt();

            gcdLcm ob1 = new gcdLcm(X,Y);
            ob1.get_gcd();
            ob1.get_lcm();
        }
        sc.close();
    }
}
