package boj.hyndaeatuo.graph.again;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

//다익스트라
public class P1261D {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int solution(int n, int m, int[][] board){
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[2]-b[2]);
        int[][] dist = new int[n][m];
        for(int[] d : dist) Arrays.fill(d, Integer.MAX_VALUE);
        pq.offer(new int[] {0, 0, 0});
        dist[0][0] = 0;

        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int x = cur[0], y = cur[1], cost = cur[2];

            if(x == n-1 && y == m-1) return cost;
            if(cost>dist[x][y]) continue;

            for(int i = 0; i<4; i++){
                int nx = x+dx[i];
                int ny = y+dy[i];

                if(nx>=0 && nx<n && ny>=0 &&ny<m){
                    if(board[nx][ny] == 1){
                        if(dist[nx][ny] > cost+1){
                            dist[nx][ny] = cost+1;
                            pq.offer(new int[] { nx, ny, cost+1});
                        }
                    }else{
                        if(dist[nx][ny] > cost){
                            dist[nx][ny] = cost;
                            pq.offer(new int[] { nx, ny, cost});
                        }
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
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
