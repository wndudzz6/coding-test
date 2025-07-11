package graph.again;

import java.util.Arrays;
import java.util.PriorityQueue;

public class BreakingWall {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    public int solution(int[][] board) {
        int n = board.length;
        int m = board[0].length;
        int[][] cost = new int[n][m];
        for(int i = 0; i<cost.length; i++) Arrays.fill(cost[i], Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[2]-b[2]);
        pq.offer(new int[]{0,0,0});
        cost[0][0] = 0;
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            //최적화 ~ 정석 다익스트라
            if (cur[2] > cost[cur[0]][cur[1]]) continue;
            for(int i = 0; i<4; i++){
                int nx = cur[0]+dx[i];
                int ny = cur[1]+dy[i];

                if(nx<0 || nx>= n || ny<0 || ny>= m) continue;
                //벽 안 뚫어도 될 때
                if(board[nx][ny] == 0 && cost[nx][ny] > cur[2]){
                    cost[nx][ny] = cur[2];
                    pq.offer(new int[]{nx, ny, cost[nx][ny]});
                }else if(board[nx][ny] == 1 && cost[nx][ny] > cur[2]+1){
                    cost[nx][ny] = cur[2]+1;
                    pq.offer(new int[] {nx, ny, cost[nx][ny]});
                }
            }
        }
        return cost[n-1][m-1];
    }

    public static void main(String[] args){
        BreakingWall T = new BreakingWall();
        System.out.println(T.solution(new int[][]{{0, 1, 1, 0}, {1, 0, 0, 1}, {0, 1, 0, 0}}));
        System.out.println(T.solution(new int[][]{{0, 1, 1, 0},{1, 1, 0, 1},{0, 0, 1, 0}, {0, 1, 1, 1}, {0, 1, 1, 0}}));
        System.out.println(T.solution(new int[][]{{0, 1, 1, 0, 1, 1},{0, 1, 1, 1, 1, 1},{1, 0, 0, 0, 1, 1}, {1, 1, 0, 1, 1, 1}, {1, 1, 0, 1, 1, 0}, {1, 0, 0, 1, 1, 1}, {1, 1, 1, 1, 1, 0}}));
        System.out.println(T.solution(new int[][]{{0, 1, 1, 0, 1, 1, 1}, {1, 1, 1, 0, 1, 1, 1}, {1, 0, 0, 0, 0, 1, 1}, {1, 1, 1, 0, 1, 1, 1}, {1, 1, 1, 0, 1, 1, 0}, {1, 0, 1, 0, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 0}}));
        System.out.println(T.solution(new int[][]{{0, 0, 1, 0, 1, 1, 1},{1, 1, 0, 0, 1, 1, 1},{1, 1, 0, 1, 0, 1, 1}, {0, 0, 1, 0, 1, 1, 1}, {1, 0, 1, 0, 1, 1, 0}, {1, 0, 1, 0, 1, 1, 1}, {1, 0, 0, 1, 1, 1, 1}, {1, 1, 0, 0, 1, 1, 1}, {1, 1, 0, 1, 1, 1, 0}}));
    }
}
