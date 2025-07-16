package dp;

import java.util.Scanner;

//2. 수도배관공사
public class P2_2073 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int D = sc.nextInt(); //거리
        int P = sc.nextInt(); //파이프
        int[] L = new int[P]; //길이
        int[] C = new int[P]; //용량
        for(int i = 0; i<P; i++){
            L[i] = sc.nextInt();
            C[i] = sc.nextInt();
        }
        sc.close();
        //dp[i] : 거리가 i일 때 최대 수도관 용량
        int[] dp = new int[D+1];
        for(int i = 0; i<P; i++){
            for(int j = D; j>=L[i]; j--){
                dp[j] = Math.max(dp[j], dp[j-L[i]]);
            }
        }

        System.out.println(dp[D]);
    }
}
