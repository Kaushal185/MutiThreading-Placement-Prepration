package dsa.dp;

import java.util.Arrays;
import java.util.Scanner;

public class FibonacciDP {
    public static int fibo(int n,int[] dp){
        if(n == 0 || n == 1){
            return dp[n] = n;
        }
        if(dp[n] != -1) return dp[n];
        dp[n] =  fibo(n-1,dp) + fibo(n-2,dp);
        return dp[n];
    }
    public static void main(String[] args) {
        //0, 1, 1, 2, 3, 5
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number: ");
        int input = sc.nextInt();
        int[] dp = new int[input+1];
        Arrays.fill(dp, -1);
        System.out.println("Nth fibonacci number is "+fibo(input,dp));
    }
}
