package bfs;

import java.util.LinkedList;
import java.util.Queue;

//5. 집을 짓자.
//board를 다 같이 쓰니까 복사해야한다. reach[][]도 있어야 함
public class P5 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] dist;
    static int[][] reach;

    static void BFS(int[][]board, int x, int y){
        int n = board.length;
        Queue<int[]> Q = new LinkedList<>();
        dist[x][y] = Integer.MAX_VALUE;//빌딩임
        int[][] map = new int[n][n];
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                map[i][j] = board[i][j];
            }
        }
        Q.offer(new int[]{x, y});
        int L = 0;
        while(!Q.isEmpty()){
            L++;
            int len = Q.size();
            for(int i = 0; i<len; i++){
                int[] p = Q.poll();
                for(int j = 0; j<4; j++){
                    int nx = p[0] + dx[j];
                    int ny = p[1] + dy[j];
                    if(nx>=0 && nx<n && ny>=0&& ny<n && map[nx][ny]==0){
                        map[nx][ny] = -1;
                        Q.offer(new int[]{nx, ny});
                        dist[nx][ny]+=L;
                        reach[nx][ny]++;
                    }
                }
            }
        }
    }

    public int solution(int[][] board){
        int answer = Integer.MAX_VALUE;
        int n = board.length;
        int cnt = 0;
        dist = new int[n][n];
        reach = new int[n][n];
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                if(board[i][j]==1){
                    BFS(board, i, j);
                    cnt++;
                }
                if(board[i][j]==2){
                    dist[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                if(reach[i][j]==cnt){
                    answer = Math.min(answer, dist[i][j]);
                }

            }
        }
        if(answer !=Integer.MAX_VALUE) return answer;
        return -1;
    }

    public static void main(String[] args){
        P5 T = new P5();
        System.out.println(T.solution(new int[][]{{1, 0, 2, 0, 1}, {0, 0, 0, 0, 0}, {0, 2, 1, 0, 0}, {2, 0, 0, 2, 2}, {0, 0, 0, 0, 0}}));
        System.out.println(T.solution(new int[][]{{1, 0, 0, 1}, {0, 0, 2, 0}, {0, 0, 1, 0}, {2, 2, 0, 0}}));
        System.out.println(T.solution(new int[][]{{1, 2, 0, 0}, {0, 0, 1, 2}, {0, 2, 0, 0}, {0, 2, 1, 0}}));
        System.out.println(T.solution(new int[][]{{1, 0, 0, 1}, {0, 0, 2, 0}, {0, 0, 1, 0}, {2, 2, 0, 1}}));
    }
}
