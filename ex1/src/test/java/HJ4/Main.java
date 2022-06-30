package HJ4;

public class Main {
    public static void main(String[] args) {
        System.out.println(test());
    }
    public static int test() {
        try {
            System.out.println(1);
            return 1;
        } catch (Exception e) {
            return 2;
        } finally {
            System.out.print("3");
        }
    }
}
