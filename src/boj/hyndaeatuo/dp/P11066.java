package boj.hyndaeatuo.dp;

import java.util.Scanner;

//파일 합치기
public class P11066 {

    static int solution(int k, int[] chapter) {
        int[] prefix = new int[k+1]; //총합을 저장하는 배열
        for (int i = 1; i <= k; i++) prefix[i] = prefix[i-1] + chapter[i-1];

        int[][] dp = new int[k+1][k+1];

        for (int len = 2; len <= k; len++) { // 구간 길이
            for (int i = 1; i + len - 1 <= k; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;
                for (int mid = i; mid < j; mid++) {
                    dp[i][j] = Math.min(dp[i][j],
                            dp[i][mid] + dp[mid+1][j] + prefix[j] - prefix[i-1]);
                }
            }
        }
        return dp[1][k];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i = 0; i<t; i++){
            int k = sc.nextInt();
            int[] chapter = new int[k];
            for(int j = 0; j<k; j++){
                chapter[j] = sc.nextInt();
            }
            System.out.println(solution(k, chapter));
        }
        sc.close();
    }
}
