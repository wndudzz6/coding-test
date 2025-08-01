package boj.hyndaeatuo.dp;

import java.util.Arrays;
import java.util.Scanner;

public class P11053 {

    static int solution(int n, int[] arr){
        int[] dp = new int[n]; //i를 골랐을 때 최대 길이
        Arrays.fill(dp,1);
        for(int i = 1; i<n; i++){
            for(int j = i-1; j>=0; j--){
                if(arr[i]>arr[j]){
                    dp[i] = Math.max(dp[j]+1,dp[i]);
                }
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        sc.close();
        System.out.println(solution(n, arr));
    }
}
