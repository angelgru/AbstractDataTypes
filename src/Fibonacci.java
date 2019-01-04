public class Fibonacci {

    static long[] f = new long[90];

    static long fibonacci(int n) {
        if(n == 0)
            return 0;
        if(n == 1)
            return 1;
        if(f[n] > 0)
            return f[n];
        return fibonacci(n-1) + fibonacci(n-2);
    }

    public static void main(String[] args) {
        System.out.println(fibonacci(10));
    }
}
