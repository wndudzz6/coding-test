package boj.august.dp;

import java.util.Scanner;

public class P12865_평범한배낭 {

    static int solution(int[][] items, int n, int k){
        int[] dp = new int[k+1];

        //유한 냅색
        for(int i = 0; i<n; i++){
            int w = items[i][0];
            int v = items[i][1];
            for(int j = k; j>=w; j--){
                dp[j] = Math.max(dp[j], dp[j-w]+v);
            }
        }

        return dp[k]; //해당 무게에서의 최대 가치
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //물품의 수
        int k = sc.nextInt(); //견딜 수 있는 무게

        int[][] items = new int[n][2];
        for(int i = 0; i<n; i++){
            int w = sc.nextInt();
            int v = sc.nextInt();
            items[i][0] = w;
            items[i][1] = v;
        }

        System.out.println(solution(items, n, k));
    }
}
