package boj.hyndaeatuo.dp;

import java.util.Arrays;
import java.util.Scanner;

//행렬 곱셈 순서
public class P11049 {

    static int solution(int n, int[][] matrix){
        int[][] dp = new int[n+1][n+1];
        for(int[] x : dp) Arrays.fill(x, Integer.MAX_VALUE);
        for(int i = 1; i<=n; i++) dp[i][i] = 0;

        for(int len = 2; len<=n; len++){
            for(int i = 1; i+len-1 <= n; i++){
                int j = i+len-1;
                for(int mid = i; mid<j; mid++){
                    dp[i][j] = Math.min(dp[i][j], dp[i][mid] + dp[mid+1][j]
                            + matrix[i][0] * matrix[mid][1] * matrix[j][1]);
                }
            }
        }
        return dp[1][n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] matrix = new int[n+1][2];
        for(int i = 1; i<=n; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            matrix[i][0] = a;
            matrix[i][1] = b;
        }

        System.out.println(solution(n, matrix));
    }
}
