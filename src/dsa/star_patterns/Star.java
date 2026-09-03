package dsa.star_patterns;

import java.util.Scanner;

public class Star {

    static void main() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter input here");
//        int input = in.nextInt();
        int input = 5;
        System.out.println("Pattern1");
        for(int i=1;i<=input;i++){
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
        /*
        spaces -> 4,3,2,1,0
        stars  -> 1,2,3,4,5
        j      -> 1,2,3,4,5
         */
        System.out.println("Pattern 2");
        for(int i=0;i<input;i++){
            for (int k = 1; k <= input-i ;k++){
                System.out.print("_");
            }
            for(int j=0;j<=i;j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
