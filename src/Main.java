public class Main {
    // function calling itself
    public static void show(int counter) {
        // show() - exactly 5 times | int counter = 1;
        if(counter <= 5) {
            System.out.println("show() - " + counter);
            show(counter += 1);
            System.out.println("BACKTRACK - " + counter);
        }
    }
    public static void main(String[] args) {
        show(1);
    }
}
