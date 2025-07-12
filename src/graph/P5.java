package graph;
import java.util.*;

//5. 공굴리기
//BFS랑 방향 관리하는건 괜찮은데 공을 한 칸씩 이동시킨게 틀린 원인이라고 함
public class P5 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public int solution(int[][] board, int[] s, int[] e){
        int n = board.length;
        int m = board[0].length;
        int visited[][][] = new int[n][m][4]; //방향까지 관리 같은 방향일 때 같은 좌표만 중복아니면 됨
        Queue<int[]> Q = new LinkedList<>();
        int a = s[0]; int b = s[1];
        for(int i = 0; i<4; i++){
            int nx = a+dx[i];
            int ny = b+dy[i];
            if(nx>=0 && nx<n && ny>=0 && ny<m){
                visited[nx][ny][i] = 1;
                Q.offer(new int[]{nx, ny, i}); //방향까지
            }
            //처음 시작 정상적인 애들만 큐에 넣고
        }
        int L = 1;
        while(!Q.isEmpty()){
            int len = Q.size();
            for(int i = 0; i<len ; i++){
                int[] cur = Q.poll();
                int x = cur[0]; int y =  cur[1]; int d = cur[2];
                if(x==e[0] && y== e[1]) return L;
                int nx = x+dx[d];
                int ny = y+dy[d];
                if(nx<0 || nx>=n || ny<0 || ny>=m || board[nx][ny] != 0){
                    for(int k = 0; k<4; k++){
                        if(k==d) continue;
                        int nnx = x+dx[k];
                        int nny = y+dy[k];
                        if(nnx<0 || nnx>=n || nny<0 || nny>=m || visited[nnx][nny][k] != 0 ) continue;
                        visited[nnx][nny][k] = 1;
                        Q.offer(new int[]{nnx, nny, k});
                    }
                }else if(nx>= 0 && nx<n && ny>=0 && ny<m && board[nx][ny] == 0 && visited[nx][ny][d] == 0){
                    visited[nx][ny][d] = 1;
                    Q.offer(new int[] { nx, ny, d});
                }
            }L++;
        }

        return -1;
    }
    public static void main(String[] args){
        P5 T = new P5();
        System.out.println(T.solution(new int[][]{{0, 0, 1, 0, 0, 0}, {0, 0, 1, 0, 0, 0}, {0, 0, 0, 0, 1, 0}, {1, 0, 1, 1, 1, 0}, {1, 0, 0, 0, 0, 0}}, new int[]{1, 0}, new int[]{4, 5}));
        System.out.println(T.solution(new int[][]{{0, 0, 1, 0, 0, 0}, {0, 0, 1, 0, 0, 0}, {0, 0, 0, 0, 1, 0}, {1, 0, 1, 1, 1, 0}, {1, 0, 0, 0, 0, 0}}, new int[]{0, 0}, new int[]{4, 2}));
        System.out.println(T.solution(new int[][]{{1, 0, 1, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 1, 0}, {1, 1, 0, 1, 1}, {0, 0, 0, 0, 0}}, new int[]{0, 3}, new int[]{4, 2}));
        System.out.println(T.solution(new int[][]{{0, 1, 0, 1, 0, 0}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 0}, {0, 1, 1, 0, 1, 1}, {0, 0, 0, 0, 0, 0}}, new int[]{0, 0}, new int[]{4, 5}));
        System.out.println(T.solution(new int[][]{{0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0}, {0, 1, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 0, 0, 0}, {0, 0, 1, 0, 0, 0, 0, 0}}, new int[]{0, 0}, new int[]{4, 3}));
    }
}
