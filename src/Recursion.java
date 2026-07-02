public class Recursion {
    public static int fib(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;

        return fib(n-1) + fib(n-2);
    }
    public static int show(int counter) {
        // int counter = 1;
        if(counter <= 5) {
            System.out.print(counter + " ");
            int ans = show(counter += 1);
            System.out.print(ans + " ");
        }
        return counter;
    }
    public static void main(String[] args) {
        // System.out.println( show(1) );
        System.out.println( fib(12) );
    }
}
