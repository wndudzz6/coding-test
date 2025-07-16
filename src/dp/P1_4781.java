package dp;

import java.util.Scanner;

//1. 사탕가게
//무한 냅색류 문제인 것은 눈치챘으나 가격이 double 형이라 인덱스를 어떻게 처리할지 고민함
public class P1_4781 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true){
            int n = sc.nextInt();
            int m = (int)Math.round(sc.nextDouble() * 100);
            int[] dp = new int[m+1];
            if(n==0 && m == 0.0) break;
            for(int i = 0; i<n; i++){
                int c = sc.nextInt();
                int p = (int)Math.round(sc.nextDouble()*100);
                for(int j = p; j<=m; j++){
                    dp[j] = Math.max(dp[j], dp[j-p]+c);
                }
            }
            System.out.println(dp[m]);
        }

    }
}
