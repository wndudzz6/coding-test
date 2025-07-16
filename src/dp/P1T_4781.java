package dp;

import java.util.Scanner;

public class P1T_4781 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true){
            int n = sc.nextInt();
            int m = (int)Math.round(sc.nextDouble() * 100);
            if(n ==0 && m == 0) break;
            int[] dp = new int[m+1];
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
