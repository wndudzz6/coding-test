package boj.hyndaeatuo.simulation;

import java.util.*;

//마법사 상어와 비바라기
public class P21610 {
    static int n, m;
    static int[][] board,cmd;
    static int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};//대각선 1 3 5 7
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};

    static int solution() {
        int answer = 0;
        Queue<int[]> cloudQ = new LinkedList<>();

        cloudQ.offer(new int[]{n,1});
        cloudQ.offer(new int[]{n,2});
        cloudQ.offer(new int[]{n-1,1});
        cloudQ.offer(new int[]{n-1,2});

        for(int i = 0; i<m; i++){
            boolean[][] ch = new boolean[n+1][n+1];
            List<int[]> movedClouds = new ArrayList<>();
            int d = cmd[i][0]-1;
            int dis = cmd[i][1];
            if(cloudQ.isEmpty()) return -1;
            int size = cloudQ.size();
            for(int j=0; j<size; j++) {
                int[] cloud = cloudQ.poll();
                // 1-based 인덱스 기준
                int nx = ((cloud[0] - 1 + dx[d] * dis) % n + n) % n + 1;
                int ny = ((cloud[1] - 1 + dy[d] * dis) % n + n) % n + 1;

//                int nx = cloud[0] + (dx[d] * dis);
//                int ny = cloud[1] + (dy[d] * dis);
//                if(nx>n) nx=nx-n;
//                if(ny<=0) ny = n+ny;
//                if(ny>n) ny = ny-n;
                board[nx][ny]++;
                ch[nx][ny] = true;
                movedClouds.add(new int[]{nx,ny});

            }
            for(int[] pos : movedClouds){
                int x = pos[0];
                int y = pos[1];
                int cnt = 0;
                for(int k = 1; k<=7; k+=2) {
                    int dnx = x + dx[k];
                    int dny = y + dy[k];
                    if (dnx > 0 && dnx <= n && dny > 0 && dny <= n) {
                        if (board[dnx][dny] >= 1) cnt++;
                    }
                }
                board[x][y] += cnt;
            }
            for(int x = 1; x <= n; x++) {
                for (int y = 1; y <= n; y++) {
                    if (!ch[x][y] && board[x][y] >= 2) {
                        cloudQ.offer(new int[]{x, y});
                        board[x][y] -= 2; //명령하지 않더라도 구름이 생기면 반영한다
                    }
                }
            }
        }

        for(int i =1; i<=n; i++) {
            for(int j = 1; j<=n; j++){
                answer += board[i][j];
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        board = new int[n+1][n+1];
        cmd = new int[m][2];
        //보드
        for(int i = 1; i<=n; i++){
            for(int j = 1; j<=n; j++){
                board[i][j] = sc.nextInt();
            }
        }
        //명령
        for(int i = 0; i<m; i++){
            cmd[i][0] = sc.nextInt();
            cmd[i][1] = sc.nextInt();
        }
        sc.close();
        System.out.println(solution());
    }

}
