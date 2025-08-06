package boj.hyndaeatuo.sorting;

import java.util.Arrays;
import java.util.Scanner;

public class P10989 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] cnt = new int[10001];
        for(int i = 0; i<n; i++){
            cnt[sc.nextInt()]++;
        }
        sc.close();

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i<10001; i++){
            while(cnt[i]>0){
                sb.append(i).append("\n");
                cnt[i]--;
            }
        }
        System.out.println(sb);
    }
}
