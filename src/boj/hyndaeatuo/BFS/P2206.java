package boj.hyndaeatuo.BFS;

import java.util.*;

//벽 허물고 이동하기
//벽을 최대 한번만 부술 수 있고 최단경로 찾기
//가중치1 + 상태추가 -> 일반 BFS
public class P2206 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int solution(int n, int m, int[][] board) {
        Queue<int[]> q = new ArrayDeque<>();
        int[][][] dist = new int[n][m][2]; // [x][y][벽 부숨 여부]
        for (int[][] arr : dist) for (int[] a : arr) Arrays.fill(a, -1);

        q.offer(new int[]{0, 0, 0}); // x, y, broken 여부
        dist[0][0][0] = 1;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1], broken = cur[2];

            if (x == n - 1 && y == m - 1) return dist[x][y][broken];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    // 빈 칸
                    if (board[nx][ny] == 0 && dist[nx][ny][broken] == -1) {
                        dist[nx][ny][broken] = dist[x][y][broken] + 1;
                        q.offer(new int[]{nx, ny, broken});
                    }
                    // 벽 & 아직 안 부숨
                    if (board[nx][ny] == 1 && broken == 0 && dist[nx][ny][1] == -1) {
                        dist[nx][ny][1] = dist[x][y][broken] + 1;
                        q.offer(new int[]{nx, ny, 1});
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
        sc.nextLine();
        int[][] board = new int[n][m];
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
