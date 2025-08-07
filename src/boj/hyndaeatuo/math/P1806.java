package boj.hyndaeatuo.math;

import java.util.Scanner;

public class P1806 {

    static int solution(int n, int s, int[] nums){
        int lt = 0, rt = 0;
        int sum = 0;
        int answer = Integer.MAX_VALUE;

        while(true){
            if(sum>=s){
                answer = Math.min(answer, rt-lt);
                sum-=nums[lt++];
            }else if(rt == n){
                break;
            }else{
                sum+=nums[rt++];
            }
        }
        return answer==Integer.MAX_VALUE ? 0 : answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s = sc.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i<n; i++){
            nums[i] = sc.nextInt();
        }
        sc.close();
        System.out.println(solution(n, s, nums));
    }
}
