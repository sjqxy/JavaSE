package HJ3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        int [] b=new int[i];
        for (int j = 0; j < i; j++) {
            b[j] = sc.nextInt();
        }
    }
}
