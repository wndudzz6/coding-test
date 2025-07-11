package graph;

import java.util.LinkedList;
import java.util.Queue;

//평범한 BFS로 시도했다가 실패
//최적해를 보장해주지 않는다
public class P3 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    public int solution(int[][] board) {
        int answer = Integer.MAX_VALUE;
        int n = board.length;
        int m = board[0].length;
        Queue<int[]> Q = new LinkedList<>();
        Q.offer(new int[]{0, 0});
        board[0][0] = -1; //ch배열 겸
        int cnt = 0;
        boolean flag = true; //사방이 막혔는가?
        while(!Q.isEmpty()) {
            int len = Q.size();
            for(int i = 0; i<len; i++){
                int[] p = Q.poll();

                if(p[0]== n-1 && p[1]== m-1){
                    answer = Math.min(cnt, answer);
                }

                for(int k = 0; k<4; k++){
                    int nx = p[0]+dx[k];
                    int ny = p[1]+dy[k];
                    if(nx>= 0 && nx<n && ny>=0 && ny<m){
                        if(board[nx][ny] == 0){
                            board[nx][ny] = 1;
                            Q.offer(new int[]{nx, ny});
                            flag = false;
                        }
                    }
                }//사방이 막힌 상태
                if(flag){
                    for(int k = 0; k<4; k++){
                        int nx = p[0]+dx[k];
                        int ny = p[1]+dy[k];
                        if(nx>= 0 && nx<n && ny>=0 && ny<m && board[nx][ny] ==1){
                            cnt++;
                            board[nx][ny] = -1;
                            Q.offer(new int[]{nx, ny});
                        }
                    }
                }
            }
        }

        return answer;
    }

    public static void main(String[] args){
        P3 T = new P3();
        System.out.println(T.solution(new int[][]{{0, 1, 1, 0}, {1, 0, 0, 1}, {0, 1, 0, 0}}));
        System.out.println(T.solution(new int[][]{{0, 1, 1, 0},{1, 1, 0, 1},{0, 0, 1, 0}, {0, 1, 1, 1}, {0, 1, 1, 0}}));
        System.out.println(T.solution(new int[][]{{0, 1, 1, 0, 1, 1},{0, 1, 1, 1, 1, 1},{1, 0, 0, 0, 1, 1}, {1, 1, 0, 1, 1, 1}, {1, 1, 0, 1, 1, 0}, {1, 0, 0, 1, 1, 1}, {1, 1, 1, 1, 1, 0}}));
        System.out.println(T.solution(new int[][]{{0, 1, 1, 0, 1, 1, 1}, {1, 1, 1, 0, 1, 1, 1}, {1, 0, 0, 0, 0, 1, 1}, {1, 1, 1, 0, 1, 1, 1}, {1, 1, 1, 0, 1, 1, 0}, {1, 0, 1, 0, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 0}}));
        System.out.println(T.solution(new int[][]{{0, 0, 1, 0, 1, 1, 1},{1, 1, 0, 0, 1, 1, 1},{1, 1, 0, 1, 0, 1, 1}, {0, 0, 1, 0, 1, 1, 1}, {1, 0, 1, 0, 1, 1, 0}, {1, 0, 1, 0, 1, 1, 1}, {1, 0, 0, 1, 1, 1, 1}, {1, 1, 0, 0, 1, 1, 1}, {1, 1, 0, 1, 1, 1, 0}}));
    }
}
