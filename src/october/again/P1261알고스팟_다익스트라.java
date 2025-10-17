package october.again;

import java.util.*;

public class P1261알고스팟_다익스트라{
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int n, m;
    static int[][] board, dist;

    static int solution(){
        for(int[] x : dist) Arrays.fill(x, Integer.MAX_VALUE);
        Queue<int[]> Q = new LinkedList<>();
        dist[0][0] = 0;
        Q.offer(new int[]{0,0});
        while(!Q.isEmpty()){
            int[] cur = Q.poll();
            int x = cur[0]; int y = cur[1];
            for(int d = 0; d<4; d++){
                int nx = x+dx[d];
                int ny = y+dy[d];
                if(nx >= 0 && nx<n && ny>=0 && ny<m){
                    int cost = dist[x][y] + board[nx][ny];
                    if(dist[nx][ny] > cost){
                        dist[nx][ny] = cost;
                        Q.offer(new int[] {nx, ny});
                    }
                }
            }

        }
        return dist[n-1][m-1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        sc.nextLine();
        board = new int[n][m];
        dist = new int[n][m];

        for(int i = 0; i<n; i++){
            String line = sc.nextLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = line.charAt(j) - '0';
            }
        }

        System.out.println(solution());
    }
}
