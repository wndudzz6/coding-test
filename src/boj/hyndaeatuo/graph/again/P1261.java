package boj.hyndaeatuo.graph.again;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class P1261 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int solution(int n, int m, int[][] board){
        Deque<int[]> dq = new ArrayDeque<>();
        int[][] cost = new int[n][m];
        dq.offerFirst(new int[]{0,0});
        for(int[]c : cost) Arrays.fill(c, Integer.MAX_VALUE);
        cost[0][0] = 0;

        while(!dq.isEmpty()){
            int[] cur = dq.pollFirst();
            int x = cur[0], y = cur[1];
            int ct = cost[x][y];

            if(x==n-1 && y==m-1) return ct;
            for(int i = 0; i<4; i++){
                int nx = x+dx[i];
                int ny = y+dy[i];

                if(nx>=0 && nx<n && ny>=0 && ny<m){
                    if(board[nx][ny] == 1){
                        if(cost[nx][ny] >ct+1){
                            cost[nx][ny] = ct+1;
                            dq.offerLast(new int[]{nx, ny});
                        }

                    }else{
                        if(cost[nx][ny] > ct){
                            cost[nx][ny] = ct;
                            dq.offerFirst(new int[]{nx, ny});
                        }
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] board = new int[n][m];

        sc.nextLine();
        for(int i = 0; i<n; i++){
            String x = sc.nextLine();
            for(int j = 0; j<m; j++){
                board[i][j] = x.charAt(j)-'0';
            }
        }
        sc.close();
        System.out.println(solution(n, m, board));
    }
}
