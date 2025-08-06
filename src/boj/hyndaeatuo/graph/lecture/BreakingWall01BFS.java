package boj.hyndaeatuo.graph.lecture;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

//가중치가 0또는 1일 떄는 01BFS방식(양방향 큐로 우선순위를 정렬할 필요없이 왼쪽/오른쪽 나눠서 넣기)
//가중치가 0일 때에는 먼저 나오도록 offerFirst, 1일 떄는 늦게 나오도록 OfferLast하면 된다
public class BreakingWall01BFS {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    int solution(int[][] board){
        int n = board.length;
        int m = board[0].length;
        int[][] dist = new int[n][m];
        for(int[] row : dist) Arrays.fill(row, Integer.MAX_VALUE);

        Deque<int[]> dq = new ArrayDeque<>();
        dq.offer(new int[]{0,0});
        dist[0][0] = 0;

        while(!dq.isEmpty()){
            int[] cur = dq.pollFirst();
            int x = cur[0]; int y = cur[1];
            for(int i = 0; i<4; i++){
                int nx = x+dx[i];
                int ny = y+dy[i];
                if(nx>=0 && nx<n && ny>=0 & ny<m){
                    int cost = dist[x][y] + board[nx][ny];
                    if(cost < dist[nx][ny]){
                        dist[nx][ny] = cost;
                        if(board[nx][ny] == 1 ) dq.offerLast(new int[]{nx, ny});
                        else dq.offerFirst(new int[]{nx, ny});
                    }

                }
            }

        }return dist[n-1][m-1];
    }

    public static void main(String[] args){
        BreakingWall01BFS T = new BreakingWall01BFS();
        System.out.println(T.solution(new int[][]{{0, 1, 1, 0}, {1, 0, 0, 1}, {0, 1, 0, 0}}));
        System.out.println(T.solution(new int[][]{{0, 1, 1, 0},{1, 1, 0, 1},{0, 0, 1, 0}, {0, 1, 1, 1}, {0, 1, 1, 0}}));
        System.out.println(T.solution(new int[][]{{0, 1, 1, 0, 1, 1},{0, 1, 1, 1, 1, 1},{1, 0, 0, 0, 1, 1}, {1, 1, 0, 1, 1, 1}, {1, 1, 0, 1, 1, 0}, {1, 0, 0, 1, 1, 1}, {1, 1, 1, 1, 1, 0}}));
        System.out.println(T.solution(new int[][]{{0, 1, 1, 0, 1, 1, 1}, {1, 1, 1, 0, 1, 1, 1}, {1, 0, 0, 0, 0, 1, 1}, {1, 1, 1, 0, 1, 1, 1}, {1, 1, 1, 0, 1, 1, 0}, {1, 0, 1, 0, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 0}}));
        System.out.println(T.solution(new int[][]{{0, 0, 1, 0, 1, 1, 1},{1, 1, 0, 0, 1, 1, 1},{1, 1, 0, 1, 0, 1, 1}, {0, 0, 1, 0, 1, 1, 1}, {1, 0, 1, 0, 1, 1, 0}, {1, 0, 1, 0, 1, 1, 1}, {1, 0, 0, 1, 1, 1, 1}, {1, 1, 0, 0, 1, 1, 1}, {1, 1, 0, 1, 1, 1, 0}}));
    }
}
