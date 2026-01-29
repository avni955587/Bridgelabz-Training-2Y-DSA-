
public class reverse {

    public static void prrint(int n) {
        if (n==0) return;  // base cond.
        System.out.println(n);
        prrint(n-1);
    }
    public static void main(String[] args) {
        int a=10;
        System.out.println(a);
        prrint(5);
        int b=15;
        System.out.println(b);
    }
    
}
