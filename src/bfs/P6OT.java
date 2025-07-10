package bfs;

import java.util.LinkedList;
import java.util.Queue;

//BFS분리하면서 2번만 쓰는 방식 (딸기 / 기사)
public class P6OT {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    // BFS 함수 분리
    public int[][] BFS(int[] start, int[][] board) {
        int r = board.length;
        int c = board[0].length;
        int[][] dist = new int[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                dist[i][j] = -1; // 방문하지 않은 곳
            }
        }

        Queue<int[]> Q = new LinkedList<>();
        Q.offer(start);
        dist[start[0]][start[1]] = 0;

        while (!Q.isEmpty()) {
            int[] cur = Q.poll();
            for (int k = 0; k < 4; k++) {
                int nx = cur[0] + dx[k];
                int ny = cur[1] + dy[k];
                if (nx >= 0 && nx < r && ny >= 0 && ny < c) {
                    if (board[nx][ny] != 1 && dist[nx][ny] == -1) {
                        dist[nx][ny] = dist[cur[0]][cur[1]] + 1;
                        Q.offer(new int[]{nx, ny});
                    }
                }
            }
        }

        return dist;
    }

    // 메인 솔루션
    public int solution(int[][] board) {
        int r = board.length;
        int c = board[0].length;
        int[] start = new int[2];
        int[] knight = new int[2];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (board[i][j] == 2) {
                    start = new int[]{i, j};
                } else if (board[i][j] == 3) {
                    knight = new int[]{i, j};
                }
            }
        }

        int[][] distFrom2 = BFS(start, board);
        int[][] distFrom3 = BFS(knight, board);

        int answer = Integer.MAX_VALUE;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (board[i][j] == 4 &&
                        distFrom2[i][j] != -1 &&
                        distFrom3[i][j] != -1) {

                    int total = distFrom2[i][j] + distFrom3[i][j];
                    answer = Math.min(answer, total);
                }
            }
        }

        return (answer == Integer.MAX_VALUE) ? -1 : answer;
    }

    public static void main(String[] args) {
        P6OT T = new P6OT();
        System.out.println(T.solution(new int[][]{
                {4, 1, 0, 0, 0, 0, 1, 0},
                {0, 0, 0, 1, 0, 1, 0, 0},
                {0, 2, 1, 1, 3, 0, 4, 0},
                {0, 0, 0, 4, 1, 1, 1, 0}
        }));

        System.out.println(T.solution(new int[][]{
                {3, 0, 0, 0, 1, 4, 4, 4},
                {0, 1, 1, 0, 0, 0, 1, 0},
                {0, 1, 4, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0},
                {1, 0, 1, 0, 0, 1, 1, 0},
                {4, 0, 0, 0, 1, 0, 0, 0},
                {4, 1, 0, 0, 1, 0, 0, 0},
                {4, 0, 0, 0, 0, 0, 1, 2}
        }));

        System.out.println(T.solution(new int[][]{
                {4, 1, 0, 1, 0},
                {0, 1, 0, 1, 0},
                {0, 0, 2, 3, 4},
                {0, 1, 0, 1, 0}
        }));
    }
}
