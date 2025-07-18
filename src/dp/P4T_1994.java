package dp;

import java.util.Arrays;
import java.util.Scanner;

public class P4T_1994 {

    static int solution(int n, int[] nums){
        int answer = 0;
        if(n==1) return 1;
        int[][] dy = new int[n+1][n+1];
        Arrays.sort(nums);
        for(int i = 1; i<n ; i++){
            for(int j = i+1; j<=n; j++){
                dy[i][j] = 2; //최소 2는 있으니까
                int pre = 2*nums[i] - nums[j]; //i번째 숫자 - j번째 숫자 : 공차, 내가 찾는 것은 i의 앞 항
                int k; //앞부터
                for(k = i-1; k>=1; k--){
                    if(nums[k] == pre) break;
                }
                dy[i][j] = Math.max(dy[i][j], dy[k][i] + 1); //핵심 코드
                answer = Math.max(answer, dy[i][j]);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n+1];
        for(int i = 1; i<=n; i++) nums[i] = sc.nextInt();
        System.out.println(solution(n, nums));
    }
}
