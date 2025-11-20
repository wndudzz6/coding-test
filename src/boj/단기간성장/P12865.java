package boj.단기간성장;

import java.util.Scanner;

//평범한 배낭
public class P12865 {

    static int solution(int n, int k, int[][] items){
        int[] dp = new int[k+1];
        //유한 냅색 역방향
        for(int i = 0; i<n; i++){
            int w = items[i][0];
            int v = items[i][1];
            for(int j = k; j>=w; j--){
                dp[j] = Math.max(dp[j], dp[j-w]+v);
            }
        }

        return dp[k];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[][] items = new int[n][2];
        for(int i = 0; i<n; i++){
            items[i][0] = sc.nextInt();
            items[i][1] = sc.nextInt();
        }
        sc.close();
        System.out.println(solution(n,k, items));
    }
}
