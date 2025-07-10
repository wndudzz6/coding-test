package bfs;

import java.util.LinkedList;
import java.util.Queue;

//4. 미로 최단거리 통로
//정석적으로 푼듯? 10분정도만에 풂
public class P4 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static class Point{
        int x;
        int y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public int solution(int[][] board){
        Queue<Point> Q = new LinkedList<>();
        int n = board.length;
        int[][] ch = new int[n][n];
        ch[0][0] = 1;
        Q.add(new Point(0, 0)); //시작
        int L = 0;
        while(!Q.isEmpty()){
            int len = Q.size();
            for(int i= 0; i<len; i++){
                Point p = Q.poll();
                if(p.x==n-1 && p.y==n-1){
                    return L;
                }
                for(int j = 0; j<4; j++){
                    int nx = p.x+dx[j];
                    int ny = p.y+dy[j];

                    if(nx>=0 && nx<n && ny>=0 && ny<n &&board[nx][ny]==0 && ch[nx][ny]==0){
                        ch[nx][ny] = 1;
                        Q.add(new Point(nx,ny));
                    }
                }
            }L++;
        }

        return -1;
    }

    public static void main(String[] args){
        P4 T = new P4();
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
