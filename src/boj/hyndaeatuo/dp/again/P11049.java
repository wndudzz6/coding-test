package boj.hyndaeatuo.dp.again;

import java.util.Arrays;
import java.util.Scanner;

//행렬 곱셈 순서
public class P11049{

    static int solution(int n, int[][] mat){
        //어디 구간까지 곱할것인가?
        int[][] dp = new int[n+1][n+1];
        for(int[] x : dp) Arrays.fill(x, Integer.MAX_VALUE/4);
        for(int i = 1; i<=n; i++) dp[i][i] = 0;

        for(int len = 2; len<=n; len++){
            for(int i = 1; len+i-1<=n; i++){
                int j = len+i-1;
                for(int mid = i; mid<j; mid++){
                    dp[i][j] = Math.min(dp[i][j], dp[i][mid]+dp[mid+1][j]+
                            mat[i][0] * mat[mid][1] * mat[j][1]);
                }
            }
        }
        return dp[1][n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] mat = new int[n+1][2];

        for(int i = 1; i<=n; i++){
            mat[i][0] = sc.nextInt();
            mat[i][1] = sc.nextInt();
        }
        sc.close();

        System.out.println(solution(n, mat));
    }
}
