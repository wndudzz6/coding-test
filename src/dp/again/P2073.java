package dp.again;

import java.util.*;
//백준 수도 배관공사 P2
public class P2073 {

    static int solution(int d, int p, int[] L, int[] C){
        int[]dp = new int[d+1];
        //dp[i] i만큼의 거리가 될 때 최대 용량 저장/누적
        //dp 초기화?
        dp[0] = Integer.MAX_VALUE;
        for(int i = 0; i<p; i++){
            int l = L[i];
            int c = C[i];
            for(int j = d; j>=l; j--){
                if(dp[j-l]==0) continue;
                dp[j] = Math.max(dp[j], Math.min(dp[j-l], c));
            }
        }
        return dp[d];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int d = sc.nextInt();
        int p = sc.nextInt();
        int[] L = new int[p];
        int[] C = new int[p];
        for(int i = 0; i<p; i++){
            L[i] = sc.nextInt();
            C[i] = sc.nextInt();
        }
        sc.close();
        System.out.println(solution(d,p,L,C));
    }
}
