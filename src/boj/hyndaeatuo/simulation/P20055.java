package boj.hyndaeatuo.simulation;

import java.util.Scanner;

//컨베이어 벨트 위의 로봇
public class P20055 {
    //단계 출력
    static int solution(int n, int k, int[] arr){
        int answer = 0;
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i<2*n; i++){
            arr[i] = sc.nextInt();
        }
        sc.close();
        System.out.println(solution(n, k, arr));
    }
}
