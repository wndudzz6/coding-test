package boj.단기간성장;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//백조의 호수
public class P3197 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static char[][] board;
    static Queue<int[]> Q = new LinkedList<>();
    static Queue<int[]> nextQ = new LinkedList<>();
    static int[][] dist;
    static int r, c;

    static void BFS(){
        int L = 0;
        while(!Q.isEmpty()){
            int len = Q.size();
            for(int k = 0; k<len; k++){
                int[] cur = Q.poll();
                for(int i = 0; i<4; i++){
                    int x = cur[0]+dx[i];
                    int y = cur[1]+dy[i];
                    if(x>=0 && x<r && y>=0 && y<c && board[x][y] == 'X' && dist[x][y]> L){
                        board[x][y] = '.';
                        dist[x][y] = L;
                        Q.offer(new int[]{x,y});
                    }
                }
            }L++;
        }
    }

    //백조가 두 마리인데 한마리만 이동하고 있음
    //그리고 -1이 아니라 0을 반환 중
    static int findSwan(int[] s, int[]e){
        int answer = -1;
        nextQ.offer(s);
        int[][] visited = new int[r][c];
        visited[s[0]][s[1]] = 1;
        int L = 0;
        while(!nextQ.isEmpty()){
            int len = nextQ.size();
            for(int i = 0; i<len; i++){
                int[] cur = nextQ.peek();
                int x = cur[0];
                int y = cur[1];
                if(x==e[0] && y==e[1]) return L;
                if(dist[x][y] <= L){
                    nextQ.poll();
                    for(int k = 0; k<4; k++){
                        int nx = x+dx[k];
                        int ny = y+dy[k];
                        if(nx>=0 && nx<r && ny>=0 && ny<c){
                            nextQ.offer(new int[]{nx,ny});
                        }
                    }

                }
            }L++;
        }

        return answer;
    }

    static int solution(){
        int[] s = new int[2];
        int[] e= new int[2];
        boolean flag = false;
        //.은 물 'X'빙판 'L' 백조
        for(int i = 0; i<r; i++) {
            for (int j = 0; j < c; j++) {
                if (board[i][j] == ',') {
                    Q.offer(new int[]{i, j});
                    BFS();
                }
                if (board[i][j] == 'L') {
                    s[0] = i;
                    s[1] = j;
                    flag = true;
                }
                if (flag && board[i][j] == 'L') {
                    e[0] = i;
                    e[1] = j;
                }
            }
        }

        return findSwan(s,e);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        r = sc.nextInt();
        c = sc.nextInt();
        board = new char[r][c];
        dist = new int[r][c];

        for(int i = 0; i<r; i++){
            String s = sc.next();
            for(int j = 0; j<c; j++){
                char x = s.charAt(j);
                board[i][j] = x;
                if(x=='X') dist[i][j] = Integer.MAX_VALUE;
            }
        }
        sc.close();
        System.out.println(solution());
    }
}
