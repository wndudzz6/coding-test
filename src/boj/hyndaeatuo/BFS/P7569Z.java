package boj.hyndaeatuo.BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//문제 요구사항에 맞게 Z축까지도 고려하는 BFS
public class P7569Z {
    static int[] dx = {-1, 1, 0, 0, 0, 0};
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};
    static int n, m, h;
    static int[][][] box, dist;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        h = sc.nextInt();

        box = new int[h][n][m];
        dist = new int[h][n][m];
        Queue<int[]> Q = new LinkedList<>();

        for(int k = 0; k<h; k++){
            for(int i = 0; i<n; i++){
                for(int j = 0; j<m; j++){
                    box[k][i][j] = sc.nextInt();
                    if(box[k][i][j] == 1){
                        Q.offer(new int[] {k, i, j});
                    }
                }
            }
        }

        while(!Q.isEmpty()){
            int[] cur = Q.poll();
            int z = cur[0], x = cur[1], y = cur[2];
            for(int d = 0; d<6; d++){
                int nz = z+dz[d];
                int nx = x+dx[d];
                int ny = y+dy[d];

                if(nz>=0 && nz<h && nx>=0 && nx<n && ny>=0 && ny<m){
                    if(box[nz][nx][ny] == 0){
                        box[nz][nx][ny] = 1;
                        dist[nz][nx][ny] = dist[z][x][y]+1;
                        Q.offer(new int[] {nz, nx, ny});
                    }
                }
            }
        }
        int result = 0;
        for(int k = 0; k<h; k++){
            for(int i = 0; i<n; i++){
                for(int j = 0; j<m; j++){
                    if(box[k][i][j] == 0){
                        System.out.println(-1);
                        return;
                    }
                    result = Math.max(result, dist[k][i][j]);
                }
            }
        }
        System.out.println(result);
    }
}
