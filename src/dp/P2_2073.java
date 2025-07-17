package dp;

import java.util.Scanner;

//2. 수도배관공사
//최소치 중 최대치를 찾는다.
public class P2_2073 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int d = sc.nextInt(); //거리
        int p = sc.nextInt(); //파이프
        int[] L = new int[p]; //길이
        int[] C = new int[p]; //용량
        for(int i = 0; i<p; i++){
            L[i] = sc.nextInt();
            C[i] = sc.nextInt();
        }
        sc.close();
        //dp[i] : 거리가 i일 때 최대 수도관 용량
        int[] dp = new int[d + 1];
        dp[0] = Integer.MAX_VALUE;

        for (int i = 0; i < p; i++) {
            int l = L[i];
            int c = C[i];
            for (int j = d; j >= l; j--) {
                if (dp[j - l] == 0) continue; //아직 도달하지 못한 거리
                dp[j] = Math.max(dp[j], Math.min(dp[j - l], c));
            }
        }

        System.out.println(dp[d]);
    }
}
