package boj.hyndaeatuo.simulation.again;

import java.util.Scanner;

public class P14503 {
    static int n, m;
    static int[][] board;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int solution(int[] s, int d){
       int answer =0;
       int x = s[0], y = s[1];

        while(true){
           if(board[x][y] == 0){
               board[x][y] = -1;
               answer++;
           }

           boolean flag = true;
           for(int i = 0; i<4; i++){
               d = (d+3)%4;
               int nx = x+dx[d];
               int ny = y+dy[d];

               if(nx>=0 && nx<n && ny>=0 && ny<m){
                   if(board[nx][ny] == 0){
                       flag = false;
                       x = nx;
                       y = ny;
                       break;
                   }
               }
           }

           //현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우
           if(flag){
               int bx = x-dx[d];
               int by = y-dy[d];
               if(bx<0 || bx>=n || by<0 || by>=m || board[bx][by] == 1){
                   break;
               }

               x = bx;
               y = by;
           }
       }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        board = new int[n][m];
        int[] s = new int[2];
        s[0] = sc.nextInt();
        s[1] = sc.nextInt();
        int d = sc.nextInt();

        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                board[i][j] = sc.nextInt();
            }
        }
        sc.close();

        System.out.println(solution(s, d));
    }
}
