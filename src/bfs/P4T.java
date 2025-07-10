package bfs;

import java.util.LinkedList;
import java.util.Queue;

public class P4T {
    public int solution(int[][] board){
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        Queue<int[]> Q= new LinkedList<>();
        int[][] dist = new int[7][7];
        Q.offer(new int[]{0,0});
        int L = 0;
        while(!Q.isEmpty()){
            L++; //큐에서 꺼내기 전에 증가하는게 맞다.
            int len = Q.size();
            for(int i = 0; i<len; i++){
                int[] p = Q.poll();
                for(int k = 0; k<4; k++){
                    int nx = p[0] + dx[k];
                    int ny = p[1] + dy[k];
                    if(nx>=0 && nx<7 && ny>=0 && ny<7 && board[nx][ny]==0){
                        board[nx][ny] = 1; //체크배열과 겸용 똑똑하네
                        Q.offer(new int[]{nx, ny});
                        dist[nx][ny] = L;
                    }
                }
            }
        }
        if(dist[6][6]==0) return -1;
        return dist[6][6];
    }

    public static void main(String[] args){
        P4T T = new P4T();
        int[][] arr={{0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 1, 0},
                {0, 0, 0, 1, 0, 0, 0},
                {1, 1, 0, 1, 0, 1, 1},
                {1, 1, 0, 1, 0, 0, 0},
                {1, 0, 0, 0, 1, 0, 0},
                {1, 0, 1, 0, 0, 0, 0}};
        System.out.println(T.solution(arr));
    }
}
