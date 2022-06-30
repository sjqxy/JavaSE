package HJ2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine().toUpperCase();
        String next = sc.next().toUpperCase();
            int m=0;
            for (int i = 0; i <s.length() ; i++) {
                if (next.equalsIgnoreCase(s.substring(i,i+1))){
                    m++;
                }
            }
            System.out.println(m);
        }


    }



