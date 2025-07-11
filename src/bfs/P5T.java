package bfs;

import java.util.LinkedList;
import java.util.Queue;

public class P5T {
    public int solution(int[][] board){
        int answer = 0;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int n = board.length;
        int[][] dist = new int[n][n];
        Queue<int[]> Q = new LinkedList<>();
        int emptyLand = 0;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                if(board[i][j] == 1){
                    answer = Integer.MAX_VALUE;
                    Q.offer(new int[]{i,j});
                    int L = 0;
                    while(!Q.isEmpty()){
                        L++;
                        int len = Q.size();
                        for(int r = 0; r<len; r++){
                            int[] cur = Q.poll();
                            for(int c = 0; c<4; c++){
                                int nx = cur[0]+dx[c];
                                int ny = cur[1]+dy[c];
                                if(nx >= 0 && nx<n && ny>=0 && ny<n && board[nx][ny] == emptyLand){
                                    board[nx][ny]--;
                                    dist[nx][ny]+=L;
                                    Q.offer(new int[]{nx,ny});
                                    answer= Math.min(answer,dist[nx][ny]);
                                }
                            }
                        }
                    }
                    emptyLand--;
                }
            }
        }


        return answer == Integer.MAX_VALUE ? -1 : answer;
    }

    public static void main(String[] args){
        P5T T = new P5T();
        System.out.println(T.solution(new int[][]{{1, 0, 2, 0, 1}, {0, 0, 0, 0, 0}, {0, 2, 1, 0, 0}, {2, 0, 0, 2, 2}, {0, 0, 0, 0, 0}}));
        System.out.println(T.solution(new int[][]{{1, 0, 0, 1}, {0, 0, 2, 0}, {0, 0, 1, 0}, {2, 2, 0, 0}}));
        System.out.println(T.solution(new int[][]{{1, 2, 0, 0}, {0, 0, 1, 2}, {0, 2, 0, 0}, {0, 2, 1, 0}}));
        System.out.println(T.solution(new int[][]{{1, 0, 0, 1}, {0, 0, 2, 0}, {0, 0, 1, 0}, {2, 2, 0, 1}}));
    }
}
