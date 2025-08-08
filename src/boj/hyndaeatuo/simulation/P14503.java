package boj.hyndaeatuo.simulation;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//로봇청소기
public class P14503 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int n, m, d;
    static int[][] board;

    static int solution(int[] s) {
        int x = s[0];
        int y = s[1];
        int cnt = 0;
        while (true) {

            //현재 칸 청소
            if (board[x][y] == 0) {
                board[x][y] = -1;
                cnt++;
            }

            boolean moved = false;
            for (int i = 0; i < 4; i++) {
                d = (d + 3) % 4;
                int nx = x + dx[d];
                int ny = y + dy[d];
                if (0 <= nx && nx < n && 0 <= ny && ny < m && board[nx][ny] == 0) {
                    //전진
                    x = nx;
                    y = ny;
                    moved = true;
                    break;
                }
            }
            if (moved) continue;

            int bx = x - dx[d];
            int by = y - dy[d];
            if (bx < 0 || bx >= n || by < 0 || by >= m || board[bx][by] == 1) {
                break;
            } else {
                x = bx;
                y = by;
            }
        }return cnt;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int[] s = new int[2];
        s[0] = sc.nextInt();
        s[1] = sc.nextInt();
        d = sc.nextInt();

        board = new int[n][m];
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                board[i][j] = sc.nextInt();
            }
        }sc.close();

        System.out.println(solution(s));
    }


}
