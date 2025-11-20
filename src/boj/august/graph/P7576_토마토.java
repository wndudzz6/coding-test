package boj.august.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P7576_토마토 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] board, dist;
    static int n,m;

    static void BFS(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {x,y});

        int L = 1;
        while(!q.isEmpty()){
            int[] cur = q.poll();

            for(int d = 0; d<4; d++){
                int nx = cur[0]+dx[d];
                int ny = cur[1]+dy[d];

                if(nx>=0 && nx<n && ny>=0 && ny<m){
                    if(dist[nx][ny] > L && board[nx][ny] == 0){
                        dist[nx][ny] = L;
                        board[nx][ny] = 1;
                        q.offer(new int[] {nx, ny});
                    }
                }
            }L++;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt(); //가로
        n = sc.nextInt(); //세로

        board = new int[n][m];
        dist = new int[n][m];
        for(int[] x : dist) Arrays.fill(x, Integer.MAX_VALUE);
        boolean flag = true;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                int x = sc.nextInt();
                board[i][j] = x;

                if(x == 1){
                    dist[i][j] = 0;
                    BFS(i,j);
                }

                if(x == 0){
                    flag = false; //처음부터 다 익지x
                }
            }
        }
        int answer = Integer.MIN_VALUE;
        if(flag) {
            System.out.println(0);
            return;
        }else{
            for(int i = 0; i<n; i++){
                for(int j = 0; j<m; j++){
                    if(board[i][j] == 0){
                        System.out.println("-1");
                        return;
                    }

                    if(dist[i][j]!=Integer.MAX_VALUE && dist[i][j] > answer){
                        answer = dist[i][j];
                    }
                }
            }

        }
        System.out.println(answer);
    }
}
