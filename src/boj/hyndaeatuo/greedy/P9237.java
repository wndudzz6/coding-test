package boj.hyndaeatuo.greedy;

import java.util.Arrays;
import java.util.Scanner;

//이장님 초대
public class P9237 {

    static int solution(int n, int[] days){
        int answer = 0;
        Arrays.sort(days);
        int[] rdays = new int[n];
        for(int i = 0; i<n; i++){
            rdays[i] = days[n-1-i];
        }
        int day = 1;
        for(int i = 0; i<n; i++){
            answer = Math.max(answer, day+rdays[i]+1);
            day++;
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] days = new int[n];
        for(int i = 0; i<n; i++){
            days[i] = sc.nextInt();
        }
        sc.close();
        System.out.println(solution(n, days));
    }
}
