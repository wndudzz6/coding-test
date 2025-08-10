package boj.hyndaeatuo.greedy;

import java.util.Scanner;

//멀티탭 스케줄링
public class P1700 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //멀티탭 구멍 개수
        int k = sc.nextInt(); //전기용품 사용 횟수
        int[] freq = new int[k+1];
        int[] order = new int[k];

        for(int i = 0; i<k; i++){
            int a = sc.nextInt();
            order[i] = a;
            freq[a]++;
        }
        sc.close();
    }
}
