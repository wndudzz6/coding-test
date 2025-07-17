package dp;

import java.util.Scanner;

public class P3T_2579 {
    static int solution(int n, int[] score){
        int[] dy = new int[n+1];
        dy[1] = score[1];
        if(n>1) dy[2] = score[1]+score[2];
        for(int i = 3; i<=n; i++){
            dy[i] = Math.max(dy[i-2]+score[i], dy[i-3]+score[i]+score[i-1]);
        }
        return dy[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] score = new int[n+1];
        for(int i = 1; i<=n; i++) score[i] = sc.nextInt();
        System.out.println(solution(n, score));

    }
}
