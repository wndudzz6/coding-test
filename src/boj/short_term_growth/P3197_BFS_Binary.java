package boj.short_term_growth;

import java.util.*;

public class P3197_BFS_Binary {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int r, c;
    static char[][] board;
    static int[][] dist;
    static int[] swan1, swan2;
    static Queue<int[]> waterQ = new LinkedList<>();

    // 얼음이 언제 녹는지 계산 (dist 배열 완성)
    static void meltIceBFS() {
        Queue<int[]> q = new LinkedList<>(waterQ);

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (nx < 0 || ny < 0 || nx >= r || ny >= c) continue;
                if (dist[nx][ny] != Integer.MAX_VALUE) continue;
                if (board[nx][ny] == 'X') {
                    dist[nx][ny] = dist[x][y] + 1;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
    }

    // 주어진 날짜 day까지 백조가 만날 수 있는가?
    static boolean meetable(int day) {
        boolean[][] visited = new boolean[r][c];
        Queue<int[]> q = new LinkedList<>();
        q.offer(swan1);
        visited[swan1[0]][swan1[1]] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];

            if (x == swan2[0] && y == swan2[1]) return true;

            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                if (nx < 0 || ny < 0 || nx >= r || ny >= c) continue;
                if (visited[nx][ny]) continue;
                if (dist[nx][ny] <= day) {
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx, ny});
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        r = sc.nextInt();
        c = sc.nextInt();
        board = new char[r][c];
        dist = new int[r][c];

        boolean firstSwan = true;

        for (int i = 0; i < r; i++) {
            String s = sc.next();
            for (int j = 0; j < c; j++) {
                board[i][j] = s.charAt(j);
                if (board[i][j] == 'L') {
                    if (firstSwan) {
                        swan1 = new int[]{i, j};
                        firstSwan = false;
                    } else {
                        swan2 = new int[]{i, j};
                    }
                    waterQ.offer(new int[]{i, j});
                    dist[i][j] = 0;
                } else if (board[i][j] == '.') {
                    waterQ.offer(new int[]{i, j});
                    dist[i][j] = 0;
                } else {
                    dist[i][j] = Integer.MAX_VALUE; // X는 아직 안 녹음
                }
            }
        }

        meltIceBFS(); // 얼음 언제 녹는지 계산

        // 이분 탐색으로 최소 날짜 구하기
        int left = 0, right = 0;
        for (int[] row : dist)
            for (int d : row)
                right = Math.max(right, d);

        int answer = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (meetable(mid)) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(answer);
    }
}
