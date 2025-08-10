package boj.hyndaeatuo.dp;

import java.util.Scanner;
//3되니까 제한이 빡셈 나중에 다시 풀래
public class P15988 {

    static int solution(int n){
        int[] dp = new int[n+1];
        if(n==0) return 0;
        if(n == 1) return 1;
        if(n == 2) return 2;
        if(n== 3) return 4;

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4; // 111 12 21 3
        for(int i = 4; i<=n ; i++){
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }

        return dp[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i = 0; i<T; i++){
            System.out.println(solution(sc.nextInt()));
        }
        sc.close();
    }
}
