package boj.hyndaeatuo.dp.again;

import java.util.Arrays;
import java.util.Scanner;

//파일합치기 다시 풀어보기
public class P11066 {

    static int solution(int n, int[] prefix){
        int[][] dp = new int[n+1][n+1]; //1based
        for(int[] x : dp) Arrays.fill(x, Integer.MAX_VALUE);
        for(int i = 1; i<=n; i++) dp[i][i] = 0; //자기자신 합치는 비용은 0

        for(int len = 2; len<=n; len++){
            for(int i = 1; i+len-1<=n ; i++){
                int j = i+len-1;
                for(int mid = i; mid < j; mid++){
                    dp[i][j] = Math.min(dp[i][j], dp[i][mid]+dp[mid+1][j] +
                            prefix[j]-prefix[i-1]);
                }
            }
        }
        return dp[1][n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0; i<t; i++){
            int n = sc.nextInt();
            int[] prefix = new int[n+1];
            for(int j = 1; j<=n; j++){
                prefix[j] += prefix[j-1] + sc.nextInt();
            }
            System.out.println(solution(n, prefix));
        }
    }
}
