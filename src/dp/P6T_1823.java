package dp;

import java.util.Scanner;

public class P6T_1823 {

    static int solution(int n, int[] nums){
        int[][] dy = new int[n+1][n+1];
        int[] s = new int[n+1];
        s[1] = nums[1];
        for(int i = 2; i<= n; i++){
            s[i] = s[i-1]+nums[i];
        }
        for(int i = 1; i<=n; i++){
            dy[i][i] = nums[i];
        }
        for(int i = 1; i<n; i++){
            for(int j = 1; j<=n-i; j++){
                dy[j][j+i] = Math.max(dy[j+1][j+i], dy[j][j+i-1]) + (s[j+i] - s[j-1]);
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
