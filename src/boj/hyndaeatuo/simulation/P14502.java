package boj.hyndaeatuo.simulation;

import java.util.Scanner;

//연구소. 접근법이 별로 안 떠오른다.
public class P14502 {

    static int solution(int n, int m, int[][] board){
        int answer = 0;
        int cnt = 3;
        while(cnt>0){

        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] board = new int[n][m];
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                board[i][j] = sc.nextInt();
            }
        }sc.close();
        System.out.println(solution(n, m, board));
    }
}
