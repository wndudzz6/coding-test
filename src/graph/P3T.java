package graph;

import java.util.Arrays;
import java.util.PriorityQueue;

//다익스트라. 3. 벽허물기
public class P3T {
    public int solution(int[][] board) {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int n = board.length;
        int m = board[0].length;
        int[][] cost = new int[n][m];
        for(int i = 0; i<n; i++){
            Arrays.fill(cost[i], Integer.MAX_VALUE);
        }
        cost[0][0] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> a[2]-b[2]); // 금액 기준 오름차
        pq.add(new int[]{0,0,0});
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            if(cur[2] > cost[cur[0]][cur[1]]) continue;
            for(int k = 0; k<4; k++){
                int nx = cur[0]+dx[k];
                int ny = cur[1]+dy[k];
                if(nx<0 || nx>=n || ny<0 || ny>=m) continue;
                //다익스트라에서는 같은 좌표여도 더 적은 비용으로 다시 방문할 수 있다면 갱신해야하므로
                //굳이 온 길을 체크하지 않는다.
                if(board[nx][ny]==0 && cost[nx][ny] > cur[2]){
                    cost[nx][ny] = cur[2];
                    pq.offer(new int[]{nx,ny,cur[2]});
                }else if(board[nx][ny] ==1 && cost[nx][ny] > cur[2]+1){
                    cost[nx][ny] = cur[2]+1;
                    pq.offer(new int[]{nx,ny,cost[nx][ny]});
                }
            }
        }
        return cost[n-1][m-1];
    }

    public static void main(String[] args){
        P3T T = new P3T();
        System.out.println(T.solution(new int[][]{{0, 1, 1, 0}, {1, 0, 0, 1}, {0, 1, 0, 0}}));
        System.out.println(T.solution(new int[][]{{0, 1, 1, 0},{1, 1, 0, 1},{0, 0, 1, 0}, {0, 1, 1, 1}, {0, 1, 1, 0}}));
        System.out.println(T.solution(new int[][]{{0, 1, 1, 0, 1, 1},{0, 1, 1, 1, 1, 1},{1, 0, 0, 0, 1, 1}, {1, 1, 0, 1, 1, 1}, {1, 1, 0, 1, 1, 0}, {1, 0, 0, 1, 1, 1}, {1, 1, 1, 1, 1, 0}}));
        System.out.println(T.solution(new int[][]{{0, 1, 1, 0, 1, 1, 1}, {1, 1, 1, 0, 1, 1, 1}, {1, 0, 0, 0, 0, 1, 1}, {1, 1, 1, 0, 1, 1, 1}, {1, 1, 1, 0, 1, 1, 0}, {1, 0, 1, 0, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 0}}));
        System.out.println(T.solution(new int[][]{{0, 0, 1, 0, 1, 1, 1},{1, 1, 0, 0, 1, 1, 1},{1, 1, 0, 1, 0, 1, 1}, {0, 0, 1, 0, 1, 1, 1}, {1, 0, 1, 0, 1, 1, 0}, {1, 0, 1, 0, 1, 1, 1}, {1, 0, 0, 1, 1, 1, 1}, {1, 1, 0, 0, 1, 1, 1}, {1, 1, 0, 1, 1, 1, 0}}));
    }
}
