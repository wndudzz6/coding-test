package boj.hyndaeatuo.sorting;

import java.util.Arrays;
import java.util.Scanner;

//안테나
public class P18310 {

    static int solution(int n, int[] home){
        Arrays.sort(home);
        int size = home.length;
        if(size%2 == 0){
            int mid = size/2-1;
            return home[mid];
        }
        int mid = size/2;
        return home[mid];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] home = new int[n];
        for(int i = 0; i<n; i++){
            home[i] = sc.nextInt();
        }
        sc.close();
        System.out.println(solution(n, home));
    }
}
