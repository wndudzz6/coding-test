package boj.hyndaeatuo.graph.lecture;

import java.util.Arrays;
import java.util.PriorityQueue;

public class BreakingWall {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public int solution(int[][] board) {
        int n = board.length;
        int m = board[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        int[][] ch = new int[n][m];
        for(int i = 0; i<n; i++){
            for(int j= 0; j<m; j++){
                ch[i][j] = Integer.MAX_VALUE;
            }
        }
        ch[0][0] = 0;
        pq.offer(new int[] {0,0,0});
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int x = cur[0];
            int y = cur[1];
            int cost = cur[2];
            if(x == n-1 && y==m-1) return cost;
            if(cost>ch[x][y]) continue;
            for(int i = 0; i<4; i++){
                int nx = x+dx[i];
                int ny = y+dy[i];
                if(nx>=0 && nx<n && ny>=0 && ny<m){
                    if(board[nx][ny] == 1 && ch[nx][ny] > cost+1){
                        ch[nx][ny] = cost+1;
                        pq.offer(new int[]{nx,ny,cost+1});
                    }else if(board[nx][ny] == 0 && ch[nx][ny]>cost){
                        ch[nx][ny] = cost;
                        pq.offer(new int[]{nx,ny,cost});
                    }
                }
            }
        }

        return Integer.MAX_VALUE;
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
