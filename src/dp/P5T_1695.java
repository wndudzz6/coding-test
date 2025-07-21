package dp;

import java.util.Scanner;

//구간 기반 DP
public class P5T_1695 {

    static int solution(int n, int[] nums){
        int[][] dy = new int[n+1][n+1];
        for(int i = 1; i< n; i++){
            for(int j = 1; j<=n-i; j++){
                if(nums[j] == nums[j+i]) dy[j][j+i] = dy[j+1][j+i-1];
                else dy[j][j+i] = Math.min(dy[j+1][j+i], dy[j][j+i-1])+1;
            }
        }
        return dy[1][n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n+1];
        for(int i = 1; i<=n; i++){
            nums[i] = sc.nextInt();
        }
        System.out.println(solution(n, nums));
    }
}
