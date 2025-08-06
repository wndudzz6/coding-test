package boj.hyndaeatuo.BFS;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

//알고스팟 01BFS
public class P1261 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int solution(int n, int m, int[][] board){
        Deque<int[]> dq = new ArrayDeque<>();
        int[][] dist = new int[n][m];
        for(int[] x : dist) Arrays.fill(x, Integer.MAX_VALUE);
        dq.offerFirst(new int[]{0,0});
        dist[0][0] = 0;

        while(!dq.isEmpty()){
            int[] cur = dq.pollFirst();
            int x = cur[0]; int y = cur[1];
            int cost = dist[x][y];
            if(x==n-1 && y==m-1) return cost;
            for(int i = 0; i<4; i++){
                int nx = x+dx[i];
                int ny = y+dy[i];
                if(nx>=0 && nx<n && ny>=0 && ny<m){
                    if(board[nx][ny] == 1){
                        if(dist[nx][ny] > cost+1){
                            dist[nx][ny] = cost+1;
                            dq.offerLast(new int[]{nx, ny});
                        }
                    }else{
                        if(dist[nx][ny] > cost){
                            dist[nx][ny] = cost;
                            dq.offerFirst(new int[]{nx,ny});
                        }
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();//가로
        int n = sc.nextInt();//세로
        sc.nextLine();
        int[][] board = new int[n][m];
        for(int i = 0; i<n; i++){
            String x = sc.nextLine();
            for(int j = 0; j<m; j++){
                board[i][j] = x.charAt(j)-'0';
            }
        }
        System.out.println(solution(n, m, board));
    }

}
