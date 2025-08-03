package boj.hyndaeatuo.dp.lecture;

import java.util.Scanner;

//수도 배관공사
public class P2073 {

    static int solution(int D, int P, int[][] pipes){
        int[] dp = new int[D+1];
        dp[0] = Integer.MAX_VALUE;
        for(int i = 1; i<=P; i++){
            int l = pipes[i][0];
            int c = pipes[i][1];
            for(int j = D; j>=l; j--){
                if(dp[j-l] != 0){
                    dp[j] = Math.max(dp[j], Math.min(dp[j-l], c));
                }
            }
        }

        return dp[D];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int D = sc.nextInt();
        int P = sc.nextInt();
        int[][] pipes = new int[P+1][2]; //1based
        for(int i = 1; i<=P; i++){
            pipes[i][0] = sc.nextInt(); //Li
            pipes[i][1] = sc.nextInt(); //Ci
        }
        System.out.println(solution(D, P, pipes));
    }
}
