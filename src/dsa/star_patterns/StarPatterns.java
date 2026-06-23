package dsa.star_patterns;

import java.util.Scanner;

public class StarPatterns {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter input : ");
        int n =5;
        //pattern1
        System.out.println("pattern 1");
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                System.out.print(j);
            }
            System.out.println();
        }
        //pattern2
        System.out.println("pattern 2");
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                System.out.print(i);
            }
            System.out.println();
        }
        // n is 5
        System.out.println("pattern 3");
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n-i+1;j++){
                System.out.print(j);
            }
            System.out.println();
        }
        //pattern 4
        System.out.println("pattern 4");
        for (int i = 0; i < n; i++) {
            for(int j=1;j<=n-i-1;j++){
                System.out.print("-");
            }
            for(int j=1;j<=2*i+1;j++){
                System.out.print("*");
            }
            for(int j=1;j<=n-i-1;j++){
                System.out.print("-");
            }
            System.out.println();
        }

        System.out.println("pattern 5");
        for(int i=1;i<=n;i++){
            for(int j=1;j<i;j++){
                System.out.print("_");
            }
            for(int j=1;j<=2*(n-i+1)-1;j++){
                System.out.print("*");
            }
            for(int j=1;j<i;j++){
                System.out.print("_");
            }
            System.out.println();
        }

        //pattern 6
        System.out.println("pattern 6");
        for(int i=1;i<=2*n-1;i++){
            int stars = i;
            if(i > 5) stars = 2*n - i;
            for(int j=1;j<=stars;j++){
                System.out.print("*");
            }
            System.out.println();
        }

        //pattern 7
        System.out.println("pattern 7");
        for(int i=1;i<=n;i++){
            //spaces -> 4 3 2 1 0
            for(int j=1;j<=n-i;j++) System.out.print(" ");
            //increasing numbers
            for(int j=1;j<=i;j++) System.out.print(j);
            // decreasing numbers
            for(int j=i-1;j>=1;j--) System.out.print(j);
            System.out.println();
        }

        for(int i=n-1;i>=1;i--) {
            //spaces - 1 2 3 4
            for (int j = 1; j <= n - i; j++) System.out.print(" ");
            //increasing sequence
            for (int j = 1; j <= i; j++) System.out.print(j);
            //decreasing sequence
            for (int j = i - 1; j >= 1; j--) System.out.print(j);
            System.out.println();
        }
    }
}
