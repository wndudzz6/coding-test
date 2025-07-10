package bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//시간초과;;
//6.숲속의 기사
public class P6 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static class A{
        int[] pos;
        int dist;
        A(int[] pos, int dist){
            this.pos = pos;
            this.dist = dist;
        }
    }

    static int BFS(int[] s, int[] e, int[][] board, int r, int c){
        int[][] map = new int[r][c];
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                map[i][j] = board[i][j];
            }
        }
        Queue<int[]> Q = new LinkedList<>();
        Q.offer(s);
        map[s[0]][s[1]] = -1; //현재 서 있는 위치
        int L = 0;
        while(!Q.isEmpty()){
            int len = Q.size();
            for(int i = 0; i<len; i++){
                int[] cur = Q.poll();
                if(cur[0]==e[0] && cur[1]==e[1]){
                    return L;
                }
                for(int k = 0; k < 4; k++){
                    int nx = cur[0] + dx[k];
                    int ny = cur[1] + dy[k];
                    if(nx>=0 && nx<r && ny>=0 && ny<c && (map[nx][ny] != 1 )){
                        map[nx][ny] = -1;
                        Q.offer(new int[]{nx, ny});
                    }
                }
            }
            L++;
        }
        return 100000;
    }

    public int solution(int[][] board){
        int answer = Integer.MAX_VALUE;
        int r = board.length;
        int c = board[0].length;
        int[] s = new int[2];
        int[] k = new int[2]; //기사 위치
        ArrayList<A> raspberry = new ArrayList<>();
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(board[i][j]==2){
                    s[0] = i;
                    s[1] = j;
                }
                if(board[i][j]==3){
                    k[0] = i;
                    k[1] = j;
                }
            }
        }
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(board[i][j]==4){
                    raspberry.add(new A(new int[]{i,j}, BFS(s,new int[]{i,j},board, r,c)));
                }
            }
        }
        for(A x : raspberry){
            int sum = x.dist;
            sum+= BFS(new int[]{x.pos[0], x.pos[1]},k, board,r,c);
            answer = Math.min(answer, sum);
        }

        return answer;
    }

    public static void main(String[] args){
        P6 T = new P6();
        System.out.println(T.solution(new int[][]{{4, 1, 0, 0, 0, 0, 1, 0},
                {0, 0, 0, 1, 0, 1, 0, 0},
                {0, 2, 1, 1, 3, 0, 4, 0},
                {0, 0, 0, 4, 1, 1, 1, 0}}));
        System.out.println(T.solution(new int[][]{{3, 0, 0, 0, 1, 4, 4, 4},
                {0, 1, 1, 0, 0, 0, 1, 0},
                {0, 1, 4, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0},
                {1, 0, 1, 0, 0, 1, 1, 0},
                {4, 0, 0, 0, 1, 0, 0, 0},
                {4, 1, 0, 0, 1, 0, 0, 0},
                {4, 0, 0, 0, 0, 0, 1, 2}}));
        System.out.println(T.solution(new int[][]{{4, 1, 0, 1, 0},
                {0, 1, 0, 1, 0},
                {0, 0, 2, 3, 4},
                {0, 1, 0, 1, 0}}));
    }
}
