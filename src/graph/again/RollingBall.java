package graph.again;

import java.util.Arrays;
import java.util.PriorityQueue;

public class RollingBall {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    public int solution(int[][] board, int[] s, int[] e){
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[2]-b[2]);
        int n = board.length;
        int m = board[0].length;
        int[][] cost = new int[n][m];
        for(int i = 0; i<n; i++) Arrays.fill(cost[i], Integer.MAX_VALUE);
        cost[s[0]][s[1]] = 0;
        pq.offer(new int[]{s[0], s[1], 0});

        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            if(cur[2]>cost[cur[0]][cur[1]]) continue; //다익스트라 핵심 로직
            for(int i = 0; i<4; i++){
                // i가 방향
                int nx = cur[0];
                int ny = cur[1];
                int dis = cur[2];
                while(true){
                    nx+=dx[i];
                    ny+=dy[i];
                    if(nx<0 || nx>=n || ny<0 || ny>=m || board[nx][ny]==1){
                        nx-=dx[i];
                        ny-=dy[i];
                        if(cost[nx][ny]>dis) {
                            cost[nx][ny] = dis;
                            pq.offer(new int[]{nx, ny, dis});
                        }
                        break;
                    }
                    dis++;
                }
            }
        }

        return cost[e[0]][e[1]] == Integer.MAX_VALUE ? -1 : cost[e[0]][e[1]];
    }
    public static void main(String[] args){
        RollingBall T = new RollingBall();
        System.out.println(T.solution(new int[][]{{0, 0, 1, 0, 0, 0}, {0, 0, 1, 0, 0, 0}, {0, 0, 0, 0, 1, 0}, {1, 0, 1, 1, 1, 0}, {1, 0, 0, 0, 0, 0}}, new int[]{1, 0}, new int[]{4, 5}));
        System.out.println(T.solution(new int[][]{{0, 0, 1, 0, 0, 0}, {0, 0, 1, 0, 0, 0}, {0, 0, 0, 0, 1, 0}, {1, 0, 1, 1, 1, 0}, {1, 0, 0, 0, 0, 0}}, new int[]{0, 0}, new int[]{4, 2}));
        System.out.println(T.solution(new int[][]{{1, 0, 1, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 1, 0}, {1, 1, 0, 1, 1}, {0, 0, 0, 0, 0}}, new int[]{0, 3}, new int[]{4, 2}));
        System.out.println(T.solution(new int[][]{{0, 1, 0, 1, 0, 0}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 0}, {0, 1, 1, 0, 1, 1}, {0, 0, 0, 0, 0, 0}}, new int[]{0, 0}, new int[]{4, 5}));
        System.out.println(T.solution(new int[][]{{0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0}, {0, 1, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 0, 0, 0}, {0, 0, 1, 0, 0, 0, 0, 0}}, new int[]{0, 0}, new int[]{4, 3}));
    }
}
