package dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//4. 등차수열
//Map DP
public class P4_1994 {

    static int solution(int n, long[] nums){
        Arrays.sort(nums); //log n
        @SuppressWarnings("unchecked")
        Map<Long, Integer>[] dp = new HashMap[n]; //공차를 Map으로 관리
        for(int i = 0; i<n; i++) dp[i] = new HashMap<>();

        int answer = 1;

        for(int i = 0; i<n; i++){
            for(int j = 0; j<i; j++){
                long d = nums[i] - nums[j];

                int prevLen = dp[j].getOrDefault(d, 1);
                int currLen = prevLen+1;

                dp[i].put(d, Math.max(dp[i].getOrDefault(d, 0), currLen));
                answer = Math.max(answer, currLen);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] nums = new long[n];
        for(int i = 0; i<n; i++){
            nums[i] = sc.nextLong();
        }
        sc.close();
        System.out.println(solution(n, nums));
    }
}
