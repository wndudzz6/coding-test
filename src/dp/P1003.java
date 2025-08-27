package dp;

import java.util.Scanner;

//피보나치 함수
public class P1003 {
    static int[][] dp;



    static void solution(int n){
        dp = new int[41][2]; //i0 i1 i일 때 0호출 횟수, 1호출 횟수
        dp[0][0] = 1; //n=0일 때 0 호출 횟수
        dp[0][1] = 0; //n=0일 때 1 호출 횟수
        dp[1][0] = 0;
        dp[1][1] = 1;


        for(int i = 2; i<41; i++){
            dp[i][0] = dp[i-1][0]+dp[i-2][0];
            dp[i][1] = dp[i-1][1]+dp[i-2][1];
        }

        System.out.println(dp[n][0]+" "+dp[n][1]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i = 0; i<T; i++){
            int n = sc.nextInt();
            solution(n);
        }
        sc.close();
    }
}
