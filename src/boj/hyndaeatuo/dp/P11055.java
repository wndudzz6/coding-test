package boj.hyndaeatuo.dp;

import java.util.Arrays;
import java.util.Scanner;

//가장 큰 증가하는 부분 수열
public class P11055 {

    static int solution(int n, int[] nums){
        int[] dp = new int[n]; //i에서 가장 큰 합 저장
        for(int i =0; i<n; i++){
            dp[i] = nums[i]; //초기화
        }
        for(int i = 1; i<n; i++){
            for(int j = i-1; j>=0; j--){
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i],dp[j] + nums[i]);
                }
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i<n; i++){
            nums[i] = sc.nextInt();
        }
        sc.close();
        System.out.println(solution(n, nums));
    }
}
