package boj.hyndaeatuo.binary;

import java.util.Scanner;

public class P1890 {

    static long solution(int n, int[][] board) {
        long[][] dp = new long[n][n]; // 각 위치에서 목표 지점까지 도달하는 경로의 수
        dp[0][0] = 1; //dp[x][y]는 좌표에서의 경로 개수

        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                int jump = board[i][j];

                if(jump == 0) continue;

                if(j+jump<n) dp[i][j+jump] +=dp[i][j];
                if(i+jump<n) dp[i+jump][j] += dp[i][j];
            }
        }
        return dp[n-1][n-1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] board = new int[n][n]; // 0-based
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        sc.close();
        System.out.println(solution(n, board)); // 목표지점에 도달한 경로 수 출력
    }
}
