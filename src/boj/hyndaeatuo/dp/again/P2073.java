package boj.hyndaeatuo.dp.again;

import java.util.Scanner;

//수도배관공사
public class P2073 {

    static int solution(int d, int p, int[][] pipes){
        int[] dp = new int[d+1];
        dp[0] = Integer.MAX_VALUE;

        //유한냅색
        for(int i = 0; i<p; i++){
            int l = pipes[i][0];
            int c = pipes[i][1];

            for(int j = d; j>=l; j--){
                if(dp[j-l] == 0) continue;
                dp[j] = Math.max(dp[j], Math.min(dp[j-l],c));
            }
        }

        return dp[d];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int d = sc.nextInt();
        int p = sc.nextInt();
        int[][] pipes = new int[p][2];

        for(int i=0; i<p; i++){
            pipes[i][0] = sc.nextInt(); //L
            pipes[i][1] = sc.nextInt(); //C
        }

        System.out.println(solution(d, p, pipes));
    }
}
