package dp;

import java.util.Arrays;
import java.util.Scanner;

//5. 팰린드롬 만들기
public class P5_1695 {

    static int solution(int n, int[] arr){
        if(n==1) return 0;
        int[][] dp = new int[n][n]; //1based로 쓴다.
        for(int i = 0; i<=n; i++){
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        for(int i = 1; i<=n; i++){
            dp[i][i] = 0; //초기화
        }
        for(int i = 1; i<n; i++){
            if(arr[i] == arr[i+1]){
                dp[i][i+1] = 0;
            }else{
                dp[i][i+1] = 1;
            }
        }
        for(int i = 1; i<n; i++){
            for(int j = i+1; j<=n; j++){
                if(arr[i] == arr[j]){
                    dp[i][j] = Math.min(dp[i][j],dp[i+1][j-1]);
                }else{
                    dp[i][j] = Math.min(dp[i+1][j]+1, dp[i][j-1]+1);
                }
            }
        }

        return dp[1][n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt()+1;
        int[] arr = new int[n];
        for(int i = 1; i<=n; i++){
            arr[i] = sc.nextInt();
        }
        sc.close();
        System.out.println(solution(n, arr));
    }
}
