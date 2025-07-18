package graph;

import java.util.Arrays;
import java.util.PriorityQueue;

public class P5T {
    public int solution(int[][] board, int[] s, int[] e){
        int n = board.length;
        int m= board[0].length;
        int[][] cost = new int[n][m];
        for(int i = 0; i<n; i++) Arrays.fill(cost[i], Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)-> a[2]- b[2]);
        pq.offer(new int[]{s[0], s[1], 0});
        cost[s[0]][s[1]] = 0;
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            if(cur[2] > cost[cur[0]][cur[1]]) continue;
            //dx,dy 분리 필요없이 방향 벡터 자체를 한 번에 처리하고 싶을 때 자주 쓰는 방식
            for(int[] dir : new int[][] { {-1, 0}, {0, 1}, {1, 0}, {0, -1} }){
                int nx = cur[0];
                int ny = cur[1];
                int len = cur[2];
                while(nx>=0 && nx<n && ny>= 0 && ny<m && board[nx][ny] == 0){
                    nx += dir[0];
                    ny += dir[1];
                    len++;
                }
                nx -= dir[0];
                ny -= dir[1];
                len --;
                if(cost[nx][ny] > len){
                    cost[nx][ny] = len;
                    pq.offer(new int[] {nx, ny, len});
                }
            }
        }
        if(cost[e[0]][e[1]]== Integer.MAX_VALUE) return -1;
        else return cost[e[0]][e[1]];
    }
    public static void main(String[] args){
        P5T T = new P5T();
        System.out.println(T.solution(new int[][]{{0, 0, 1, 0, 0, 0}, {0, 0, 1, 0, 0, 0}, {0, 0, 0, 0, 1, 0}, {1, 0, 1, 1, 1, 0}, {1, 0, 0, 0, 0, 0}}, new int[]{1, 0}, new int[]{4, 5}));
        System.out.println(T.solution(new int[][]{{0, 0, 1, 0, 0, 0}, {0, 0, 1, 0, 0, 0}, {0, 0, 0, 0, 1, 0}, {1, 0, 1, 1, 1, 0}, {1, 0, 0, 0, 0, 0}}, new int[]{0, 0}, new int[]{4, 2}));
        System.out.println(T.solution(new int[][]{{1, 0, 1, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 1, 0}, {1, 1, 0, 1, 1}, {0, 0, 0, 0, 0}}, new int[]{0, 3}, new int[]{4, 2}));
        System.out.println(T.solution(new int[][]{{0, 1, 0, 1, 0, 0}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 0}, {0, 1, 1, 0, 1, 1}, {0, 0, 0, 0, 0, 0}}, new int[]{0, 0}, new int[]{4, 5}));
        System.out.println(T.solution(new int[][]{{0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0}, {0, 1, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 0, 0, 0}, {0, 0, 1, 0, 0, 0, 0, 0}}, new int[]{0, 0}, new int[]{4, 3}));
    }
}
