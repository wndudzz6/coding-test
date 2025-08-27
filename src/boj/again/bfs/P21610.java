package boj.again.bfs;

import java.util.Scanner;

public class P21610 {

    static int solution(int n, int m, int[][] board, int[][] command){
        int answer = 0;
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] board = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        int[][] command = new int[m][2];
        for(int i = 0; i < m; i++) {
            command[i][0] = sc.nextInt();
            command[i][1] = sc.nextInt();
        }
        sc.close();

        System.out.println(solution(n, m, board, command));

    }
}
